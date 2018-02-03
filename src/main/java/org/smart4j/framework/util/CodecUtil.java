package org.smart4j.framework.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

public final class CodecUtil {

    private static final Logger LOGGER = LoggerFactory.getLogger(CodecUtil.class);

    /**
     * 将url编码
     * @param source
     * @return
     */
    public static String encodeURL(String source){
        String target = null;

        try {
            target= URLEncoder.encode(source,"UTF-8");
        } catch (UnsupportedEncodingException e) {
            LOGGER.error("编码url失败",e);
            throw new RuntimeException(e);
        }
        return target;
    }

    /**
     * 解码url
     * @param source
     * @return
     */
    public static String decodeURL(String source){
        String target=null;

        try {
            target= URLDecoder.decode(source,"UTF-8");
        } catch (UnsupportedEncodingException e) {
            LOGGER.error("url解码失败",e);
            throw new RuntimeException(e);
        }
        return target;
    }
}
