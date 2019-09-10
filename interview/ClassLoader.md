# 类加载的过程是怎么样的？
    类加载过程： 加载—验证—准备---解析-—初始化    
    加载阶段：通过类的全限定名读取类文件产生的二进制字节流，将字节流代表的静态存储结构转化为方法区的运行时数据结构，生成java.lang.Class实例     
    验证阶段：确保Class字节流中的信息符合当前虚拟机的要求，验证文件格式、元数据、字节码和符号引用。
    准备阶段：为静态变量分配内存，设置数据类型的零值。
    解析阶段：将常量池中的符号引用转为直接引用，解析类（接口）、字段、类（接口）方法
    初始化阶段：执行类构造器方法<clinit>，
# 两个不同的类加载器加载同一个类，如何进行区分和隔离？
        两个不同的类加载器加载同一个类，加载出来的是两个不同的类。一般可使用自定义类加载器来进行隔离。