package xyz.dreamthch;

import xyz.dreamthch.conf.ImageUI;
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class TestLabelStr {


    public static void main(String[] args) throws IOException {
        List<String> textList = readText("C:\\Users\\FKT00093\\Desktop\\export_ball_1770.txt");
        for (String text : textList) {
            String txtData = text.substring(7, text.length());
            System.out.println(txtData);
            String labelName = txtData.substring(0, 4);
            String imageName = txtData.substring(5,18);
            File file = new File("C:\\Users\\FKT00093\\Desktop\\test\\" + imageName);
            if (file.isFile()) {
                BufferedImage bufferedImage = ImageIO.read(file);
                Graphics2D g = (Graphics2D)bufferedImage.getGraphics();
                g.setColor(Color.ORANGE);
                g.drawRect(31,245,81-31,291-245);
                int width = bufferedImage.getWidth();
                int height = bufferedImage.getHeight();

                String coordinate = txtData.substring(27, txtData.length());
                int index1 = coordinate.indexOf("|");
                Integer x1 = Integer.valueOf(coordinate.substring(0, index1));

                String str1 = coordinate.substring(index1 + 1, coordinate.length());
                int index2 = str1.indexOf("|");
                Integer y1 = Integer.valueOf(str1.substring(0, index2));

                String str2 = str1.substring(index2 + 1, str1.length());
                int index3 = str2.indexOf("|");
                Integer x2 = Integer.valueOf(str2.substring(0, index3));

                String str3 = str2.substring(index3 + 1, str2.length());
                int index4 = str3.indexOf("|");
                Integer y2 = Integer.valueOf(str3.substring(0, index4));

            }else {
                System.err.println("error");
            }

        }
    }
    //                             x1  x2  y1  y2
    //  ball|frame0004.jpg|620|480|31|245|81|291|56.0|268.0|50|46
    public static List<String> readText(String path){
        List<String> strs = new ArrayList<>();
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(path);
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
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
