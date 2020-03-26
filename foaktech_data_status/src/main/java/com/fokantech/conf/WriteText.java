package com.fokantech.conf;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class WriteText {

    public static void main(String[] args) throws IOException {
        String path = "D:\\";
        File file = new File(path);
        if (file.exists()){
            file.mkdirs();
        }
        file = new File(path+"\\label.txt");
        file.createNewFile();
        File[] files = new File("D:\\FKT_TANGXIAO_2020年度工作空间\\20200325\\Desktop\\img").listFiles();
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
        ResultSet rs = new ResultSet();
        List<String> plates = rs.plates();
        for (int i = 0; i < plates.size(); i++) {
            bufferedWriter.write(files[i].getName()+","+plates.get(i)+"\r");
            bufferedWriter.flush();
        }
        bufferedWriter.close();
    }
}
