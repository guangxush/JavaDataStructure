package codereview;

/**
 * Created by gshan on 2018/11/17
 */
public class ThreadLocalTest extends Thread{

    private Res res;
    public ThreadLocalTest(Res res) {
        this.res = res;
    }

    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            System.out.println(Thread.currentThread().getName() + "---" + "i---" + i + "--num:" + res.getNum());
        }
    }
    public static void main(String[] args) {
        Res res = new Res();
        ThreadLocalTest threadLocaDemo1 = new ThreadLocalTest(res);
        ThreadLocalTest threadLocaDemo2 = new ThreadLocalTest(res);
        ThreadLocalTest threadLocaDemo3 = new ThreadLocalTest(res);
        threadLocaDemo1.start();
        threadLocaDemo2.start();
        threadLocaDemo3.start();
    }
}
class Res{
    // 生成序列号共享变量
    public static Integer count = 0;
    public static ThreadLocal<Integer> threadLocal = new ThreadLocal<Integer>() {
        protected Integer initialValue() {
            return 0;
        };
    };
    public Integer getNum() {
        int count = threadLocal.get() + 1;
        threadLocal.set(count);
        return count;
    }
}
