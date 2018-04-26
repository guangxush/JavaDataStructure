package codingInterviews;
/**
 * 懒汉式单例模式
 */
public class SingletonClass2 {
	private static SingletonClass2 instance = null;
	//私有构造函数
	private SingletonClass2() {}
	//加同步锁确保在多线程环境下至创建一个实例
	public synchronized static SingletonClass2 getInstance() {
		if(instance == null)
			instance = new SingletonClass2(); 
		return instance;
	}
}
