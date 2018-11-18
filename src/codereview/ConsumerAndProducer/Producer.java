package codereview.ConsumerAndProducer;

import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by gshan on 2018/11/18
 */
public class Producer implements Runnable{
    private final Vector sharedQueue;
    private final int SIZE;

    public Producer(Vector sharedQueue, int size){
        this.sharedQueue = sharedQueue;
        this.SIZE = size;
    }

    @Override
    public void run(){
        for(int i=0;i<7;i++){
            System.out.println("Producer:"+ i );
            try{
                procuder(i);
            }catch (InterruptedException e){
                Logger.getLogger(Producer.class.getName()).log(Level.SEVERE,null,e);
            }
        }
    }

    private void procuder(int i)throws InterruptedException{
        //wait if queue is full
        while(sharedQueue.size()==SIZE){
            synchronized(sharedQueue){
                System.out.println("Queue is full"+Thread.currentThread().getName()
                +"is waiting, size:"+sharedQueue.size());
                sharedQueue.wait();
            }
        }
        //producing element and notify consumers
        synchronized(sharedQueue){
            sharedQueue.add(i);
            sharedQueue.notify();
        }
    }
}
