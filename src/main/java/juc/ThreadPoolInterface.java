package juc;

/**
 * zhouzhongqing
 * 2018年5月6日13:53:35
 * 接口
 * */
public interface ThreadPoolInterface {

    /**
     * @param task
     * @return
     * 添加任务
     */
    int addWork(Runnable task);


    /**
     * 停止全部线程执行任务
     * @return int
     * 
     */
    int stopAll();

}