package com.garbo.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.text.SimpleDateFormat;

/**
 * @author garbo
 * @description JSON工具类
 * @create 2021-01-12 10:27
 */
public class JsonUtils {

    private static ObjectMapper mapper = new ObjectMapper();

    public static String objectToString(Object obj) {
        return objectToString(obj, "yyyy-MM-dd HH:mm:ss");
    }

    public static String objectToString(Object obj, String dateFormat) {
        String json;
        // 自定义日期格式对象
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(dateFormat);
        // 指定日期格式
        mapper.setDateFormat(simpleDateFormat);
        // 解析
        try {
            json = mapper.writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("生成json出错");
        }
        return json;
    }
}
