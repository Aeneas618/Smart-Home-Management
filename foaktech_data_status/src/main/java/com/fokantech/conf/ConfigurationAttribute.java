package com.fokantech.conf;

import com.jacob.activeX.ActiveXComponent;
import com.jacob.com.Dispatch;
import com.jacob.com.Variant;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

public class ConfigurationAttribute extends JComponent
{
    private BufferedImage bufferedImage;
    public static final String APPID = "16315874";
    public static final String APIKEY = "ujYmHGQtIRgiriIp1soW9irT";
    public static final String SECRETKEY = "CBN0uklyL4gPACbZWKHjjb4M3ZgxGW7j";
    public static final String CCPD_BASE = "D:\\BaiduNetdiskDownload\\CCPD2019\\ccpd_base";
    public static final String CCPD_BLUR = "D:\\BaiduNetdiskDownload\\CCPD2019\\ccpd_blur";
    public static final String CCPD_CHALLENGE = "D:\\BaiduNetdiskDownload\\CCPD2019\\ccpd_challenge";
    public static final String CCPD_DP = "D:\\BaiduNetdiskDownload\\CCPD2019\\ccpd_db";
    public static final String CCPD_FN = "D:\\BaiduNetdiskDownload\\CCPD2019\\ccpd_fn";
    public static final String CCPD_NP = "D:\\BaiduNetdiskDownload\\CCPD2019\\ccpd_np";
    public static final String CCPD_ROTATE = "D:\\BaiduNetdiskDownload\\CCPD2019\\ccpd_rotate";
    public static final String CCPD_TILT = "D:\\BaiduNetdiskDownload\\CCPD2019\\ccpd_tilt";
    public static final String CCPD_WEATHER = "D:\\BaiduNetdiskDownload\\CCPD2019\\ccpd_weather";

    public ConfigurationAttribute()
    {
        this.bufferedImage=null;
    }

    @Override
    protected void paintComponent(Graphics g)
    {
        Graphics2D gd2d = (Graphics2D) g;
        if (bufferedImage == null){
            gd2d.setPaint(Color.BLACK);
            gd2d.fillRect(0,0,this.getWidth(),this.getHeight());
        }else {
            gd2d.drawImage(bufferedImage,0,0,this.getWidth(),this.getHeight(),null);
        }
    }
    public void imshow(String title , BufferedImage bufferedImage)
    {
        this.bufferedImage = bufferedImage;
        JDialog ui = new JDialog();
        ui.setTitle(title);
        ui.getContentPane().setLayout(new BorderLayout());
        ui.getContentPane().add(this,BorderLayout.CENTER);
        ui.setSize(bufferedImage.getWidth()+1,bufferedImage.getHeight()+1);
        ui.setVisible(true);
        this.repaint();
    }
    public void readingAloud(String text)
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
            Dispatch.call(sapo, "Speak", new Variant(text));
        } catch (Exception e)
        {
            e.printStackTrace();
        } finally
        {
            sapo.safeRelease();
            sap.safeRelease();
        }
    }
    public List<String> plates()
    {
        List<String> pList = new ArrayList<String>();
        pList.add("苏FF76Z5");
        pList.add("苏D132MS");
        pList.add("苏KS027P");
        pList.add("苏E7ES09");
        pList.add("苏UKX307");
        pList.add("苏E3H06X");
        pList.add("苏E27LC9");
        pList.add("苏E9GN53");
        pList.add("苏E98Y1S");
        pList.add("苏E70N6S");
        pList.add("苏J3BH19");
        pList.add("沪B2A029");
        pList.add("沪BZL112");
        pList.add("苏E66ZM1");
        pList.add("苏AU0X10");
        pList.add("苏E6N07E");
        pList.add("苏B176WK");
        pList.add("吉HUW909");
        pList.add("苏AUH535");
        pList.add("苏BM99X3");
        pList.add("京Q5J6P6");
        pList.add("皖A218UA");
        pList.add("苏EK187M");
        pList.add("苏EU976U");
        pList.add("沪C839MM");
        pList.add("皖CV3638");
        pList.add("苏E30T38");
        pList.add("沪M09886");
        pList.add("沪C3Z830");
        pList.add("苏E3B91P");
        pList.add("苏KC9H80");
        pList.add("苏HC7967");
        pList.add("苏N833M3");
        pList.add("苏BD7230");
        pList.add("苏H99E89");
        pList.add("苏FF76Z5");
        pList.add("皖DX2736");
        pList.add("沪C908Z0");
        pList.add("皖L41D00");
        pList.add("沪A6A876");
        pList.add("苏E7ES09");
        pList.add("豫S38Q55");
        pList.add("苏KS027P");
        pList.add("苏D0NF71");
        pList.add("皖E64936");
        pList.add("苏D2XC87");
        pList.add("苏A4150N");
        pList.add("沪C9Q8Z0");
        pList.add("沪ANM526");
        pList.add("苏M7X982");
        pList.add("沪JD1383");
        pList.add("皖AD2L88");
        pList.add("苏EP169K");
        pList.add("苏H6155C");
        pList.add("苏E0GV50");
        pList.add("沪B38D78");
        pList.add("沪AFB7950");
        pList.add("苏E32ST0");
        pList.add("皖B0X572");
        pList.add("苏E1Y8P6");
        pList.add("沪C8E0Q5");
        pList.add("苏EW83C8");
        pList.add("苏E33X50");
        pList.add("苏E70N6S");
        pList.add("苏J3BH19");
        pList.add("苏E98Y1S");
        pList.add("沪B2A029");
        pList.add("沪BPS985");
        pList.add("苏ER971H");
        pList.add("沪EFU750");
        pList.add("沪BZL112");
        pList.add("苏E267P8");
        pList.add("苏DG22U8");
        pList.add("沪FBB786");
        pList.add("沪A68J75");
        pList.add("苏E7SL95");
        pList.add("豫QQ1415");
        pList.add("沪C708SV");
        pList.add("苏E310H7");
        pList.add("苏USC109");
        pList.add("沪L05399");
        pList.add("沪A0T723");
        pList.add("苏B6W5X1");
        pList.add("苏B8RL15");
        pList.add("苏E7FB57");
        pList.add("苏M1T881");
        pList.add("苏BKJ960");
        pList.add("苏EF96G1");
        pList.add("苏D07B22");
        pList.add("苏EK187M");
        pList.add("沪C908Z0");
        pList.add("沪CN799S");
        pList.add("皖SXZ676");
        pList.add("苏BW27V6");
        pList.add("苏MF9P39");
        pList.add("苏E6N07E");
        pList.add("苏B6W5X1");
        pList.add("沪LB1867");
        pList.add("苏BQ32L7");
        pList.add("苏UQP290");
        pList.add("苏E3Y1U7");
        pList.add("苏E7502K");
        pList.add("沪AFX1636");
        pList.add("苏EE2328");
        pList.add("沪JG8899");
        pList.add("粤D74698");
        pList.add("苏EA2F50");
        pList.add("苏B5SK61");
        pList.add("苏DH918B");
        pList.add("苏B1WL84");
        pList.add("沪DD9725");
        pList.add("皖FB1D92");
        pList.add("苏DZ5535");
        pList.add("沪KT6559");
        pList.add("沪K35307");
        pList.add("苏KH520U");
        pList.add("苏LP8651");
        pList.add("沪HZ8515");
        pList.add("苏A771PD");
        pList.add("沪KT3352");
        pList.add("沪GP8938");
        pList.add("苏A9D8P9");
        pList.add("苏B0723D");
        pList.add("苏E3891P");
        pList.add("苏HXY513");
        pList.add("苏B5UT86");
        pList.add("苏AG988G");
        pList.add("沪AFM6555");
        pList.add("苏B78R36");
        pList.add("沪G63009");
        pList.add("苏G2Y988");
        pList.add("苏E3128P");
        pList.add("苏D0MK09");
        pList.add("苏FCN335");
        pList.add("皖E64936");
        pList.add("苏UST660");
        pList.add("沪JD1383");
        pList.add("苏A77W8J");
        pList.add("苏UJY775");
        pList.add("沪BLS295");
        pList.add("苏USJ819");
        pList.add("苏K588QD");
        pList.add("苏B20F12");
        pList.add("苏D5K803");
        pList.add("苏B686Z8");
        pList.add("苏UZL321");
        pList.add("沪AFB7950");
        pList.add("苏E32ST0");
        pList.add("苏EB6R58");
        pList.add("沪AUD308");
        return pList;
    }
    public String[] provinces()
    {
        String[] provinces = {"皖", "沪", "津", "渝", "冀", "晋", "蒙", "辽", "吉", "黑", "苏", "浙", "京", "闽", "赣", "鲁", "豫", "鄂", "湘", "粤", "桂", "琼", "川", "贵", "云", "藏", "陕", "甘", "青", "宁", "新", "警", "学", "O"};
        return provinces;
    }
    public String[] alphabets()
    {
        String[] alphabets = {"A", "B", "C", "D", "E", "F", "G", "H", "J", "K", "L", "M", "N", "P", "Q", "R", "S", "T", "U", "V", "W",
                "X", "Y", "Z", "O"};
        return alphabets;
    }
    public String[] numbers()
    {
        String[] numbers = {"A", "B", "C", "D", "E", "F", "G", "H", "J", "K", "L", "M", "N", "P", "Q", "R", "S", "T", "U", "V", "W",
                "X", "Y", "Z", "O", "1", "2", "3", "4", "5", "6", "7", "8", "9", "O"};
        return numbers;
    }
}
