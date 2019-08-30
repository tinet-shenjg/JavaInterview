/**
 * @author shenjg
 * @date 2019/07/29
 **/
public class IntegerCompare {

    public static void main(String[] args) {
        Integer a = 1;
        Integer b = 2;
        Integer a1 = new Integer(1);
        Integer b1 = new Integer(2);
        int a2 = 1;
        int b2 = 2;

        System.out.println(a1.getClass().getClassLoader());

        System.out.println(a == a1);
        System.out.println(a == a2);
        System.out.println(a1 == a2);

        System.out.println(b == b1);
        System.out.println(b == b2);
        System.out.println(b1 == b2);


    }

}
