package xyz.dreamthch;

import lombok.extern.slf4j.Slf4j;
import xyz.dreamthch.impl.CoordinateBuilderImpl;
import xyz.dreamthch.mapper.CoordinateBuilder;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Slf4j
public class CoordinateBuilderApplication {

    private static CoordinateBuilder coordinateBuilder = new CoordinateBuilderImpl();
    private static List<Integer> widthLists = new ArrayList<>();
    private static List<Integer> heightLists = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        List<String> txtList = coordinateBuilder.readText("C:\\Users\\FKT00093\\Desktop\\export_ball_2045.txt");
        if (txtList.size() > 0){
            for (String txt : txtList) {
                Map<String, Object> coordinateCenter = coordinateBuilder.getCoordinateCenter(txt);
                if (coordinateCenter != null){
                    Integer x1 = (Integer) coordinateCenter.get("x1");
                    Integer x2 = (Integer) coordinateCenter.get("x2");
                    Integer y1 = (Integer) coordinateCenter.get("y1");
                    Integer y2 = (Integer) coordinateCenter.get("y2");
                    String label = (String) coordinateCenter.get("label");
                    String imageName = (String) coordinateCenter.get("imageName");
                    coordinateCenter.clear();
                    File file = new File("C:\\Users\\FKT00093\\Desktop\\imageset_611\\"+imageName);
                    if (file.isFile()) {
                        String newImage = imageName.substring(0, imageName.length() - 4);
                        Integer width = x2 - x1;
                        Integer height = y2 - y1;
                        coordinateBuilder.createVOCDocument(x1,x2,y1,y2,"C:\\Users\\FKT00093\\Desktop\\imageset_609_res\\"+newImage+".xml",label);
//                        widthLists.add(width);
//                        heightLists.add(height);
                    }else {
                        log.debug("Image does not exist");
                    }
                }else {
                    log.debug("Coordinate generator did not get data");
                }
            }
        }else {
            log.debug("Current txt no data available ");
        }
//        Integer widthSum = 0;
//        for (Integer width : widthLists) {
//            widthSum = widthSum + width ;
//        }
//        Integer average = widthSum / widthLists.size() ;
//
//        Integer heightSum = 0;
//        for (Integer height : heightLists) {
//            heightSum = heightSum + height ;
//        }
//        Integer heightAverage = heightSum / widthLists.size() ;
//        log.debug("width - sum :"+ widthSum + "\t" + "width - size :"+ widthLists.size() + "\t" + "width - average:"+ average);
//        log.debug("height - sum :"+ heightSum + "\t" + "height - size :"+ heightLists.size() + "\t" + "height - average:"+ heightAverage);
//        log.debug("Closure run");
    }
}
