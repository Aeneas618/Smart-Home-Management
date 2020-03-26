package com.fokantech.data;

import com.fokantech.conf.ConfigurationAttribute;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Data_Status {
    /**
     * jin1(晋) ji1(吉) gui1(贵) gan1(甘) jing1(警) yu1(豫)
     */
    public static final List<String> wan = new ArrayList<>();
    public static final List<String> hu = new ArrayList<>();
    public static final List<String> jin = new ArrayList<>();
    public static final List<String> yu = new ArrayList<>();
    public static final List<String> ji = new ArrayList<>();
    public static final List<String> jin1 = new ArrayList<>();
    public static final List<String> meng = new ArrayList<>();
    public static final List<String> liao = new ArrayList<>();
    public static final List<String> ji1 = new ArrayList<>();
    public static final List<String> hei = new ArrayList<>();
    public static final List<String> su = new ArrayList<>();
    public static final List<String> zhe = new ArrayList<>();
    public static final List<String> jing = new ArrayList<>();
    public static final List<String> min = new ArrayList<>();
    public static final List<String> gan = new ArrayList<>();
    public static final List<String> lu = new ArrayList<>();
    public static final List<String> yu1 = new ArrayList<>();
    public static final List<String> e = new ArrayList<>();
    public static final List<String> xiang = new ArrayList<>();
    public static final List<String> yue = new ArrayList<>();
    public static final List<String> gui = new ArrayList<>();
    public static final List<String> qiong = new ArrayList<>();
    public static final List<String> cuan = new ArrayList<>();
    public static final List<String> gui1 = new ArrayList<>();
    public static final List<String> yun = new ArrayList<>();
    public static final List<String> zang = new ArrayList<>();
    public static final List<String> shan = new ArrayList<>();
    public static final List<String> gan1 = new ArrayList<>();
    public static final List<String> qing = new ArrayList<>();
    public static final List<String> ning = new ArrayList<>();
    public static final List<String> xin = new ArrayList<>();
    public static final List<String> jing1 = new ArrayList<>();
    public static final List<String> xue = new ArrayList<>();
    public static final List<String> error = new ArrayList<>();
    public static final List<String> names = new ArrayList<String>();



    public static void main(String[] args) throws Exception {
        ConfigurationAttribute config = new ConfigurationAttribute();
        String[] list1 = new File(ConfigurationAttribute.CCPD_BASE).list();
        for (String s1 : list1) {
            String numberPlate = "";
            List<String> result = Arrays.asList(s1.split("-"));
            for (int i = 0; i < result.size(); i++) {
                if (i == 4){
                    String str = result.get(i);
                    List<String> result1 = Arrays.asList(str.split("_"));
                    for (int j = 0; j < result1.size(); j++) {
                        String testOne = result1.get(j);
                        if (j == 0){
                            String[] provinces = config.provinces();
                            numberPlate = numberPlate + provinces[Integer.parseInt(testOne)];
                        }else if (j == 1){
                            String[] alphabets = config.alphabets();
                            numberPlate = numberPlate + alphabets[Integer.parseInt(testOne)];
                        }else if (j > 1){
                            String[] numbers = config.numbers();
                            numberPlate = numberPlate + numbers[Integer.parseInt(testOne)];
                        }
                    }
                }
            }
            names.add(numberPlate);
        }
        String[] list2 = new File(ConfigurationAttribute.CCPD_BLUR).list();
        for (String s2 : list2) {
            String numberPlate = "";
            List<String> result = Arrays.asList(s2.split("-"));
            for (int i = 0; i < result.size(); i++) {
                if (i == 4){
                    String str = result.get(i);
                    List<String> result1 = Arrays.asList(str.split("_"));
                    for (int j = 0; j < result1.size(); j++) {
                        String testOne = result1.get(j);
                        if (j == 0){
                            String[] provinces = config.provinces();
                            numberPlate = numberPlate + provinces[Integer.parseInt(testOne)];
                        }else if (j == 1){
                            String[] alphabets = config.alphabets();
                            numberPlate = numberPlate + alphabets[Integer.parseInt(testOne)];
                        }else if (j > 1){
                            String[] numbers = config.numbers();
                            numberPlate = numberPlate + numbers[Integer.parseInt(testOne)];
                        }
                    }
                }
            }
            names.add(numberPlate);
        }
        String[] list3 = new File(ConfigurationAttribute.CCPD_CHALLENGE).list();
        for (String s3 : list3) {
            String numberPlate = "";
            List<String> result = Arrays.asList(s3.split("-"));
            for (int i = 0; i < result.size(); i++) {
                if (i == 4){
                    String str = result.get(i);
                    List<String> result1 = Arrays.asList(str.split("_"));
                    for (int j = 0; j < result1.size(); j++) {
                        String testOne = result1.get(j);
                        if (j == 0){
                            String[] provinces = config.provinces();
                            numberPlate = numberPlate + provinces[Integer.parseInt(testOne)];
                        }else if (j == 1){
                            String[] alphabets = config.alphabets();
                            numberPlate = numberPlate + alphabets[Integer.parseInt(testOne)];
                        }else if (j > 1){
                            String[] numbers = config.numbers();
                            numberPlate = numberPlate + numbers[Integer.parseInt(testOne)];
                        }
                    }
                }
            }
            names.add(numberPlate);
        }
        String[] list4 = new File(ConfigurationAttribute.CCPD_DP).list();
        for (String s4 : list4) {
            String numberPlate = "";
            List<String> result = Arrays.asList(s4.split("-"));
            for (int i = 0; i < result.size(); i++) {
                if (i == 4){
                    String str = result.get(i);
                    List<String> result1 = Arrays.asList(str.split("_"));
                    for (int j = 0; j < result1.size(); j++) {
                        String testOne = result1.get(j);
                        if (j == 0){
                            String[] provinces = config.provinces();
                            numberPlate = numberPlate + provinces[Integer.parseInt(testOne)];
                        }else if (j == 1){
                            String[] alphabets = config.alphabets();
                            numberPlate = numberPlate + alphabets[Integer.parseInt(testOne)];
                        }else if (j > 1){
                            String[] numbers = config.numbers();
                            numberPlate = numberPlate + numbers[Integer.parseInt(testOne)];
                        }
                    }
                }
            }
            names.add(numberPlate);
        }
        String[] list5 = new File(ConfigurationAttribute.CCPD_FN).list();
        for (String s5 : list1) {
            String numberPlate = "";
            List<String> result = Arrays.asList(s5.split("-"));
            for (int i = 0; i < result.size(); i++) {
                if (i == 4){
                    String str = result.get(i);
                    List<String> result1 = Arrays.asList(str.split("_"));
                    for (int j = 0; j < result1.size(); j++) {
                        String testOne = result1.get(j);
                        if (j == 0){
                            String[] provinces = config.provinces();
                            numberPlate = numberPlate + provinces[Integer.parseInt(testOne)];
                        }else if (j == 1){
                            String[] alphabets = config.alphabets();
                            numberPlate = numberPlate + alphabets[Integer.parseInt(testOne)];
                        }else if (j > 1){
                            String[] numbers = config.numbers();
                            numberPlate = numberPlate + numbers[Integer.parseInt(testOne)];
                        }
                    }
                }
            }
            names.add(numberPlate);
        }
        String[] list6 = new File(ConfigurationAttribute.CCPD_ROTATE).list();
        for (String s6 : list6) {
            String numberPlate = "";
            List<String> result = Arrays.asList(s6.split("-"));
            for (int i = 0; i < result.size(); i++) {
                if (i == 4){
                    String str = result.get(i);
                    List<String> result1 = Arrays.asList(str.split("_"));
                    for (int j = 0; j < result1.size(); j++) {
                        String testOne = result1.get(j);
                        if (j == 0){
                            String[] provinces = config.provinces();
                            numberPlate = numberPlate + provinces[Integer.parseInt(testOne)];
                        }else if (j == 1){
                            String[] alphabets = config.alphabets();
                            numberPlate = numberPlate + alphabets[Integer.parseInt(testOne)];
                        }else if (j > 1){
                            String[] numbers = config.numbers();
                            numberPlate = numberPlate + numbers[Integer.parseInt(testOne)];
                        }
                    }
                }
            }
            names.add(numberPlate);
        }
        String[] list7 = new File(ConfigurationAttribute.CCPD_NP).list();
        for (String s7 : list7) {
            String numberPlate = "";
            List<String> result = Arrays.asList(s7.split("-"));
            for (int i = 0; i < result.size(); i++) {
                if (i == 4){
                    String str = result.get(i);
                    List<String> result1 = Arrays.asList(str.split("_"));
                    for (int j = 0; j < result1.size(); j++) {
                        String testOne = result1.get(j);
                        if (j == 0){
                            String[] provinces = config.provinces();
                            numberPlate = numberPlate + provinces[Integer.parseInt(testOne)];
                        }else if (j == 1){
                            String[] alphabets = config.alphabets();
                            numberPlate = numberPlate + alphabets[Integer.parseInt(testOne)];
                        }else if (j > 1){
                            String[] numbers = config.numbers();
                            numberPlate = numberPlate + numbers[Integer.parseInt(testOne)];
                        }
                    }
                }
            }
            names.add(numberPlate);
        }
        String[] list8 = new File(ConfigurationAttribute.CCPD_TILT).list();
        for (String s8 : list8) {
            String numberPlate = "";
            List<String> result = Arrays.asList(s8.split("-"));
            for (int i = 0; i < result.size(); i++) {
                if (i == 4){
                    String str = result.get(i);
                    List<String> result1 = Arrays.asList(str.split("_"));
                    for (int j = 0; j < result1.size(); j++) {
                        String testOne = result1.get(j);
                        if (j == 0){
                            String[] provinces = config.provinces();
                            numberPlate = numberPlate + provinces[Integer.parseInt(testOne)];
                        }else if (j == 1){
                            String[] alphabets = config.alphabets();
                            numberPlate = numberPlate + alphabets[Integer.parseInt(testOne)];
                        }else if (j > 1){
                            String[] numbers = config.numbers();
                            numberPlate = numberPlate + numbers[Integer.parseInt(testOne)];
                        }
                    }
                }
            }
            names.add(numberPlate);
        }
        String[] list9 = new File(ConfigurationAttribute.CCPD_WEATHER).list();
        for (String s9 : list9) {
            String numberPlate = "";
            List<String> result = Arrays.asList(s9.split("-"));
            for (int i = 0; i < result.size(); i++) {
                if (i == 4){
                    String str = result.get(i);
                    List<String> result1 = Arrays.asList(str.split("_"));
                    for (int j = 0; j < result1.size(); j++) {
                        String testOne = result1.get(j);
                        if (j == 0){
                            String[] provinces = config.provinces();
                            numberPlate = numberPlate + provinces[Integer.parseInt(testOne)];
                        }else if (j == 1){
                            String[] alphabets = config.alphabets();
                            numberPlate = numberPlate + alphabets[Integer.parseInt(testOne)];
                        }else if (j > 1){
                            String[] numbers = config.numbers();
                            numberPlate = numberPlate + numbers[Integer.parseInt(testOne)];
                        }
                    }
                }
            }
            names.add(numberPlate);
        }
        System.out.println("累计图像："+names.size()+"张");
        for (String name : names) {
            if (name.length()> 0) {
                String provinceName = name.substring(0, 1);
                if (provinceName != null && provinceName != "" && provinceName.equals("皖")) {
                    wan.add(name);
                } else if (provinceName != null && provinceName != "" && provinceName.equals("沪")) {
                    hu.add(name);
                } else if (provinceName != null && provinceName != "" && provinceName.equals("津")) {
                    jin.add(name);
                } else if (provinceName != null && provinceName != "" && provinceName.equals("渝")) {
                    yu.add(name);
                } else if (provinceName != null && provinceName != "" && provinceName.equals("冀")) {
                    ji.add(name);
                } else if (provinceName != null && provinceName != "" && provinceName.equals("晋")) {
                    jin1.add(name);
                } else if (provinceName != null && provinceName != "" && provinceName.equals("蒙")) {
                    meng.add(name);
                } else if (provinceName != null && provinceName != "" && provinceName.equals("辽")) {
                    liao.add(name);
                } else if (provinceName != null && provinceName != "" && provinceName.equals("吉")) {
                    ji1.add(name);
                } else if (provinceName != null && provinceName != "" && provinceName.equals("黑")) {
                    hei.add(name);
                } else if (provinceName != null && provinceName != "" && provinceName.equals("苏")) {
                    su.add(name);
                } else if (provinceName != null && provinceName != "" && provinceName.equals("浙")) {
                    zhe.add(name);
                } else if (provinceName != null && provinceName != "" && provinceName.equals("京")) {
                    jing.add(name);
                } else if (provinceName != null && provinceName != "" && provinceName.equals("闽")) {
                    min.add(name);
                } else if (provinceName != null && provinceName != "" && provinceName.equals("赣")) {
                    gan.add(name);
                } else if (provinceName != null && provinceName != "" && provinceName.equals("鲁")) {
                    lu.add(name);
                } else if (provinceName != null && provinceName != "" && provinceName.equals("豫")) {
                    yu1.add(name);
                } else if (provinceName != null && provinceName != "" && provinceName.equals("鄂")) {
                    e.add(name);
                } else if (provinceName != null && provinceName != "" && provinceName.equals("湘")) {
                    xiang.add(name);
                } else if (provinceName != null && provinceName != "" && provinceName.equals("粤")) {
                    yue.add(name);
                } else if (provinceName != null && provinceName != "" && provinceName.equals("桂")) {
                    gui.add(name);
                } else if (provinceName != null && provinceName != "" && provinceName.equals("琼")) {
                    qiong.add(name);
                } else if (provinceName != null && provinceName != "" && provinceName.equals("川")) {
                    cuan.add(name);
                } else if (provinceName != null && provinceName != "" && provinceName.equals("贵")) {
                    gui1.add(name);
                } else if (provinceName != null && provinceName != "" && provinceName.equals("云")) {
                    yun.add(name);
                } else if (provinceName != null && provinceName != "" && provinceName.equals("藏")) {
                    zang.add(name);
                } else if (provinceName != null && provinceName != "" && provinceName.equals("陕")) {
                    shan.add(name);
                } else if (provinceName != null && provinceName != "" && provinceName.equals("甘")) {
                    gan1.add(name);
                } else if (provinceName != null && provinceName != "" && provinceName.equals("青")) {
                    qing.add(name);
                } else if (provinceName != null && provinceName != "" && provinceName.equals("宁")) {
                    ning.add(name);
                } else if (provinceName != null && provinceName != "" && provinceName.equals("新")) {
                    xin.add(name);
                } else if (provinceName != null && provinceName != "" && provinceName.equals("警")) {
                    jing1.add(name);
                } else if (provinceName != null && provinceName != "" && provinceName.equals("学")) {
                    xue.add(name);
                }
            }
        }
        if (wan.size()>0){
            System.out.println("皖："+wan.size()+"张");
        }
        if (hu.size()>0){
            System.out.println("沪："+hu.size()+"张");
        }
        if(jin.size()>0){
            System.out.println("津："+jin.size()+"张");
        }
        if (yu.size()>0){
            System.out.println("渝："+yu.size()+"张");
        }
        if (ji.size()>0) {
            System.out.println("冀：" + ji.size() + "张");
        }
        if (jin1.size()>0) {
            System.out.println("晋：" + jin1.size() + "张");
        }
        if (meng.size()>0){
            System.out.println("蒙："+meng.size()+"张");
        }
        if (liao.size()>0) {
            System.out.println("辽：" + liao.size() + "张");
        }
        if (ji1.size()>0) {
            System.out.println("吉：" + ji1.size() + "张");
        }
        if (hei.size()>0) {
            System.out.println("黑：" + hei.size() + "张");
        }
        if (su.size()>0) {
            System.out.println("苏：" + su.size() + "张");
        }
        if (zhe.size()>0) {
            System.out.println("浙：" + zhe.size() + "张");
        }
        if (jing.size()>0){
            System.out.println("京："+jing.size()+"张");
        }
        if (min.size()>0) {
            System.out.println("闽：" + min.size() + "张");
        }
        if (gan.size()>0) {
            System.out.println("赣：" + gan.size() + "张");
        }
        if (lu.size()>0) {
            System.out.println("鲁：" + lu.size() + "张");
        }
        if (yu1.size()>0) {
            System.out.println("豫：" + yu1.size() + "张");
        }
        if (e.size()>0) {
            System.out.println("鄂：" + e.size() + "张");
        }
        if (xiang.size()>0) {
            System.out.println("湘：" + xiang.size() + "张");
        }
        if (yue.size()>0) {
            System.out.println("粤：" + yue.size() + "张");
        }
        if (gui.size()>0) {
            System.out.println("桂：" + yu1.size() + "张");
        }
        if (qiong.size()>0) {
            System.out.println("琼：" + qiong.size() + "张");
        }
        if (cuan.size()>0) {
            System.out.println("川：" + cuan.size() + "张");
        }
        if (gui1.size()>0) {
            System.out.println("贵：" + gui1.size() + "张");
        }
        if (yun.size()>0) {
            System.out.println("云：" + yun.size() + "张");
        }
        if (zang.size()>0) {
            System.out.println("藏：" + zang.size() + "张");
        }
        if (shan.size()>0) {
            System.out.println("陕：" + shan.size() + "张");
        }
        if (gan1.size()>0) {
            System.out.println("甘：" + gan1.size() + "张");
        }
        if (qing.size()>0) {
            System.out.println("青：" + qing.size() + "张");
        }
        if (ning.size()>0) {
            System.out.println("宁：" + ning.size() + "张");
        }
        if (xin.size()>0) {
            System.out.println("新：" + xin.size() + "张");
        }
        if (jing1.size()>0) {
            System.out.println("警：" + jing1.size() + "张");
        }
        if(xue.size()>0){
            System.out.println("学："+xue.size()+"张");
        }
    }
}
