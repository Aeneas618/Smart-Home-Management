package com.fokantech.image;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.List;

public class CropImage {


    public static void main(String[] args) throws Exception{
        cropImg("Z:\\datamark_80\\webapps\\imgrec\\img\\result\\test","Z:\\datamark_80\\webapps\\imgrec\\img\\result\\1");

    }
    public static void cropImg(String inputPath , String outputPath) throws Exception{

        File[] files = new File(inputPath).listFiles();
        for (File file : files) {
            String fileName = file.getName().substring(0, file.getName().length() - 4);
            System.out.println(fileName);
            String flag = file.getName().substring(file.getName().length() - 4, file.getName().length());
            File fileParent = new File(file.getParent());
            if (flag.equals(".xml")){
                SAXReader saxReader = new SAXReader();
                Document document = saxReader.read(file);
                Element rootElement = document.getRootElement();
                List<Element> objects = rootElement.elements("object");

                BufferedImage bufferedImage = ImageIO.read(new File("Z:\\datamark_80\\webapps\\imgrec\\img\\test\\" + fileName + ".jpg"));
                if (objects.size()>0 && bufferedImage != null){
                    for (int i = 0; i < objects.size(); i++) {
                        Element object = objects.get(i);
                        Element bndbox = object.element("bndbox");
                        int xmin = Integer.parseInt(bndbox.element("xmin").getStringValue());
                        int ymin = Integer.parseInt(bndbox.element("ymin").getStringValue());
                        int xmax = Integer.parseInt(bndbox.element("xmax").getStringValue());
                        int ymax = Integer.parseInt(bndbox.element("ymax").getStringValue());
                        BufferedImage cropImage = bufferedImage.getSubimage(xmin, ymin, xmax - xmin, ymax - ymin);
                        ImageIO.write(cropImage , "jpg", new File("C:\\Users\\FKT00093\\Desktop\\q\\" + fileName + ".jpg"));
                    }
                }
            }
        }
        System.out.println("结束");
    }


}
