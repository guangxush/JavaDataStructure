package codereview.SingletonModel;

/**
 * Created by gshan on 2018/11/18
 */
public class LanHanDemo {
    //懒汉模式，创建的时候啥也不做，需要的时候再去创建
    private static LanHanDemo instance  = null;

    //私有化构造函数
    private LanHanDemo(){}

    public LanHanDemo getInstance(){
        if(instance == null)
            instance = new LanHanDemo();
        return instance;
    }

    //如果A线程在执行if之后正在创建一个instance但是还没创建好
    //此时B线程也进入if判断，这样A B两个线程会同时创建两个实例
}
