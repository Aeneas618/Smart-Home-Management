package xyz.dreamthch;

import org.junit.Test;
import java.io.File;

public class TestConf {

    @Test
    public void testXmlPath(){
        File[] files = new File("./xml").listFiles();
        for (File file : files) {
            String newName = file.getName().substring(0, file.getName().length() - 4);
            File fileImg = new File("E:\\car_lp_img_20200407\\"+newName+".jpg");
            if (fileImg != null) {
                fileImg.delete();
            }
        }
    }
}
