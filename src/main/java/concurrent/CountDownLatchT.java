package concurrent;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 同步辅助类:完成一组线程执行前,使得一个或多个线程一直等待
 *
 * Created by bysocket on 16/4/26.
 */
public class CountDownLatchT {

    // 线程中止的计数器
    private final static int COUNT = 10;
    private final static CountDownLatch count = new CountDownLatch(COUNT);

    // 线程池
    private final static ExecutorService service = Executors.newFixedThreadPool(5);

    public static void main(String[] args) throws InterruptedException

    {

    }
}

