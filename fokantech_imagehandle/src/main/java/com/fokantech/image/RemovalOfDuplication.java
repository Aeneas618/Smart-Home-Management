package com.fokantech.image;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class RemovalOfDuplication {
    public static void main(String[] args) throws Exception {
//        test1("E:\\test","E:\\test1");
        remove("E:\\test1");
    }

    public static void test1(String inputImagePath,String outputImagePath)throws Exception{
        File[] files = new File(inputImagePath).listFiles();
        int flag = 7;
        for (int i = 0; i < files.length; i++) {
            String fileName = files[i].getName();
            int index = fileName.indexOf("_");
            String plateName = fileName.substring(index + 1,fileName.length()-4);
            System.out.println(plateName);
            System.out.println(plateName.length());
            if (plateName.length() == flag){
                BufferedImage v
                        = ImageIO.read(files[i]);
                ImageIO.write(v,"jpg",new File(outputImagePath+"\\"+ plateName+".jpg"));
            }
        }
    }
    public static void remove(String inputImagePath)throws Exception{
        File[] files = new File(inputImagePath).listFiles();
        for (int i = 0; i < files.length; i++) {
            if(i%2==0){
                files[i].delete();
            }
        }
    }
}
