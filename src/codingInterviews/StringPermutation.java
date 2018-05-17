package codingInterviews;
/**
 * 输入一个字符串，打印出该字符串中字符的所有排列
 */
public class StringPermutation {
	public void permutation(char[] s,int from,int to){
		if(to<=1) return;//元素只有一个直接输出
		if(from==to)//递归的出口
			System.out.println(s);
		else {
			for(int i=from;i<=to;i++) {
				swap(s,i,from);//交换前缀，使其产生下一个前缀
				permutation(s,from+1,to);//对后面所有的字符进行全排列  
				swap(s,from,i);//将前缀换回，继续做上一个前缀的排列
			}
		}
	}
	public static void swap(char[] s,int i,int j) {
        char tmp = s[i];
        s[i] = s[j];
        s[j] = tmp;
    }
	public static void main(String args[])
	{
		StringPermutation testPermutation=new StringPermutation();
		testPermutation.permutation("abcd".toCharArray(),0,"abcd".length()-1);
	}
}
/**
 * 把字符串分成两部分，一个是以第一个字符，一个是第一个字符以后的其他字符
 * 接下来求第一个字符后面的排列，并拿第一个字符与后面的字符逐个交换
 */
