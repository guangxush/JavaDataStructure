package codereview.SingletonModel;

public class SynLanHanDemo {
    //懒汉模式，创建的时候啥也不做，需要的时候再去创建
    private static SynLanHanDemo instance  = null;

    //私有化构造函数
    private SynLanHanDemo(){}

    public SynLanHanDemo getInstance(){
        if(instance == null)
            instance = new SynLanHanDemo();
        return instance;
    }

    //可以创建一个单例的，但是缺点是每次获取都会都会去并发阻塞判断以下，效率很低
}
