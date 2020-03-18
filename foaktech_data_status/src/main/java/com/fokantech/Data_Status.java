package com.fokantech;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Data_Status {

    public static final List<String> widths = new ArrayList<String>();
    public static final List<String> heights = new ArrayList<String>();

    public void averageValue(String args) throws DocumentException
    {
        File[] files = new File(args).listFiles();
        /**
         * 批量处理文件
         */
        for (int i = 0; i < files.length; i++)
        {
            if (files[i].getName().substring(files[i].getName().length()-4, files[i].getName().length()).equals(".xml"))
            {
                SAXReader saxReader =
                                    new SAXReader();
                Document document =
                                    saxReader.read(files[i]);
                Element rootElement =
                                    document.getRootElement();
                List<Element> objects =
                                    rootElement.elements("object");

                for (int j = 0; j < objects.size(); j++) {
                    String name =
                                    objects.get(j).element("name").getStringValue();
                    if (name.equals("car"))
                    {
                        Element bndbox =
                                        objects.get(j).element("bndbox");
                        Integer xmax =
                                        Integer.parseInt(bndbox.element("xmax").getStringValue());
                        Integer xmin =
                                        Integer.parseInt(bndbox.element("xmin").getStringValue());
                        Integer width =
                                        xmax - xmin ;
                        widths.add(String.valueOf(width));
                        Integer ymax =
                                        Integer.parseInt(bndbox.element("ymax").getStringValue());
                        Integer ymin =
                                        Integer.parseInt(bndbox.element("ymin").getStringValue());
                        Integer height =
                                        ymax - ymin ;
                        heights.add(String.valueOf(height));
                    }
                }
            }
        }
        float a = 0;
        for (int i = 0; i < widths.size(); i++) {
            a = a + Float.valueOf(widths.get(i));
        }
        float average_a = a / widths.size();
        System.out.println("computer width："+widths.size()+"次");
        System.out.println("width average value："+average_a);

        float b = 0;
        for (int i = 0; i < heights.size(); i++) {
            b = b + Float.valueOf(heights.get(i));
        }
        float average_b = b / heights.size();
        System.out.println("computer height："+heights.size()+"次");
        System.out.println("height average value："+average_b);
    }

    public static void main(String[] args) throws DocumentException {
        Data_Status ds = new Data_Status();
        ds.averageValue("Z:\\2020\\20200109");
    }
}
