package codingInterviews;
/**
 * 输入一个整数n，求从1到n这n个整数的十进制表示中1出现的次数。
 * 例如输入12，这些整数中包含1的数字有1,10,11,12，1一共出现了5次。
 */
public class CountOne {
	public int countOne(int n){
		if(n<1)
	        return 0;
	    int count = 0;
	    int base = 1;
	    int round = n;
	    while(round>0){
	        int weight = round%10;
	        round/=10;
	        count += round*base;
	        if(weight==1)
	            count+=(n%base)+1;
	        else if(weight>1)
	            count+=base;
	        base*=10;
	    }
	    return count;
	}
	public static void main(String[] args) {
		CountOne p=new CountOne();
		System.out.println(p.countOne(123));
	}
}
/**
 * 若个位大于0，1出现的次数为round*1+1
 * 若个位等于0，1出现的次数为round*1
 * 若weight为0，则1出现次数为round*base
 * 若weight为1，则1出现次数为round*base+former+1
 * 若weight大于1，则1出现次数为rount*base+base
 */
