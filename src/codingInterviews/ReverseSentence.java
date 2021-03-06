package codingInterviews;
/**
 * 输入一个英文句子，翻转句子中单词的顺序，但单词内字符的顺序不变。
 * 为简单起见，标点符号和普通字母一样处理。
 * 例如输入字符串“I am a student.”，则输出“student. a am I”.
 */
public class ReverseSentence {
	public void reverseSentence(String sentence){
		if(sentence==null) return;
		String[] str = sentence.split(" ");
		StringBuffer sb = new StringBuffer();
		for(int i=str.length-1;i>=0;i--) {
			sb.append(str[i]+" ");
		}
		System.out.println(sb);
	}
	public static void main(String[] args) {
		ReverseSentence p=new ReverseSentence();
		String string="I am a student.";
		p.reverseSentence(string);
	}
}
