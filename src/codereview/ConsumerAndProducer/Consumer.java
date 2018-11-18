package codereview.ConsumerAndProducer;

import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by gshan on 2018/11/18
 */
public class Consumer implements Runnable{

    private final Vector sharedQueue;
    private final int SIZE;

    public Consumer(Vector sharedQueue,int size){
        this.sharedQueue = sharedQueue;
        this.SIZE = size;
    }

    @Override
    public void run(){
        while(true){
            try{
                System.out.println("Consumer:"+consumer());
                Thread.sleep(50);
            }catch(InterruptedException e){
                Logger.getLogger(Consumer.class.getName()).log(Level.SEVERE, null, e);
            }
        }
    }

    private int consumer() throws InterruptedException{
        while(sharedQueue.isEmpty()){
            synchronized (sharedQueue){
                System.out.println("Queue is empty " + Thread.currentThread().getName()
                        + " is waiting , size: " + sharedQueue.size());
                sharedQueue.wait();
            }
        }
        //otherwise consumer element and notify waiting producer
        synchronized (sharedQueue){
            sharedQueue.notify();
            return (Integer) sharedQueue.remove(0);
        }
    }

}
