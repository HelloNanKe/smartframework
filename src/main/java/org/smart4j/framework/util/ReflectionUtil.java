package org.smart4j.framework.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public final class ReflectionUtil {

    private static final Logger LOGGER = LoggerFactory.getLogger(ReflectionUtil.class);

    /**
     * 创建实例
     * @param cls
     * @return
     */
    public static Object newInstance(Class<?> cls){
        Object instance = null;
        try {
            instance=cls.newInstance();
        } catch (Exception e) {
            LOGGER.error("实例化一个类出错",e);
            throw new RuntimeException(e);

        }
        return instance;
    }

    /**
     * 调用方法
     * @param obj
     * @param method
     * @param args
     * @return
     */
    public static Object invokeMethod(Object obj, Method method,Object ... args){
        Object result = null;
        try {
            method.setAccessible(true);
            result=method.invoke(obj, args);
        } catch (Exception e) {
            LOGGER.error("调用方法",e);
            throw new RuntimeException(e);

        }
        return result;
    }

    /**
     * 设置成员变量的值
     * @param obj
     * @param field
     * @param value
     */
    public static void setField(Object obj, Field field,Object value){
        try {
            field.setAccessible(true);
            field.set(obj,value);
        } catch (IllegalAccessException e) {
            LOGGER.error("设置成员变量的值出错",e);
            throw new RuntimeException(e);
        }

    }
}
