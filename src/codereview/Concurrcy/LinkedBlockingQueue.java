package codereview.Concurrcy;

import java.util.LinkedList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by gshan on 2018/11/18
 */
public class LinkedBlockingQueue<E> {
    private final int capacity;

    private Lock lock = new ReentrantLock();

    private Condition full = lock.newCondition();

    private Condition empty = lock.newCondition();

    private int count;

    private LinkedList<E> queue;

    public LinkedBlockingQueue()throws InterruptedException{
        this.capacity = Integer.MAX_VALUE;
    }

    public LinkedBlockingQueue(int capacity){
        this.capacity = capacity;
        queue = new LinkedList<E>();
    }

    public void put(E e)throws InterruptedException{
        lock.lock();
        try{
            while(count == capacity){
                full.await();
            }
            queue.add(e);
            count++;
            empty.signal();
        }finally {
            lock.unlock();
        }
    }

    public E take()throws InterruptedException{
        lock.lock();
        try{
            while(count==0){
                empty.await();
            }
            E e = queue.pop();
            count --;
            full.signal();
            return e;
        }finally {
            lock.unlock();
        }
    }
}
