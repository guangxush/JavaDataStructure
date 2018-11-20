package codereview.SingletonModel;

public class DoubleCheckDemo {

    private DoubleCheckDemo instance = null;
    //可以将instance修饰为volatile

    private DoubleCheckDemo(){}

    public DoubleCheckDemo getInstances(){
        if(instance == null){//避免已经有的时候进入synchronized块消耗资源
            synchronized (instance){
                if(instance==null){
                    instance = new DoubleCheckDemo();
                }
            }
        }
        return instance;
    }

    //1. A、B线程同时进入了第一个if判断
    //2. A首先进入synchronized块，由于instance为null，所以它执行instance = new Singleton();
    //3. 由于JVM内部的优化机制，JVM先画出了一些分配给Singleton实例的空白内存，并赋值给instance成员（注意此时JVM没有开始初始化这个实例），然后A离开了synchronized块。
    //4. B进入synchronized块，由于instance此时不是null，因此它马上离开了synchronized块并将结果返回给调用该方法的程序。
    //5. 此时B线程打算使用Singleton实例，却发现它没有被初始化，于是错误发生了。
}
