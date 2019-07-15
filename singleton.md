## 什么是单例模式   
  单例模式（Singleton Pattern）是 Java 中最简单的设计模式之一。这种类型的设计模式属于创建型模式，它提供了一种创建对象的最佳方式。

这种模式涉及到一个单一的类，该类负责创建自己的对象，同时确保只有单个对象被创建。这个类提供了一种访问其唯一的对象的方式，可以直接访问，不需要实例化该类的对象。  

---
注意：
1. 单例类只能有一个实例。
2. 单例类必须自己创建自己的唯一实例。
3. 单例类必须给所有其他对象提供这一实例。
---
单例模式  保证一个类只有一个实例，并提供一个全局访问方法。   
##　实现方法：　 
　
1. 懒汉式单例---线程不安全
```
/**
 * 懒汉式单例---线程不安全
 *
 * @author shenjg
 * @date 2019/07/15
 */
public class Singleton {

    private static Singleton signleton;

    private Singleton() {

    }

    private Singleton getSignleton() {
        if (signleton == null) {
            return new Singleton();
        }
        return signleton;
    }

}
```  
     
2. 懒汉式单例---线程安全
```
/**
 * 懒汉式单例---线程安全
 *
 * @author shenjg
 * @date 2019/07/15
 */
public class Singleton {

    private static Singleton signleton;

    private Singleton() {

    }

    /**
     * synchronized同步方法实现线程安全，效率较低
     *
     * @return
     */
    private static synchronized Singleton getSignleton() {
        if (signleton == null) {
            return new Singleton();
        }
        return signleton;
    }

}
```
3.  饿汉式单例---线程安全
```
/**
 * 饿汉式单例---线程安全
 * 优点：没有加锁，执行效率会提高。
 * 缺点：类加载时就初始化，浪费内存，容易产生垃圾对象。
 *
 * @author shenjg
 * @date 2019/07/15
 */
public class Singleton {

    private static Singleton signleton = new Singleton();

    private Singleton() {

    }

    private Singleton getSignleton() {
        return signleton;
    }

}
```
