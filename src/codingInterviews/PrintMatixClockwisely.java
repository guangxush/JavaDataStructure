package codingInterviews;
/**
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。
 */
public class PrintMatixClockwisely {
	//注意边界条件
	public void printMatixClockwisely(int[][] array){
		if(array==null) {
			return;
		}
		int start = 0;//取左上角的位一圈的起点，start表示循环的圈数
		while(array[0].length>start*2&&array.length>start*2) {
			printOneCircle(array,start);
			start++;//左上角起点往中间靠拢
		}
	}
	private void printOneCircle(int[][] array, int start) {
		for(int i=start;i<array[0].length-start;i++) {//打印第一行
			System.out.print(array[start][i]+ " ");
		}
		if(array.length-1-start>start) {//终止行号大于起始行号
			for(int i=start+1;i<array.length-start-1;i++) {//打印第一行
				System.out.print(array[i][array[0].length-1-start]+ " ");
			}
		}
		if(array[0].length-start-1>start&&array.length-start-1>start) {
			for(int i=array.length-start-1;i>start;i--){
				System.out.print(array[array.length-start-1][i]+" ");
			}
		}
		if(array.length-1-start>start && array[0].length-1-start>start)
		{
			for(int i=array.length-start-1;i>start;i--){
				System.out.print(array[i][start]+" ");
			}
		}
	}
}
