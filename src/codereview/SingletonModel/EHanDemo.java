package codereview.SingletonModel;

/**
 * Created by gshan on 2018/11/18
 */
public class EHanDemo {
    //饿汉模式，初始化类的时候就创建，表示很饥饿
    private static EHanDemo instance = new EHanDemo();

    //私有化构造函数
    private EHanDemo(){};

    //需要的时候直接返回
    public EHanDemo getInstance(){
        return instance;
    }

    //如果初始化的时候创建好了，但是一直没有用过，会很浪费资源
}
