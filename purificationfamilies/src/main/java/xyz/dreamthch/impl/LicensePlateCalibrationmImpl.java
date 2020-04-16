package xyz.dreamthch.impl;

import com.baidu.aip.ocr.AipOcr;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import xyz.dreamthch.dao.LicensePlateCalibrationmMapper;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

public class LicensePlateCalibrationmImpl implements LicensePlateCalibrationmMapper {

    @Override
    public JSONObject getPlateDataList(String APPID, String APIKEY, String SECRETKEY, File file) {
        AipOcr client = new AipOcr(APPID,APIKEY, SECRETKEY);
        HashMap<String, String> options = new HashMap<String, String>();
        options.put("multi_detect", "true");
        JSONObject result = client.plateLicense(file.getPath(), options);
        System.out.println(result);
        return result;
    }

    @Override
    public String getPlateNumberStr(JSONObject object){
        if(!object.has("error_code")) {
            String plateNumber = "";
            try {
                JSONArray words_result = object.getJSONArray("words_result");
                for (int i = 0; i < words_result.length(); i++) {
                    try {
                        plateNumber = String.valueOf(words_result.getJSONObject(i).get("number"));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return plateNumber;
        }
        return null;
    }

    @Override
    public Map<String, Integer> getGenerateConfigurationFiles(JSONObject object) {

        try {
            JSONArray words_result = object.getJSONArray("words_result");
            Map<String,Integer> map = new HashMap<>();
            for (int i = 0; i < words_result.length(); i++) {
                JSONArray vertexes_location = null;
                try {
                    vertexes_location = (JSONArray)words_result.getJSONObject(i).get("vertexes_location");
                    for (int j = 0; j < vertexes_location.length(); j++) {
                        Integer x = Integer.parseInt(String.valueOf(vertexes_location.getJSONObject(j).get("x")));
                        Integer y = Integer.parseInt(String.valueOf(vertexes_location.getJSONObject(j).get("y")));
                        map.put("x"+(j+1),x);
                        map.put("y"+(j+1),y);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            return map;
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public void createVOCDocument(Integer x1, Integer y1, Integer x2, Integer y2, Integer x3, Integer y3, Integer x4, Integer y4, String path, String plateNumber) {
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
        Writer out = null;
        try {
            out = new FileWriter(path+".xml");
            XMLWriter writer = new XMLWriter(out, format);
            writer.write(document);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
