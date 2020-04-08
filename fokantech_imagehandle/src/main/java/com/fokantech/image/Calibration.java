package com.fokantech.image;

import com.baidu.aip.ocr.AipOcr;
import com.fokantech.conf.ConfigurationAttribute;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.json.JSONArray;
import org.json.JSONObject;
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
public class Calibration {

    public static final List<Integer> xList = new ArrayList<Integer>();
    public static final List<Integer> yList = new ArrayList<Integer>();
    public static final List<String> plates = new ArrayList<String>();
    public static final Log log = LogFactory.getLog(Calibration.class);
    public static final ConfigurationAttribute config = new ConfigurationAttribute();

    public static void startCalibrationPlate(String path ,AipOcr client ) throws Exception {
        client = new AipOcr(ConfigurationAttribute.APPID,ConfigurationAttribute.APIKEY,ConfigurationAttribute.SECRETKEY);
        File[] files = new File(path).listFiles();
        for (int i = 0; i < files.length; i++) {
            BufferedImage bufferedImage = ImageIO.read(files[i]);
            Graphics g = bufferedImage.getGraphics();
            HashMap<String, String> options = new HashMap<String, String>();
            options.put("multi_detect", "true");
            String image = String.valueOf(files[i]);
            JSONObject res = client.plateLicense(image, options);
            System.out.println(res);
            if(!res.has("error_code")){
                JSONArray words_result = res.getJSONArray("words_result");
                for (int j = 0; j < words_result.length(); j++) {
                    String number = String.valueOf(words_result.getJSONObject(j).get("number"));
                    plates.add(number);
                    Object vertexes_location = words_result.getJSONObject(j).get("vertexes_location");
                    JSONArray jsonArray = (JSONArray) vertexes_location;
                    for (int k = 0; k < jsonArray.length(); k++) {
                        Integer x = Integer.parseInt(String.valueOf(jsonArray.getJSONObject(k).get("x")));
                        xList.add(x);
                        Integer y = Integer.parseInt(String.valueOf(jsonArray.getJSONObject(k).get("y")));
                        yList.add(y);
                    }
                }
                ImageIO.write(bufferedImage,"jpg",new File("C:\\Users\\FKT00093\\Desktop\\res\\"+plates.get(0)+".jpg"));
                xList.clear();
                yList.clear();
                plates.clear();
            }
        }
    }

    public static void main(String[] args) throws Exception {
        AipOcr ocr = null;
        startCalibrationPlate("D:\\阳澄湖专项\\image\\pictures2_jpg\\13",ocr);
    }

}
