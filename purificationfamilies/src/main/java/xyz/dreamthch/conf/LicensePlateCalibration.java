package xyz.dreamthch.conf;

import com.baidu.aip.ocr.AipOcr;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;
import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Test;

import java.io.File;
import java.io.FileWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

public class LicensePlateCalibration {
    /**
     * 获取车牌结果集
     * @param APPID
     * @param APIKEY
     * @param SECRETKEY
     * @return
     */
    private JSONObject getPlateData( String APPID,String APIKEY,String SECRETKEY ,File file){
        AipOcr client = new AipOcr(APPID,APIKEY, SECRETKEY);
        HashMap<String, String> options = new HashMap<String, String>();
        options.put("multi_detect", "true");
        JSONObject result = client.plateLicense(file.getPath(), options);
        return result;
    }
    /**
     * 解析数据车牌数据，获取车牌号
     * @param object
     * @return
     * @throws Exception
     */
    private String formatPlateData(JSONObject object) throws Exception{
        if(!object.has("error_code")) {
            JSONArray words_result = object.getJSONArray("words_result");
            String plateNumber = "";
            for (int i = 0; i < words_result.length(); i++) {
                plateNumber = String.valueOf(words_result.getJSONObject(i).get("number"));
            }
            return plateNumber;
        }
        return null;
    }
    /**
     * 获取车牌坐标
     * @param object
     * @return
     * @throws Exception
     */
    private Map<String,Integer> getGenerateConfigurationFiles(JSONObject object) throws Exception {
        JSONArray words_result = object.getJSONArray("words_result");
        Map<String,Integer> map = new HashMap<>();
        for (int i = 0; i < words_result.length(); i++) {
            JSONArray vertexes_location = (JSONArray)words_result.getJSONObject(i).get("vertexes_location");
            for (int j = 0; j < vertexes_location.length(); j++) {
                Integer x = Integer.parseInt(String.valueOf(vertexes_location.getJSONObject(j).get("x")));
                Integer y = Integer.parseInt(String.valueOf(vertexes_location.getJSONObject(j).get("y")));
                map.put("x"+(j+1),x);
                map.put("y"+(j+1),y);
            }
        }
        return map;
    }
    /**
     * 生成voc格式文件
     * @param x1
     * @param y1
     * @param x2
     * @param y2
     * @param x3
     * @param y3
     * @param x4
     * @param y4
     * @param path
     * @throws Exception
     */
    private void createDocumentVOC(Integer x1,Integer y1,Integer x2,Integer y2
            ,Integer x3,Integer y3,Integer x4,Integer y4,String path
    ,String plateNumber) throws Exception {
        Document document = DocumentHelper.createDocument();
        Element annotation = document.addElement("annotation");
        Element object = annotation.addElement("object");
        Element name = object.addElement("name");
        name.setText(plateNumber);
        Element bndbox = object.addElement("bndbox");
        Element x11 = bndbox.addElement("x1");
        x11.setText(String.valueOf(x1));
        Element y11 = bndbox.addElement("y1" );
        y11.setText(String.valueOf(y1));
        Element x22 = bndbox.addElement("x2");
        x22.setText(String.valueOf(x2));
        Element y22 = bndbox.addElement("y2" );
        y22.setText(String.valueOf(y2));
        Element x33 = bndbox.addElement("x3");
        x33.setText(String.valueOf(x3));
        Element y33 = bndbox.addElement("y3" );
        y33.setText(String.valueOf(y3));
        Element x44 = bndbox.addElement("x4");
        x44.setText(String.valueOf(x4));
        Element y44 = bndbox.addElement("y4" );
        y44.setText(String.valueOf(y4));
        OutputFormat format = OutputFormat.createPrettyPrint();
        format.setEncoding("utf-8");
        Writer out = new FileWriter(path+".xml");
        XMLWriter writer = new XMLWriter(out, format);
        writer.write(document);
        writer.close();
    }

    public static void main(String[] args) throws Exception {
        LicensePlateCalibration plateCalibration = new LicensePlateCalibration();
        File[] files = new File("E:\\car_lp_img_20200407").listFiles();
        for (File file : files) {
            String newImgName = file.getName().substring(0, file.getName().length() - 4);
            JSONObject plate = plateCalibration.getPlateData(ConfAttribute.APPID, ConfAttribute.APIKEY, ConfAttribute.SECRETKEY,file);
            String plateNumber = plateCalibration.formatPlateData(plate);
            if (plateNumber!=null) {
                Map<String, Integer> map = plateCalibration.getGenerateConfigurationFiles(plate);
                plateCalibration.createDocumentVOC(map.get("x1"), map.get("y1"), map.get("x2"), map.get("y2"),
                        map.get("x3"), map.get("y3"), map.get("x4"), map.get("y4"), "./xml/" + newImgName, plateNumber);
            }else {
                System.out.println("没有车牌");
            }
        }
    }

}
