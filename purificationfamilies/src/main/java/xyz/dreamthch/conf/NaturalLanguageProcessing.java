package xyz.dreamthch.conf;

import com.baidu.aip.nlp.AipNlp;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Test;

import java.util.HashMap;

public class NaturalLanguageProcessing {

    @Test
    public void test() throws JSONException {
        AipNlp aipNlp = new AipNlp(ConfAttribute.APPID_Language,ConfAttribute.APIKEY_Language
                                    ,ConfAttribute.SECRETKEY_Language);
        String text = "今天天气不错啊";
        HashMap<String, Object> options = new HashMap<String, Object>();
        JSONObject res = aipNlp.sentimentClassify(text, options);
        JSONArray items = res.getJSONArray("items");
        for (int i = 0; i < items.length(); i++) {
            double confidence = (double) items.getJSONObject(i).get("confidence");
            double positive_prob = (double) items.getJSONObject(i).get("positive_prob");
            double negative_prob = (double) items.getJSONObject(i).get("negative_prob");
            System.out.println(confidence);
            System.out.println(positive_prob);
            System.out.println(negative_prob);
            if (confidence > ConfAttribute.CONFIDENCEFLAG && positive_prob > ConfAttribute.FLAG && negative_prob < ConfAttribute.FLAG){
                System.out.println("积极态度");
            }else {
                System.out.println("消极态度");
            }
        }
        //置信度 confidence

        //积极态度 positive_prob

        //消极态度 negative_prob

        //表示情感极性分类结果, 0:负向，1:中性，2:正向 sentiment
    }


}
