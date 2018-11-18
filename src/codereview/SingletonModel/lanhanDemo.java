package codereview.SingletonModel;

/**
 * Created by gshan on 2018/11/18
 */
public class lanhanDemo {
    //懒汉模式，创建的时候啥也不做，需要的时候再去创建
    private static lanhanDemo instance  = null;

    //私有化构造函数
    private lanhanDemo(){}

    public synchronized lanhanDemo getInstance(){
        if(instance == null)
            instance = new lanhanDemo();
        return instance;
    }
}
