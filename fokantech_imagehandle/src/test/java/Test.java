import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test {

    public static void main(String[] args) throws Exception{
        List<String> list = txt2String("D:\\result.txt");
        List<String> rs = txt2String("D:\\阳澄湖专项\\result.txt");
        List<String> plate = new ArrayList<>();
        List<String> imgs = new ArrayList<>();
        List<String> result = new ArrayList<>();
        List<String> success = new ArrayList<>();
        List<String> error = new ArrayList<>();
        for (String r : rs) {
            int index = r.indexOf(":");
            String newPlate = r.substring(index + 1, r.length());
            result.add(newPlate);
        }
        for (String s : list) {
            int index = s.indexOf(",");
            if (index >2) {
                String newPlate = s.substring(index + 1, s.length());
                String newImage = s.substring(0, index);
                plate.add(newPlate);
                imgs.add(newImage);
            }
        }
        for (String s : plate) {
            System.out.println(s);
            boolean contains = result.contains(s);
            if (contains){
                success.add(s);
            }else {
                error.add(s);
                int index = plate.indexOf(s);
                System.out.println("errorName"+imgs.get(index));
            }
        }
        double reLen = rs.size();
        double suLen = success.size();
        double teslen = suLen/reLen;
        System.out.println("test error size"+error.size());
        System.out.println("test success size"+success.size());
        System.out.println("test accuracyRate size:"+teslen);
    }

    public static List<String> txt2String(String path){
        File file = new File(path);
        List<String> test = new ArrayList<>();
        try{
            BufferedReader br = new BufferedReader(new FileReader(file));//构造一个BufferedReader类来读取文件
            String s = null;
            while((s = br.readLine())!=null){//使用readLine方法，一次读一行
                test.add(System.lineSeparator()+s);
            }
            br.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        return test;
    }

}
