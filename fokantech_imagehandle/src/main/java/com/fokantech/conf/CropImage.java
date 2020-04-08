package com.fokantech.conf;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class CropImage {

    public static void main(String[] args) throws DocumentException, IOException {
        crop("Z:\\datamark_80\\webapps\\imgrec\\img\\result\\20200104","Z:\\datamark_80\\webapps\\imgrec\\img\\20200104");
//        crop("Z:\\fokantech\\YangChengHu\\Calibrated Data\\pictures-1\\34","Z:\\fokantech\\YangChengHu\\Image Data\\pictures1_jpg\\34");
//        crop("Z:\\fokantech\\YangChengHu\\Calibrated Data\\pictures-1\\33","Z:\\fokantech\\YangChengHu\\Image Data\\pictures1_jpg\\33");
//        crop("Z:\\fokantech\\YangChengHu\\Calibrated Data\\pictures-1\\32","Z:\\fokantech\\YangChengHu\\Image Data\\pictures1_jpg\\32");
//        crop("Z:\\fokantech\\YangChengHu\\Calibrated Data\\pictures-1\\31","Z:\\fokantech\\YangChengHu\\Image Data\\pictures1_jpg\\31");
//        crop("Z:\\fokantech\\YangChengHu\\Calibrated Data\\pictures-1\\30","Z:\\fokantech\\YangChengHu\\Image Data\\pictures1_jpg\\30");
//        crop("Z:\\fokantech\\YangChengHu\\Calibrated Data\\pictures-1\\28","Z:\\fokantech\\YangChengHu\\Image Data\\pictures1_jpg\\29");
//        crop("Z:\\fokantech\\YangChengHu\\Calibrated Data\\pictures-1\\27","Z:\\fokantech\\YangChengHu\\Image Data\\pictures1_jpg\\27");
//        crop("Z:\\fokantech\\YangChengHu\\Calibrated Data\\pictures-1\\26","Z:\\fokantech\\YangChengHu\\Image Data\\pictures1_jpg\\26");
//        crop("Z:\\fokantech\\YangChengHu\\Calibrated Data\\pictures-1\\25","Z:\\fokantech\\YangChengHu\\Image Data\\pictures1_jpg\\25");
//        crop("Z:\\fokantech\\YangChengHu\\Calibrated Data\\pictures-1\\24","Z:\\fokantech\\YangChengHu\\Image Data\\pictures1_jpg\\24");
//        crop("Z:\\fokantech\\YangChengHu\\Calibrated Data\\pictures-1\\23","Z:\\fokantech\\YangChengHu\\Image Data\\pictures1_jpg\\23");
//        crop("Z:\\fokantech\\YangChengHu\\Calibrated Data\\pictures-1\\21","Z:\\fokantech\\YangChengHu\\Image Data\\pictures1_jpg\\21");
//        crop("Z:\\fokantech\\YangChengHu\\Calibrated Data\\pictures-1\\32","Z:\\fokantech\\YangChengHu\\Image Data\\pictures1_jpg\\22");
//        crop("Z:\\fokantech\\YangChengHu\\Calibrated Data\\pictures-1\\19","Z:\\fokantech\\YangChengHu\\Image Data\\pictures1_jpg\\19");
//        crop("Z:\\fokantech\\YangChengHu\\Calibrated Data\\pictures-1\\18","Z:\\fokantech\\YangChengHu\\Image Data\\pictures1_jpg\\18");
//        crop("Z:\\fokantech\\YangChengHu\\Calibrated Data\\pictures-1\\17","Z:\\fokantech\\YangChengHu\\Image Data\\pictures1_jpg\\17");
//        crop("Z:\\fokantech\\YangChengHu\\Calibrated Data\\pictures-1\\16","Z:\\fokantech\\YangChengHu\\Image Data\\pictures1_jpg\\16");
//        crop("Z:\\fokantech\\YangChengHu\\Calibrated Data\\pictures-1\\15","Z:\\fokantech\\YangChengHu\\Image Data\\pictures1_jpg\\15");
     }
    public static void crop(String resPath , String readImagePath) throws DocumentException, IOException {
        File[] files = new File(resPath).listFiles();
        for (int i = 0; i < files.length ; i++) {
            String parent = new File(files[i].getParent()).getName();
            String imageName = files[i].getName().substring(0, files[i].getName().length() - 4);
            SAXReader saxReader = new SAXReader();
            Document document = saxReader.read(files[i]);
            Element annotation = document.getRootElement();
            List objects = annotation.elements("object");
            for (int j = 0; j < objects.size() ; j++) {
                Element object = (Element) objects.get(j);
                Element bndbox = object.element("bndbox");
                int x1 = Integer.parseInt(bndbox.element("xmin").getStringValue());
                int y1 = Integer.parseInt(bndbox.element("ymin").getStringValue());
                int x2 = Integer.parseInt(bndbox.element("xmax").getStringValue());
                int y2 = Integer.parseInt(bndbox.element("ymax").getStringValue());
                BufferedImage bufferedImage = ImageIO.read(new File(readImagePath + "\\"+imageName+".jpg"));
                BufferedImage subimage = bufferedImage.getSubimage(x1, y1, x2-x1, y2-y1);
                ImageIO.write(subimage,"jpg",new File("D:\\阳澄湖专项\\"+parent + "_" +imageName+"_"+i+"_"+j+".jpg"));
            }
        }
    }
}
