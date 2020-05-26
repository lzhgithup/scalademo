package proxytest.advice;

import java.lang.reflect.Method;

/**
 * @author lizhihao
 * @date 2020/05/26 13:19
 **/
public interface Advice {

    void before(Method method);

    void after(Method method);
}
