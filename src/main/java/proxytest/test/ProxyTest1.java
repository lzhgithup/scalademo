package proxytest.test;

import proxytest.Cal;
import proxytest.CalImpl;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author lizhihao
 * @date 2020/05/26 12:28
 **/
public class ProxyTest1 {

    public static void main(String[] args) throws Exception{
        Cal cal = new CalImpl();
        //获取代理类对象
        Cal calProxy = (Cal) ProxyTest1.getProxy(cal);
        System.out.println(calProxy.add(1, 1));
    }


    public static Object getProxy(final Object target) throws Exception{
        //根据目标类实例获取代理类Class对象
        Class<?> proxyClass = Proxy.getProxyClass(target.getClass().getClassLoader(), target.getClass().getInterfaces());
        //获取代理类对象的有参构造器
        Constructor<?> constructor = proxyClass.getConstructor(InvocationHandler.class);
        //调用有参构造器实例化代理类
        return constructor.newInstance(new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println(proxy.getClass().getName());
                //调用目标类对象的对应方法
                return method.invoke(target, args);
            }
        });
    }
}
