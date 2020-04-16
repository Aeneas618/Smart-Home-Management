package xyz.dreamthch.mapper;

import java.util.List;
import java.util.Map;

public interface CoordinateBuilder {
    /**
     * Load txt text data
     * @param path
     * @return
     */
    List<String> readText(String path);

    /**
     * Get voc format coordinate data
     * @param txtData
     * @return
     */
    Map<String,Object> getCoordinateCenter(String txtData);

    void createVOCDocument(Integer x1, Integer x2, Integer y1, Integer y2, String s, String label);
}
