/**
 * 类加载
 *
 * @author shenjg
 * @date 2019/07/26
 **/
public class ClassLoader {
    public static void main(String[] args) {
        ClassLoader classLoader = new ClassLoader();
        // 打印类加载器
        System.out.println(classLoader.getClass().getClassLoader());
    }
}
