package heapoom;

import java.util.ArrayList;
import java.util.List;

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
