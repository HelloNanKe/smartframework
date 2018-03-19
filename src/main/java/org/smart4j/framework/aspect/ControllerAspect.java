package org.smart4j.framework.aspect;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.smart4j.framework.annotation.Aspect;
import org.smart4j.framework.annotation.Controller;
import org.smart4j.framework.proxy.AspectProxy;

import java.lang.reflect.Method;

/**
 * 拦截controller的所有方法
 */
@Aspect(Controller.class)
public class ControllerAspect extends AspectProxy {

    private static final Logger LOGGER= LoggerFactory.getLogger(ControllerAspect.class);

    private long begin;


    @Override
    public void before(Class<?> targetCls, Method targetMethod, Object[] params) throws Throwable {
        LOGGER.debug("------------begin-----------");
        LOGGER.debug(String.format("class name %s",targetCls.getName()));
        LOGGER.debug(String.format("metod name %s",targetMethod.getName()));
        begin=System.currentTimeMillis();

    }

    @Override
    public void after(Class<?> targetCls, Method targetMethod, Object[] params) throws Throwable {
        LOGGER.debug(String.format("执行方法所花时间: %dms",System.currentTimeMillis()-begin));

        LOGGER.debug("------------end------------");
    }
}
