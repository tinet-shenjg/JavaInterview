package base;

/**
 * 基类测试2
 *
 * @author shenjg
 * @date 2019/08/10
 **/

class A{
    A(){
        System.out.println("A constructor");
    }
}

class B{
    B(){
        System.out.println("B constructor");
    }
}


public class BaseClassTest2 extends A{
    private B b;

    /**
     *
     * return A constructor
     * @param args
     */
    public static void main(String[] args) {
        BaseClassTest2 baseClassTest2 = new BaseClassTest2();
    }
}
