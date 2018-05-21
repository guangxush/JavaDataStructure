package codingInterviews;
/**
 * 字符串的左旋转操作是把字符串前面的若干个字符转移到字符串的尾部。
 * 请定义一个函数实现字符串左旋转操作的功能。
 * 比如输入字符串“abcdefg”和数字2.该函数左旋转2位得到的结果“cdefgab". 
 */
public class LeftRotateString {
	public void leftRotateString(String sentence,int index){
		if(sentence==null||sentence.length()==0||index>sentence.length()||index<0)
			return;
		String[] splitString= {sentence.substring(0,index),sentence.substring(index,sentence.length()-1)};
		StringBuffer resultBuffer = new StringBuffer();
		for(String s:splitString) {
			resultBuffer.append(reverse(s));//反转前面两个
		}
		System.out.println(reverse(resultBuffer.toString()));//整体反转
	}
	public String reverse(String str) {
		char[] array = str.toCharArray();
		for(int i=0;i<(array.length+1)/2;i++) {
			char temp = array[i];
			array[i] = array[array.length-1-i];
			array[array.length-1-i]=temp;
		}
		return String.valueOf(array);
	}
}
/**
 * 经典的三次翻转：
 * 1.先翻转字符串前n个字符；
 * 2.再翻转后面的字符；
 * 3.翻转整个字符串
 */
