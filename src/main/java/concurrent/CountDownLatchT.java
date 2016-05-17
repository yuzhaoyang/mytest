package concurrent;

import java.util.Random;
import java.util.concurrent.*;

/**
 * 同步辅助类:完成一组线程执行前,使得一个或多个线程一直等待
 *
 * Created by yzy.
 */
public class CountDownLatchT {

    // 线程中止的计数器
    private final static int COUNT = 10;
    private final static CountDownLatch latch = new CountDownLatch(COUNT);

    // 线程池
    private final static ExecutorService pool = Executors.newFixedThreadPool(5);

    public static void main(String[] args) throws InterruptedException {

        for (int i = 0; i < COUNT; i++) {

            pool.execute(new Runnable() {

                @Override
                public void run() {
                    try {
                        int time = new Random().nextInt(2000);
                        Thread.sleep(time);
                        System.out.printf("Thread %s ## 耗时:%d\n", Thread.currentThread().getId(), time);

                        // 线程结束后,计数器减一
                        latch.countDown();

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            });
        }

        System.out.println("主线程一直被阻塞,直到latch为0,实现线程同步");
        latch.await();
        System.out.println("主线程恢复执行,此时做任务的线程,都已完毕");

        pool.shutdown();



    }
}



