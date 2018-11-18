package codereview.Concurrcy;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * Created by gshan on 2018/11/18
 */
public class CyclicBarrierTest {

    public static void main(String[] args) {
        CyclicBarrier cyc = new CyclicBarrier(5);
        for(int i=0;i<5;i++){
            new Thread(new MyThread(i,cyc)).start();
        }
    }

    static class MyThread implements Runnable{

        private int id;

        private CyclicBarrier cyc;

        public MyThread(int id,CyclicBarrier cyc){
            this.id = id;
            this.cyc =cyc;
        }

        @Override
        public void run(){
            try{
                cyc.await();
                System.out.println("Thread "+id);
            }catch (InterruptedException e){
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        }
    }
}
