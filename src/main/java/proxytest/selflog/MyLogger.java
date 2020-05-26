package proxytest.selflog;

import proxytest.advice.Advice;

import java.lang.reflect.Method;

/**
 * @author lizhihao
 * @date 2020/05/26 13:20
 **/
public class MyLogger implements Advice {
    @Override
    public void before(Method method) {
        System.out.println(method.getName() + "方法执行前...");
    }

    @Override
    public void after(Method method) {
        System.out.println(method.getName() + "方法执行后...");
    }
}
