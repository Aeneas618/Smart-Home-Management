package com.fokantech.data;

import com.fokantech.conf.ReadingAloud;
import com.fokantech.conf.ResultSet;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.io.*;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

public class StatisticalData {

    public static final Log log = LogFactory.getLog(StatisticalData.class);

    public static void accuracyOfCalculations(String path) throws Exception
    {
        List<String> textList = readText(path);
        ResultSet rs = new ResultSet();
        List<String> plates = rs.plates();
        List<String> imageNames = new ArrayList<>();
        List<String> imageLabels = new ArrayList<>();
        List<String> errorNames = new ArrayList<>();
        List<String> errorLabels = new ArrayList<>();
        for (String text : textList) {
            int index = text.lastIndexOf(",");
            String imgName = text.substring(0, index);
            String labelName = text.substring(index+1, text.length());
            boolean contains = plates.contains(labelName);
            if (contains){
                imageNames.add(imgName);
                imageLabels.add(labelName);
            }else {
                errorNames.add(imgName);
                errorLabels.add(labelName);
            }
        }
        double testLen = plates.size();
        double successLen = imageLabels.size();
        double accuracyNum = successLen / testLen ;
        String accuracy = getPercentFormat(accuracyNum, 3, 2);
        String error = getPercentFormat(1 - accuracyNum, 3, 2);
        File file = new File(path);
        log.debug("当前 "+ file.getName()+"结果集的准确率为："+accuracy);
        ReadingAloud.readingAloud("当前 "+ file.getName()+"结果集的准确率为："+accuracy);
        log.debug("当前 "+ file.getName()+"结果集的错误率为："+error);
        ReadingAloud.readingAloud("当前 "+ file.getName()+"结果集的错误率为："+error);
        for (int i = 0; i < errorLabels.size(); i++) {
            log.debug("错误图片："+ errorNames.get(i)+",它的错误label是："+errorLabels.get(i));
        }
    }
    public static String getPercentFormat(double d,int IntegerDigits,int FractionDigits)
    {
        NumberFormat nf = NumberFormat.getPercentInstance();
        nf.setMaximumIntegerDigits(IntegerDigits);
        nf.setMinimumFractionDigits(FractionDigits);
        String str = nf.format(d);
        return str;
    }
    public static List<String> readText(String path) throws Exception
    {
        List<String> strs = new ArrayList<>();
        FileInputStream fis = new FileInputStream(path);
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
    }
    public static void main(String[] args) throws Exception
    {
        accuracyOfCalculations("D:\\label.txt");
    }
}
