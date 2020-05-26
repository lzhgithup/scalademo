package proxytest.test;

import proxytest.Cal;
import proxytest.CalImpl;
import proxytest.advice.Advice;
import proxytest.selflog.MyLogger;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 自定义日志通知测试
 * @author lizhihao
 * @date 2020/05/26 13:22
 **/
public class MyLoggerProxyTest {
    public static void main(String[] args) {
        Cal cal = new CalImpl();
        Cal calProxy = (Cal) MyLoggerProxyTest.getProxy(cal, new MyLogger());
        System.out.println(calProxy.add(4, 5));
        System.out.println("==================== 分割 ====================");
        System.out.println(calProxy.multiply(4, 5));
    }

    public static Object getProxy(final Object target, Advice log) {
        Class<?> targetClass = target.getClass();
        return Proxy.newProxyInstance(targetClass.getClassLoader(), targetClass.getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                log.before(method);
                Object result = method.invoke(target, args);
                log.after(method);
                return result;
            }
        });
    }
}
