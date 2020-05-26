package proxytest.test;

import proxytest.Cal;
import proxytest.CalImpl;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Proxy.newProxyInstance(...)直接创建了代理类的实例，而无需我们自己去调用有参构造器创建代理类的对象
 * @author lizhihao
 * @date 2020/05/26 12:40
 **/
public class ProxyTest2 {

    public static void main(String[] args) {
        Cal cal = new CalImpl();
        Cal calProxy = (Cal) ProxyTest2.getProxy(cal);
        System.out.println(calProxy.add(1, 2));
        System.out.println(calProxy.multiply(1, 2));
    }

    public static Object getProxy(final Object target) {
        //调用Proxy.getProxyClass(..)之后，还需我们自己去获取有参构造器去实例化代理类对象，而newProxyInstance(...)则直接帮我们省略了那些步骤
        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("==========");
                return method.invoke(target, args);
            }
        });
    }
}
