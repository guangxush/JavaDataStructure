package codingInterviews;

public class TheIntegerPower {
	public double Power(double base, int exponent)throws Exception{
		double result = 0.0;
		if(equal(base,0.0)&&exponent<0) {
			throw new Exception("0的负数次方没有意义");
		}
		if(exponent<0) {
			result = 1.0/powerWithExpoment(base,-exponent);
		}else{
			result = powerWithExpoment(base,exponent);
		}
		return result;
	}
	/**
	 * 计算整数的n次方
	 * @param base
	 * @param exponent
	 * @return
	 */
	public double powerWithExpoment(double base,int exponent) {
		if(exponent==0) return 1;
		if(exponent==1) return base;
		double result = 1.0;
		for(int i=1;i<=exponent;i++) {
			result = result*base;
		}
		return result;
	}
	/**
	 * float和double在用==判断时会有误差，所以要重新定义==为equal
	 * @param num1
	 * @param num2
	 * @return
	 */
	private boolean equal(double num1, double num2) {
		if((num1-num2>-0.0000001)&&num1-num2<0.0000001) {
			return true;
		}else {
			return false;
		}
	}
	/**
	 * 一种更简单的方法，模仿斐波那契额数列
	 * @param base
	 * @param exponent
	 * @return
	 * @throws Exception
	 */
	public double PowerAmazing(double base, int exponent)throws Exception{
		if(exponent==0) return 1;
		if(exponent==1) return base;
		double result = PowerAmazing(base, exponent>>1);
		result *= result;
		if((exponent & 0x1)==1)
			result *= base;
		return result;
	}
	public static void main(String[] args)throws Exception {
		TheIntegerPower test = new TheIntegerPower();
		System.out.println(test.Power(2.0, 3));
		System.out.println(test.PowerAmazing(2.0, 3));
	}
}
