package com.fokantech.image;

import com.fokantech.conf.ImageUI;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.junit.Test;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class DrawBufferedImage {

    public static void main(String[] args) throws Exception {
        String path = "E:\\Result\\1_RES";
        String imagePath = "E:\\Result\\1_IMG";
        List<String> doubles = new ArrayList<>();
        File[] files = new File(path).listFiles();
        for (int i = 0; i < files.length; i++) {
            String imageName = files[i].getName().substring(0, files[i].getName().length() - 4);
            SAXReader saxReader = new SAXReader();
            Document document = saxReader.read(files[i]);
            Element annotation = document.getRootElement();
            Element object = annotation.element("object");
            Element bndbox = object.element("bndbox");
            double x1 = Integer.parseInt(bndbox.element("x1").getStringValue());
            double x2 = Integer.parseInt(bndbox.element("x2").getStringValue());
            double x3 = Integer.parseInt(bndbox.element("x3").getStringValue());
            double x4 = Integer.parseInt(bndbox.element("x4").getStringValue());
            double y1 = Integer.parseInt(bndbox.element("y1").getStringValue());
            double y2 = Integer.parseInt(bndbox.element("y2").getStringValue());
            double y3 = Integer.parseInt(bndbox.element("y3").getStringValue());
            double y4 = Integer.parseInt(bndbox.element("y4").getStringValue());
            double a = (y4 - y1) * (x3 - x1);
            double triangle1 = (x3 - x2) * (y3 - y2) / 2;
            double triangle2 = (x3 - x4) * (y4 - y3) / 2;
            double triangle3 = (x4 - x1) * (y4 - y1) / 2;
            double triangle4 = (x2 - x1) * (y1 - y2) / 2;
            int area = (int) (a - triangle1 - triangle2 - triangle3 - triangle4);
            File file = new File(imagePath +"\\"+ imageName + ".jpg");
            System.out.println(imageName);
            BufferedImage bufferedImage = ImageIO.read(file);
            System.out.println(imageName);
            double flag = 0.00001;
            double v = 0;
//           if (x1>=x4 && y4>y1){
//               double k1 = (x1-x4) / (y4-y1);
//               double n = Math.atan(k1);
//               double v = Math.toDegrees(n);
//               doubles.add(String.valueOf(v));
//           }else if (x2>=x1 && y2>y1){
//               double k1 = (x2-x1) / (y2-y1);
//               double n = Math.atan(k1);
//               v = Math.toDegrees(n);
//               doubles.add(String.valueOf(v));
//           }else if (x2>=x1 && y1>y2){
//                double k1 = (y1-y2) / (x2-x1);
//                double n = Math.atan(k1);
//                v = Math.toDegrees(n);
//                doubles.add(String.valueOf(v));
//            }else if ((x4>=x1) && (y4>y1)){
//                double k1 = (x4-x1) / (y4 - y1);
//                double n = Math.atan(k1);
//                double v = Math.toDegrees(n);
//                doubles.add(String.valueOf(v));
//            }
//
//            if (y3 > y4 && x3 > x4){
//                double k = (y3 - y4) / (x3 - x4);
//                double atan = Math.atan(k);
//                double v = Math.toDegrees(atan);
//                System.out.println(v);
//            }
            if (x1 != x4) {
                double kAB = (y2 - y1) / (x2 - x1);
                double kAC = (y4 - y1) / (x4 - x1);
                double tan = (kAB - kAC) / (1 + (kAB * kAC));
                v = (int) Math.abs(Math.toDegrees(Math.atan(tan)));
            } else {
                double kAB = (y2 - y1) / (x2 - x1);
                double kAC = (y4 - y1) / ((x4 - x1) + +flag);
                double tan = (kAB - kAC) / (1 + (kAB * kAC));
                v = (int) Math.abs(Math.toDegrees(Math.atan(tan)));
            }
            if (area <= 1000) {
                ImageIO.write(bufferedImage, "jpg", new File("C:\\Users\\FKT00093\\Desktop\\1000\\" + imageName + "_" + area + "-" + v + ".jpg"));
            } else if (area <= 1500) {
                ImageIO.write(bufferedImage, "jpg", new File("C:\\Users\\FKT00093\\Desktop\\1500\\" + imageName + "_" + area + "-" + v + ".jpg"));
            } else if (area <= 2000) {
                ImageIO.write(bufferedImage, "jpg", new File("C:\\Users\\FKT00093\\Desktop\\2000\\" + imageName + "_" + area + "-" + v + ".jpg"));
            } else if (area <= 2500) {
                ImageIO.write(bufferedImage, "jpg", new File("C:\\Users\\FKT00093\\Desktop\\2500\\" + imageName + "_" + area + "-" + v + ".jpg"));
            } else if (area <= 3000) {
                ImageIO.write(bufferedImage, "jpg", new File("C:\\Users\\FKT00093\\Desktop\\3000\\" + imageName + "_" + area + "-" + v + ".jpg"));
            } else if (area > 3000) {
                ImageIO.write(bufferedImage, "jpg", new File("C:\\Users\\FKT00093\\Desktop\\other\\" + imageName + "_" + area + "-" + v + ".jpg"));
            }

        }

    }

}
