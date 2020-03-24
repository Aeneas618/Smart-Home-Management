package com.fokantech;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.List;

public class CropImage {

    public static void cropImage(String filepath) throws Exception {
        File[] files = new File(filepath).listFiles();
        for (int j = 0; j < files.length; j++) {
            SAXReader saxReader = new SAXReader();
            Document document = saxReader.read(files[j]);
            Element annotation = document.getRootElement();
            List<Element> objects = annotation.elements("object");
            String subImageName = files[j].getName().substring(0, files[j].getName().length()-4);
            BufferedImage buff = ImageIO.read(new File("C:\\Users\\tangxiao\\Desktop\\20200109\\"+subImageName+".jpg"));
            for (int i = 0; i < objects.size(); i++) {
                Element object = objects.get(i);
                String name = object.element("name").getStringValue();
                if (name.equals("car")) {
                    Element bndbox = object.element("bndbox");
                    int xmin = Integer.parseInt(bndbox.element("xmin").getStringValue());
                    int ymin = Integer.parseInt(bndbox.element("ymin").getStringValue());
                    int xmax = Integer.parseInt(bndbox.element("xmax").getStringValue());
                    int ymax = Integer.parseInt(bndbox.element("ymax").getStringValue());
                    BufferedImage cropImage = buff.getSubimage(xmin, ymin, xmax - xmin, ymax - ymin);
                    ImageIO.write(cropImage , "jpg", new File("C:\\Users\\tangxiao\\Desktop\\cropimage\\" + "cropimage_" +j+"_"+ i + ".jpg"));
                }
            }
        }
    }
    public static void main(String[] args) throws Exception {
        cropImage("C:\\Users\\tangxiao\\Desktop\\res");
    }
}
