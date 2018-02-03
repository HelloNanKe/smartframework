package org.smart4j.framework.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;

public final class StreamUtil {
    private static final Logger LOGGER= LoggerFactory.getLogger(StreamUtil.class);

    /**
     * 从输入流中获取字符串
     * @param is
     * @return
     */
    public static String getString(InputStream is){
        StringBuilder sb=new StringBuilder();

        try {

            BufferedReader reader=new BufferedReader(new InputStreamReader(is));

            String line=null;
            while ((line=reader.readLine())!=null){
                sb.append(line);
            }
        } catch (IOException e) {
            LOGGER.error("获取string失败",e);
            throw new RuntimeException(e);
        }
        return sb.toString();
    }
}
