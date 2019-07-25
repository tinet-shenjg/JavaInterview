# 堆内存溢出

> 堆内存设置参数    
-Xmx mx是memory max的缩写，指的是最大堆内存   
-Xms ms是memory start的缩写，指的是初始堆内存    

---
建议在设置堆大小时Xms和Xmx设置为相同值，避免因为GC和对象的创建导致的堆内存变化引起的
一系列性能开销      

## 测试堆内存溢出
1. 编写代码
```java
/**
 * 堆内存溢出
 *
 * <p>JVM参数设置
 * -Xms20m -Xmx20m -XX:+HeapDumpOnOutOfMemoryError
 * </p>
 *
 * @author shenjg
 * @date 2019/07/25
 **/
public class HeapOOM {

    static class OOM {
    }

    public static void main(String[] args) {
        List<OOM> oomList = new ArrayList<>();

        while (true) {
            oomList.add(new OOM());
        }

    }
}

```
设置jvm参数
```jvm
-Xms20m -Xmx20m -XX:+HeapDumpOnOutOfMemoryError
```

启动后可以看到如下信息
```java
java.lang.OutOfMemoryError: Java heap space
Dumping heap to java_pid24425.hprof ...
Heap dump file created [27841431 bytes in 0.388 secs]
Exception in thread "main" java.lang.OutOfMemoryError: Java heap space
	at java.util.Arrays.copyOf(Arrays.java:3210)
	at java.util.Arrays.copyOf(Arrays.java:3181)
	at java.util.ArrayList.grow(ArrayList.java:261)
	at java.util.ArrayList.ensureExplicitCapacity(ArrayList.java:235)
	at java.util.ArrayList.ensureCapacityInternal(ArrayList.java:227)
	at java.util.ArrayList.add(ArrayList.java:458)
	at heapoom.HeapOOM.main(HeapOOM.java:22)

```

此时可以使用内存分析工具去分析，推荐使用JProfiler



