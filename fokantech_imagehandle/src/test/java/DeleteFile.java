import java.io.File;

public class DeleteFile {

    public static void main(String[] args) {
        File[] files = new File("E:\\car_lp_img_20200403").listFiles();
        for (int i = 0; i < files.length; i++) {
            String name = files[i].getName();
            int index = name.indexOf("_");
            int index1 = name.indexOf(".");
            String substring = name.substring(index + 1, index1);
            if (substring.length() != 7){
                files[i].delete();
            }
            if (i%2 != 0){
                files[i].delete();
            }
        }
    }
}
