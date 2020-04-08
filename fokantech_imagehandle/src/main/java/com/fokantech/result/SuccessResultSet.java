package com.fokantech.result;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

public class SuccessResultSet {

    public static void main(String[] args) throws Exception {
        ResultSet set = new ResultSet();

        createResultText("D:\\","result01","E:\\Result\\1_IMG");
    }

    public static void createResultText(String path , String resultName , String list)  throws Exception{
        File file = new File(path);
        if (file.exists()){
            file.mkdirs();
        }
        file = new File(path+"\\"+resultName+".txt");
        file.createNewFile();
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
        File[] files = new File(list).listFiles();
        for (File filel : files) {
            bufferedWriter.write(filel.getName()+ "," + filel.getName().substring(0,filel.getName().length()-4)+"\r\n");
            bufferedWriter.flush();
        }
        bufferedWriter.close();
    }
}
