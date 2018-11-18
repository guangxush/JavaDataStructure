package codereview.Concurrcy;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by gshan on 2018/11/18
 */
public class TestThreadPool {

    class MyThread implements Runnable{
        private Integer type;
        public MyThread(){
            super();
        }
        public MyThread(Integer type){
            super();
            this.type = type;
        }

        @Override
        public void run(){
            System.out.println("type:"+type);
        }
    }

    public void doRun(int n){
        ExecutorService es = Executors.newCachedThreadPool();
        System.out.println("Start create thread!");
        List<Integer> typeList = new ArrayList<>();
        for(int i=0;i<n;i++){
            typeList.add(i+1);
        }
        for(int i=0;i<typeList.size();i++){
            Integer adjustType = typeList.get(i);
            Runnable myRunnable = new MyThread(adjustType);
            es.execute(myRunnable);
        }
        es.shutdown();
        if(es.isTerminated()){
            System.out.println("All threads finished!");
        }
    }

    public static void main(String[] args) {
        new TestThreadPool().doRun(10);
    }
}

