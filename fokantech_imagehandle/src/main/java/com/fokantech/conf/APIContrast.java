package com.fokantech.conf;

import com.baidu.aip.ocr.AipOcr;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;
import org.json.JSONArray;
import org.json.JSONObject;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileWriter;
import java.io.Writer;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class APIContrast {

    public static final List<Integer> xList = new ArrayList<>();
    public static final List<Integer> yList = new ArrayList<>();
    public static final List<String> plates = new ArrayList<>();
    public static final Log log = LogFactory.getLog(APIContrast.class);
    public static final ConfigurationAttribute config = new ConfigurationAttribute();

    public static void sample(String path ,AipOcr client ) throws Exception {
        client = new AipOcr(ConfigurationAttribute.APPID, ConfigurationAttribute.APIKEY, ConfigurationAttribute.SECRETKEY);
        File[] files = new File(path).listFiles();
        for (int i = 0; i < files.length; i++) {
            BufferedImage bufferedImage = ImageIO.read(files[i]);
            Graphics g = bufferedImage.getGraphics();
            HashMap<String, String> options = new HashMap<String, String>();
            options.put("multi_detect", "true");
            String image = String.valueOf(files[i]);
            JSONObject res = client.plateLicense(image, options);
            System.out.println(res.toString());
            Document document = DocumentHelper.createDocument();
            Element annotation = document.addElement("annotation");
            if(!res.has("error_code")){
                JSONArray words_result = res.getJSONArray("words_result");
                for (int j = 0; j < words_result.length(); j++) {
                    String number = String.valueOf(words_result.getJSONObject(j).get("number"));
                    Object vertexes_location = words_result.getJSONObject(j).get("vertexes_location");
                    JSONArray jsonArray = (JSONArray) vertexes_location;
                    Element object = annotation.addElement("object");
                    Element bndbox = object.addElement("bndbox");
                    for (int k = 0; k < jsonArray.length(); k++) {
                        Integer x = Integer.parseInt(String.valueOf(jsonArray.getJSONObject(k).get("x")));
                        Integer y = Integer.parseInt(String.valueOf(jsonArray.getJSONObject(k).get("y")));
                        Element x1 = bndbox.addElement("x" + (k + 1));
                        x1.setText(String.valueOf(x));
                        Element y1 = bndbox.addElement("y" + (k + 1));
                        y1.setText(String.valueOf(y));
                    }
                    ImageIO.write(bufferedImage,"jpg",new File("E:\\"+number+".jpg"));
                    OutputFormat format = OutputFormat.createPrettyPrint();
                    format.setEncoding("utf-8");
                    Writer out = new FileWriter("D:\\test\\"+number+".xml");
                    //创建一个dom4j创建xml的对象
                    XMLWriter writer = new XMLWriter(out, format);
                    //调用write方法将doc文档写到指定路径
                    writer.write(document);
                    writer.close();
                }
            }
        }
    }

    public static String getPercentFormat(double d,int IntegerDigits,int FractionDigits){
        NumberFormat nf = NumberFormat.getPercentInstance();
        nf.setMaximumIntegerDigits(IntegerDigits);
        nf.setMinimumFractionDigits(FractionDigits);
        String str = nf.format(d);
        return str;
    }

    public static void main(String[] args) throws Exception {
        AipOcr ocr = null;
        String modelPath = "D:\\阳澄湖专项\\TestImage" ;
        sample(modelPath,ocr);
    }

}
