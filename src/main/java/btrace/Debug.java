package btrace;

import com.sun.btrace.annotations.BTrace;
import com.sun.btrace.annotations.OnMethod;

import static com.sun.btrace.BTraceUtils.println;

@BTrace
public class Debug {
    @OnMethod(clazz="com.xiaoju.manhattan.archimedes.auto.SubProcess1", method="test1")
    public static void onThreadStart() {
        println("debug!!!!");
    }
}
