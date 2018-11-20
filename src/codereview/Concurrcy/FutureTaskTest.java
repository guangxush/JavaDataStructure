package codereview.Concurrcy;

import java.util.concurrent.*;

public class FutureTaskTest {

    private static int max(int[] data) throws ExecutionException, InterruptedException {
        if(data.length==0)
            throw new IllegalArgumentException("The data is null");
        if(data.length==1)
            return data[0];
        //divide the tasks to two task
        FindMaxTask task1 = new FindMaxTask(data,0,data.length/2);
        FindMaxTask task2 = new FindMaxTask(data,data.length/2,data.length);

        //create two thread to calculate
        ExecutorService es = Executors.newFixedThreadPool(2);

        Future<Integer> future1 = es.submit(task1);
        Future<Integer> future2 = es.submit(task2);

        return Math.max(future1.get(), future2.get());
    }

    public static void main(String[] args) throws Exception{
        int[] data = {1,2,64,2,5,7,4,8,9,1,12,35};
        int result = max(data);
        System.out.println(result);
    }
}

class FindMaxTask implements Callable<Integer>{
    private int[] data;
    private int start;
    private int end;

    public FindMaxTask(int[] data, int start, int end) {
        this.data = data;
        this.start = start;
        this.end = end;
    }

    @Override
    public Integer call(){
        int max = Integer.MIN_VALUE;
        for(int i=start;i<end;i++){
            if(data[i]>max)
                max = data[i];
        }
        return max;
    }
}
