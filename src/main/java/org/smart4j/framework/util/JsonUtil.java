package org.smart4j.framework.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

/**
 * json工具类
 */
public class JsonUtil {

    private static final Logger LOGGER= LoggerFactory.getLogger(JsonUtil.class);

    private static final ObjectMapper OBJECT_MAPPER=new ObjectMapper();

    /**
     * 将pojo转成json
     * @param obj
     * @return
     */
    public static<T> String toJson(T obj) {
        String json;
        try {
            json=OBJECT_MAPPER.writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            LOGGER.error("pojo转json失败",e);
         throw new RuntimeException(e);
        }
        return json;
    }

    public static <T> T fromJson(String json,Class<T> type){
        T pojo;
        try {
            pojo=OBJECT_MAPPER.readValue(json,type);
        } catch (IOException e) {
            LOGGER.error("json转pojo失败",e);
            throw new RuntimeException(e);
        }
        return pojo;
    }
}
