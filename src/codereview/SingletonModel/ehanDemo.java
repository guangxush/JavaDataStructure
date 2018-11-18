package codereview.SingletonModel;

/**
 * Created by gshan on 2018/11/18
 */
public class ehanDemo {
    //饿汉模式，初始化类的时候就创建，表示很饥饿
    private static ehanDemo instance = new ehanDemo();

    //私有化构造函数
    private ehanDemo(){};

    //需要的时候直接返回
    public ehanDemo getInstance(){
        return instance;
    }
}
