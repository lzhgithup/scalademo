package proxytest;

/**
 * @author lizhihao
 * @date 2020/05/26 12:35
 **/
public class CalImpl implements Cal {
    @Override
    public int add(int a, int b) {
        System.out.println("add ...");
        return a + b;
    }

    @Override
    public int multiply(int a, int b) {
        System.out.println("multiply ...");
        return a * b;
    }
}
