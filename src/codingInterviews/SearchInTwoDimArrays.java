package codingInterviews;
/**
 * 题目描述：一个二维数组，每一行从左到右递增，每一列从上到下递增．输入一个二维数组和一个整数，判断数组中是否含有整数。
 */
public class SearchInTwoDimArrays {
	public static boolean find(int[][] array,int number){
		if(array==null) return false;
		int column = array[0].length-1;
		int row = 0;
		while(row<array.length&&column>=0) {
			if(array[row][column]==number)
				return true;
			if(array[row][column]>number) {
				column--;
			}else {
				row++;
			}
		}
		return false;
	}
	public static void main(String[] args) {
		int[][] testarray=new int[4][4];
		testarray[0][0]=1;
		testarray[0][1]=2;
		testarray[0][2]=8;
		testarray[0][3]=9;
		testarray[1][0]=2;
		testarray[1][1]=4;
		testarray[1][2]=9;
		testarray[1][3]=12;
		testarray[2][0]=4;
		testarray[2][1]=7;
		testarray[2][2]=10;
		testarray[2][3]=13;
		testarray[3][0]=6;
		testarray[3][1]=8;
		testarray[3][2]=11;
		testarray[3][3]=15;
		System.out.println(find(testarray, 11));
	}
}
/**
 *分析：逐渐缩小查找范围
 *1.首先选取数组右上角的数字，如果该数字为要查找的数字，则查找过程结束；
 *  如果该数字要大于要查找的数字，则剔除该数字所在的列；
 *  如果该数字小于要查找的数字，提出该数字所在的行。
 *2.每一次跟剔除之后的数组的右上角的元素比较，缩小查找范围，直到查找范围为空说明没有找到。
 */
