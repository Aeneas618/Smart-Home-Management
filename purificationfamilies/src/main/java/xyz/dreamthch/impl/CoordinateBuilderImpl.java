package xyz.dreamthch.impl;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;
import xyz.dreamthch.mapper.CoordinateBuilder;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CoordinateBuilderImpl implements CoordinateBuilder {
    @Override
    public List<String> readText(String path) {
        List<String> strs = new ArrayList<>();
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(path);
            InputStreamReader isr  = new InputStreamReader(fis,"UTF-8");
            BufferedReader bufferedReader = new BufferedReader(isr);
            String str = "";
            while ((str = bufferedReader.readLine()) != null){
                if (str.lastIndexOf("---")<0){
                    strs.add(str);
                }
            }
            bufferedReader.close();
            isr.close();
            fis.close();
            return strs;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Map<String, Object> getCoordinateCenter(String txtData) {
        Map<String, Object> map = new HashMap<>();
        String txt= txtData.substring(7, txtData.length());
        String labelName = txt.substring(0, 4);
        String imageName = txt.substring(5,18);
        String coordinate = txt.substring(27, txt.length());
        int index1 = coordinate.indexOf("|");
        Integer x1 = Integer.valueOf(coordinate.substring(0, index1));
        String str1 = coordinate.substring(index1 + 1, coordinate.length());
        int index2 = str1.indexOf("|");
        Integer y1 = Integer.valueOf(str1.substring(0, index2));
        String str2 = str1.substring(index2 + 1, str1.length());
        int index3 = str2.indexOf("|");
        Integer x2 = Integer.valueOf(str2.substring(0, index3));
        String str3 = str2.substring(index3 + 1, str2.length());
        int index4 = str3.indexOf("|");
        Integer y2 = Integer.valueOf(str3.substring(0, index4));
        map.put("x1",x1);
        map.put("y1",y1);
        map.put("x2",x2);
        map.put("y2",y2);
        map.put("label",labelName);
        map.put("imageName",imageName);
        return map;
    }

    @Override
    public void createVOCDocument(Integer x1, Integer x2, Integer y1, Integer y2, String s, String label) {
        Document document = DocumentHelper.createDocument();
        Element annotation = document.addElement("annotation");
        Element object = annotation.addElement("object");
        Element name = object.addElement("name");
        name.setText(label);
        Element bndbox = object.addElement("bndbox");
        Element x11 = bndbox.addElement("x1");
        x11.setText(String.valueOf(x1));
        Element y11 = bndbox.addElement("y1" );
        y11.setText(String.valueOf(y1));
        Element x22 = bndbox.addElement("x2");
        x22.setText(String.valueOf(x2));
        Element y22 = bndbox.addElement("y2" );
        y22.setText(String.valueOf(y2));

        OutputFormat format = OutputFormat.createPrettyPrint();
        format.setEncoding("utf-8");
        Writer out = null;
        try {
            out = new FileWriter(s);
            XMLWriter writer = new XMLWriter(out, format);
            writer.write(document);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
