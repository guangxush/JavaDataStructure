package codingInterviews;

public class LearnString {
	public static void main(String[] args) {
		String a = "hello";//存放在栈内存中
		String b = "hello";
		String c = b;
		String d = new String("hello");//存放在堆内存中
		System.out.println(a==b);
		System.out.println(b==c);
		System.out.println(a==c);
		System.out.println(a==d);
		System.out.println(a.equals(b));
		System.out.println(a.equals(c));
		System.out.println(c.equals(b));
		System.out.println(a.equals(b));//==是比较地址，equals()比较对象内容。
	}
}
