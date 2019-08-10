package base;

/**
 * 基类测试
 *
 * 基类构造器最先初始化
 *
 * 基类构造器 1.总是会被初始化；2在导出类构造器之前被调用
 *
 * @author shenjg
 * @date 2019/08/10
 **/
class Art {
    Art(){
        System.out.println("Art.class constructor");
    }
}

class Drawing extends Art{
    Drawing(){
        System.out.println("Drawing.class constructor");
    }
}

public class BaseClassTest extends Drawing{

    BaseClassTest(){
        System.out.println("BaseClassTest.class constructor");
    }

    /**
     * return
     * Art.class constructor
     * Drawing.class constructor
     * BaseClassTest.class constructor
     *
     * @param args
     */
    public static void main(String[] args) {
        BaseClassTest baseClassTest = new BaseClassTest();
    }

}
