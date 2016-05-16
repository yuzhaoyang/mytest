package concurrent;

import java.util.Random;
import java.util.concurrent.*;

/**
 * 同步辅助类:完成一组线程执行前,使得一个或多个线程一直等待
 *
 * Created by bysocket on 16/4/26.
 */
public class CountDownLatchT {

    // 线程中止的计数器
    private final static int COUNT = 10;
    private final static CountDownLatch latch = new CountDownLatch(COUNT+1);

    // 线程池
    private final static ExecutorService pool = Executors.newFixedThreadPool(5);
    
    private final static CompletionService  service = new ExecutorCompletionService(pool);

    public static void main(String[] args) throws InterruptedException, ExecutionException
    {

        for (int i=0;i< COUNT;i++,latch.countDown()){

            service.submit(new MyCallableThread(latch));

        }

        latch.countDown();

        System.out.print("一声令下,开始执行");

        for (int i = 0; i < COUNT; i++) {

            Object o = service.take().get();

            System.out.println("值分别为"+o);

        }
        
        if (null != pool){
            
            pool.shutdown();
            
        }
        

    }
}


class MyCallableThread implements Callable<Integer>{


    private CountDownLatch latch;

    public MyCallableThread(CountDownLatch latch) {
        this.latch = latch;
    }


    @Override
    public Integer call() throws Exception {
        try {
            //每个线程都等待

            latch.await();

        } catch (Exception e) {
            // 执行错误了，也设置
        }

        Integer i = Integer.valueOf(new Random().nextInt());

        return i ;
    }

}

