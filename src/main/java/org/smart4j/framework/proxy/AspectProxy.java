package org.smart4j.framework.proxy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Method;

public abstract class AspectProxy implements Proxy {


    private static final Logger logger= LoggerFactory.getLogger(AspectProxy.class);

    @Override
    public Object doProxy(ProxyChain proxyChain) throws Throwable {
        Object result=null;

        Class<?> targetClass=proxyChain.getTargetClass();
        Method targetMethod=proxyChain.getTargetMethod();
        Object[] targetPrams=proxyChain.getTargetParams();

        begin();
        try {
            if(intercept(targetClass,targetMethod,targetPrams)){
                before(targetClass,targetMethod,targetPrams);
                result=proxyChain.doProxyChain();
                after(targetClass,targetMethod,targetPrams);
            }else {
                result=proxyChain.doProxyChain();
            }
        }catch (Exception e){
            logger.error("proxy failure",e);
            error(targetClass,targetMethod,targetPrams);
            throw e;
        }finally {
            end();
        }
        return result;
    }

    public void begin(){

    }


    public boolean intercept(Class<?> targetCls,Method targetMethod,Object[] params) throws Throwable{
        return true;
    }

    public boolean before(Class<?> targetCls,Method targetMethod,Object[] params) throws Throwable{
        return true;
    }

    public boolean after(Class<?> targetCls,Method targetMethod,Object[] params) throws Throwable{
        return true;
    }

    public void error(Class<?> targetCls,Method targetMethod,Object[] params) throws Throwable{

    }

    public void end(){

    }
}
