package com.fokantech;

import com.baidu.aip.ocr.AipOcr;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.json.JSONArray;
import org.json.JSONObject;
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
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
                int[] x = {xList.get(0),xList.get(1),xList.get(2),xList.get(3)};
                int[] y = {yList.get(0),yList.get(1),yList.get(2),yList.get(3)};
                Polygon p = new Polygon(x,y,4);
                g.drawPolygon(p);
                ImageIO.write(bufferedImage,"jpg",new File("C:\\Users\\tangxiao\\Desktop\\FOKANTECH_PLATE\\"+plates.get(0)+".jpg"));
                xList.clear();
                yList.clear();
                plates.clear();
            }
        }
    }

    public static List<String> compare(String path){
        File[] files = new File(path).listFiles();
        ResultSet rs = new ResultSet();
        List<String> plates = rs.plates();
        List<String> errors = new ArrayList<String>();
        for (File file : files) {
            String fileName = file.getName().substring(0, file.getName().length() - 4);
            boolean contains = plates.contains(fileName);
            if (contains == false){
                errors.add(file.getName());
            }
        }
        return  errors;
    }

    public static String getPercentFormat(double d,int IntegerDigits,int FractionDigits){
        NumberFormat nf = NumberFormat.getPercentInstance();
        nf.setMaximumIntegerDigits(IntegerDigits);
        nf.setMinimumFractionDigits(FractionDigits);
        String str = nf.format(d);
        return str;
    }

    public static void main(String[] args) throws Exception {
        String modelPath = "C:\\Users\\FKT00093\\Desktop\\Desktop\\FOKANTECH_ocr_mix_unfixed_06DG" ;
        String testPath = "C:\\Users\\FKT00093\\Desktop\\Desktop\\img";
        double testLen = new File(testPath).listFiles().length;
//        readingAloud.readingAloud("当前测试图像："+testLen+"张");
        log.debug("当前测试图像："+testLen+"张");

        double resLen = new File(modelPath).listFiles().length;
//        readingAloud.readingAloud("当前识别图像："+ resLen + "张");
        log.info("当前识别图片为：\t"+resLen+"张");

        List<String> compare = compare(modelPath);

        double a = compare.size() / resLen;
//        readingAloud.readingAloud("当前检测错误张数为：\t"+compare.size()+"张");
        log.info("当前检测错误张数为：\t"+compare.size()+"张");
//        readingAloud.readingAloud("当前检测百分之百的情况下误检率为：\t"+getPercentFormat(a,2,2));
        log.info("当前检测百分之百正确的情况下误检率为：\t"+getPercentFormat(a,2,2));

        double c = 1 - a;
//        readingAloud.readingAloud("当前检测正确率为：\t"+getPercentFormat(c,2,2));
        log.info("当前检测正确率为：\t"+getPercentFormat(c,2,2));

        for (String errorName : compare) {
//            readingAloud.readingAloud("当前错误识别图片为："+errorName);
            log.info("当前错误识别图片为："+errorName);
            BufferedImage bufferedImage = ImageIO.read(new File(modelPath+"\\"+errorName));
            config.imshow(errorName,bufferedImage);
        }
    }

}
