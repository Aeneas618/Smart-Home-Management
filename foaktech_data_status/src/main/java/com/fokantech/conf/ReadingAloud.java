package com.fokantech.conf;


import com.jacob.activeX.ActiveXComponent;
import com.jacob.com.Dispatch;
import com.jacob.com.Variant;

public class ReadingAloud {

    public static void readingAloud(String args) {
        ActiveXComponent sap = new ActiveXComponent("Sapi.SpVoice");
        try
        {
            sap.setProperty("Volume", new Variant(100));
            sap.setProperty("Rate", new Variant(1));
            Dispatch sapo = sap.getObject();
            Dispatch.call(sapo, "Speak", new Variant(args));
            sapo.safeRelease();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sap.safeRelease();
        }
    }

}
