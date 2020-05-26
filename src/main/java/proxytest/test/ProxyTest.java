package proxytest.test;

import proxytest.Cal;

import java.lang.reflect.*;

/**
 * java.lang.reflect.InvocationHandler
 * java.lang.reflect.Proxy => Proxy.getProxyClass(): get proxy class objects
 *
 * @author lizhihao
 * @date 2020/05/26 09:33
 **/
public class ProxyTest {

    public static void main(String[] args) throws Exception{
        //通过接口的Class对象获取到实现类(代理类)的Class对象
        Class<?> proxyClass = Proxy.getProxyClass(Cal.class.getClassLoader(), Cal.class);
        System.out.println(proxyClass.getName());
        Constructor<?>[] constructors = proxyClass.getConstructors();
        printClassInfo(constructors);
        //实例化代理类，发现无法实例化，因为生成的代理类中没有无参构造，newInstance()底层默认执行无参构造
        //Object o = proxyClass.newInstance();
        //获取有参构造器
        Constructor<?> constructor = proxyClass.getConstructor(InvocationHandler.class);
        //实例化，传入InvocationHandler匿名对象作为构造器参数
        Cal cal = (Cal) constructor.newInstance(new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("执行...");
                return 1;
            }
        });
        System.out.println("============");
        System.out.println(cal.add(5,4));
        System.out.println(cal.multiply(5,4));
        //调用任何一个代理对象的方法都返回1，也就是说调用实现了接口的代理类中任何一个方法，那么这个方法的内部都会调用InvocationHandler的实例中的invoke(...)并返回它的值
        //可以猜测，代理类的内部有一个InvocationHandler的成员变量，因为不管调用哪个方法都会调用到它的invoke(...)方法
        //invoke(...)方法是代理对象和目标对象的桥梁
    }

    public static void printClassInfo(Executable[] targets) {
        for (Executable target : targets) {
            // 构造器/方法名称
            String name = target.getName();
            StringBuilder sBuilder = new StringBuilder(name);
            // 拼接左括号
            sBuilder.append('(');
            Class[] clazzParams = target.getParameterTypes();
            // 拼接参数
            for (Class clazzParam : clazzParams) {
                sBuilder.append(clazzParam.getName()).append(',');
            }
            //删除最后一个参数的逗号
            if (clazzParams != null && clazzParams.length != 0) {
                sBuilder.deleteCharAt(sBuilder.length() - 1);
            }
            //拼接右括号
            sBuilder.append(')');
            //打印 构造器/方法
            System.out.println(sBuilder.toString());
        }
    }
}
