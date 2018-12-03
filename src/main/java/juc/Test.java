package juc;






public class Test {



    public static void main(String[] args) {

         Runnable run = new Runnable() {


                public void run() {

                    System.out.println("当前执行任务的线程名称"+ Thread.currentThread() + "---------");

                }
            };

            Long starTime = System.currentTimeMillis();

        ThreadPoolInterface ti = (ThreadPoolInterfaceImpl)new ThreadPoolInterfaceImpl();

        for (int i = 0; i < 111111110; i++) {
            ti.addWork(run);
        }

        Long endTime = System.currentTimeMillis();
        System.out.println("耗时："+(endTime-starTime));



    }







}