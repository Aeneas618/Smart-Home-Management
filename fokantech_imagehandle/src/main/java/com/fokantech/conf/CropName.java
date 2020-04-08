package com.fokantech.conf;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class CropName {

    public static void main(String[] args) throws IOException {

        File[] files = new File("D:\\3313935526\\FileRecv\\CropPlate").listFiles();
        for (File file : files) {
            String newName = file.getName().substring(0, file.getName().length() - 9) + ".jpg";
            BufferedImage bufferedImage = ImageIO.read(file);
            ImageIO.write(bufferedImage,"jpeg",new File("C:\\Users\\FKT00093\\Desktop\\test\\"+newName));
        }
    }
}
