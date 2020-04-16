package xyz.dreamthch.dao;

import org.json.JSONObject;

import java.io.File;
import java.util.Map;

public interface LicensePlateCalibrationmMapper {
    /**
     *  Access to license plate data containers through aip
     * @param APPID
     * @param APIKEY
     * @param SECRETKEY
     * @param file
     * @return
     */
    JSONObject getPlateDataList(String APPID,String APIKEY,String SECRETKEY ,File file);

    /**
     *  License plate number in acquired card data container
     * @param object
     * @return
     */
    String getPlateNumberStr(JSONObject object);

    /**
     *  Used to save license plate coordinates
     * @param object
     * @return
     */
    Map<String,Integer> getGenerateConfigurationFiles(JSONObject object);

    /**
     *  Generate configuration files based on coordinates
     * @param x1
     * @param y1
     * @param x2
     * @param y2
     * @param x3
     * @param y3
     * @param x4
     * @param y4
     * @param path
     * @param plateNumber
     */
    void createVOCDocument(Integer x1,Integer y1,Integer x2,Integer y2
            ,Integer x3,Integer y3,Integer x4,Integer y4,String path
            ,String plateNumber);


}
