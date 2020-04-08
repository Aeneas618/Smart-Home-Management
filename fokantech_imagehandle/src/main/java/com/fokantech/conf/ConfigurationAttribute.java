package com.fokantech.conf;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

public class ConfigurationAttribute extends JComponent
{

    public static final String APPID = "16315874";
    public static final String APIKEY = "ujYmHGQtIRgiriIp1soW9irT";
    public static final String SECRETKEY = "CBN0uklyL4gPACbZWKHjjb4M3ZgxGW7j";

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
