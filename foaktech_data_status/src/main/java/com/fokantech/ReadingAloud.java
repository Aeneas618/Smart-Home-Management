package com.fokantech;

import com.jacob.activeX.ActiveXComponent;
import com.jacob.com.Dispatch;
import com.jacob.com.Variant;

public class ReadingAloud
{
    public void readingAloud(String args)
    {
        ActiveXComponent sap = new ActiveXComponent("Sapi.SpVoice");
        Dispatch sapo = sap.getObject();
        try
        {
            sap.setProperty("Volume", new Variant(150));
            sap.setProperty("Rate", new Variant(-2));
            Variant defalutVoice = sap.getProperty("Voice");
            Dispatch dispdefaultVoice = defalutVoice.toDispatch();
            Variant allVoices = Dispatch.call(sapo, "GetVoices");
            Dispatch dispVoices = allVoices.toDispatch();
            Dispatch setvoice = Dispatch.call(dispVoices, "Item", new Variant(1)).toDispatch();
            ActiveXComponent voiceActivex = new ActiveXComponent(dispdefaultVoice);
            ActiveXComponent setvoiceActivex = new ActiveXComponent(setvoice);
            Variant item = Dispatch.call(setvoiceActivex, "GetDescription");
            Dispatch.call(sapo, "Speak", new Variant(args));
        } catch (Exception e)
        {
            e.printStackTrace();
        } finally
        {
            sapo.safeRelease();
            sap.safeRelease();
        }
    }
}
