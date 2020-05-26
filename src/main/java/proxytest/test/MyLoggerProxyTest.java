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
 *
 * AOP:
 * 1.交叉业务的编程问题即为面向切面编程，AOP的目标就是使交叉业务模块化；
 * 2.动态代理其实就是代理对象调用目标对象的同名方法，并在调用前后加上增强代码。不过这两种最终运行效果是一样的。
 * 3.必须要注意的是，若类中存在多个方法，比如有方法A和方法B，若在方法A中调用了方法B，此时内部的方法B是无法被代理的，这是因为：
 *   我们在执行代理类的方法A时，在这个过程中也去调用了目标类的方法A
 *   Object result = method.invoke(target, args)，此时传入的是target对象，该对象是目标类实例，那么在内部调用方法B时，
 *   执行的就会时目标类对象的方法B
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
