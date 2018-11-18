package codereview.Concurrcy;

import java.util.concurrent.CountDownLatch;

/**
 * Created by gshan on 2018/11/18
 */
public class CountDownLatchTest {
    /**
     * CountDownLatch： 是通过一个计数器来实现的，计数器的初始值为线程的数量。
     * 每当一个线程完成了自己的任务后，计数器的值就会减1。
     * 当计数器值到达0时，它表示所有的线程已经完成了任务，然后在闭锁上等待的线程就可以恢复执行任务。
     */

    private final CountDownLatch latch= new CountDownLatch(10);

    public CountDownLatchTest(){
    }

    public void doRun(int n) throws InterruptedException{
        System.out.println("Start create thread!");
        for(int i=0;i<n;i++){
            new MyThread(i).start();
            latch.countDown();//count--
        }
        System.out.println("wait son thread!");
        latch.await();
        Thread.sleep(5000);
        System.out.println("main thread finished!");
    }

    class MyThread extends Thread{

        private int type;

        public MyThread(int type){
            this.type = type;
        }

        @Override
        public void run(){
            try{
                Thread.currentThread().sleep(1000);
                System.out.println("Thread "+type);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        CountDownLatchTest countDownLatchTest = new CountDownLatchTest();
        try{
            countDownLatchTest.doRun(10);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
