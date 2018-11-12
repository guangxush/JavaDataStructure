package codingInterviews;

public class LearnString {
	public static void main(String[] args) {
		String a = "hello";//存放在栈内存中
		String b = "hello";
		String c = b;
		String d = new String("hello");//存放在堆内存中
		System.out.println(a==b);//true
		System.out.println(b==c);//true
		System.out.println(a==c);//true
		System.out.println(a==d);//false
		System.out.println(a.equals(b));//true
		System.out.println(a.equals(c));//true
		System.out.println(c.equals(b));//true
		System.out.println(a.equals(b));//true
		//==是比较地址，equals()比较对象内容。
		String A = new String("hello");
		String B = new String("hello");
		System.out.println(A.equals(B));//true
		System.out.println(A==B);//false
	}
}
