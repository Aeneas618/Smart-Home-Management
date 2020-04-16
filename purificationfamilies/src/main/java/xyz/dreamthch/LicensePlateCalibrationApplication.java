package xyz.dreamthch;

import org.json.JSONObject;
import xyz.dreamthch.conf.ConfAttribute;
import xyz.dreamthch.impl.LicensePlateCalibrationmImpl;
import xyz.dreamthch.mapper.LicensePlateCalibrationm;
import java.io.File;
import java.util.Map;

public class LicensePlateCalibrationApplication {

    private static final LicensePlateCalibrationm mapper = new LicensePlateCalibrationmImpl();

    public static void main(String[] args){

        File[] files = new File("").listFiles();
        for (File file : files) {
            String newImgName = file.getName().substring(0, file.getName().length() - 4);
            JSONObject plateDataList = mapper.getPlateDataList(ConfAttribute.APPID, ConfAttribute.APIKEY, ConfAttribute.SECRETKEY, file);
            String plateNumberStr = mapper.getPlateNumberStr(plateDataList);
            if (plateNumberStr != null) {
                Map<String, Integer> map = mapper.savePlateCoordinates(plateDataList);
                if (map != null) {
                    mapper.createVOCDocument(map.get("x1"), map.get("y1"), map.get("x2"), map.get("y2"),
                            map.get("x3"), map.get("y3"), map.get("x4"), map.get("y4"), "./xml/" + newImgName, plateNumberStr);
                    map.clear();
                }
            }
        }

    }

}
