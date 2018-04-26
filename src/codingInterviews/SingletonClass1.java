package codingInterviews;
/**
 * 设计模式题目
 * 实现单例模式
 * 饿汉式单例模式
 */
public class SingletonClass1 {
	//只用于单线程环境
	//使用静态的构造函数
	private static final SingletonClass1 instance = new SingletonClass1();
	//私有构造函数
	private SingletonClass1() {}
	public static SingletonClass1 getInstance() {
		return instance;
	}
}
