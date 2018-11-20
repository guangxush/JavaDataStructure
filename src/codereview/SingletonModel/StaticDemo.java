package codereview.SingletonModel;

public class StaticDemo {

    private StaticDemo(){}

    //类的加载过程是线程互斥的
    private static class StaticDemoContainer{
        private static StaticDemo instance = new StaticDemo();
    }

    public static StaticDemo getInstance(){
        return StaticDemoContainer.instance;
    }
    //最后instance是在第一次加载SingletonContainer类时被创建的，
    // 而SingletonContainer类则在调用getInstance方法的时候才会被加载，因此也实现了惰性加载
}
