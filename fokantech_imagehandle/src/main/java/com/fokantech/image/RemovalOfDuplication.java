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
        binaryImage();
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


    public static void binaryImage() throws IOException {
        File file = new File( "C:\\Users\\FKT00093\\Desktop\\1\\01.jpg");
        BufferedImage image = ImageIO.read(file);

        int width = image.getWidth();
        int height = image.getHeight();

        BufferedImage grayImage = new BufferedImage(width, height, BufferedImage.TYPE_BYTE_BINARY);//重点，技巧在这个参数BufferedImage.TYPE_BYTE_BINARY
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                int rgb = image.getRGB(i, j);
                grayImage.setRGB(i, j, rgb);
            }
        }
        ImageIO.write(grayImage, "jpg", new File("D:\\1.jpg"));
    }


}
