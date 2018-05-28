package chapterOne;

import java.util.Stack;

public class HanoiProblem {
	//递归求解汉诺塔问题
	public int hanoiProblem1(int num,String left,String mid,String right) {
		if(num<1) return 0;
		return process(num,left,mid,right,left,right);
	}
	public int process(int num,String left,String mid,String right,String from,String to) {
		if(num==1) {//只剩下一个塔的移动方式
			if(from.equals(mid)||to.equals(mid)) {
				System.out.println("Move 1 from "+ from +"to "+to);
				return 1;
			}else {
				System.out.println("Move 1 from "+ from +"to "+mid);
				System.out.println("Move 1 from "+ mid +"to "+to);
				return 2;
			}
		}
		if(from.equals(mid)||to.equals(mid)){//剩下的n个塔都在左，全部移动到中的过程
			String another = (from.equals(left)||to.equals(left))?right:left;
			//将1~n-1层塔从左移到右
			int part1 = process(num-1,left,mid,right,from,another);
			int part2 = 1;
			//将第n层塔从左移动到中
			System.out.println("Move "+num+"from"+ from +"to "+to);
			//再将n层塔从右移动到中
			int part3 = process(num-1,left,mid,right,another,to);
			return part1+part2+part3;
		}else {//剩下的n个塔都在左，全部移动到右的过程
			//将1~n-1层塔从左移到右
			int part1 = process(num-1,left,mid,right,from,to);
			int part2 = 1;
			//将第n层塔从左移动到中
			System.out.println("Move "+num+"from"+ from +"to "+mid);
			//将1~n-1层塔从右移到左
			int part3 = process(num-1,left,mid,right,to,from);
			int part4 = 1;
			//将第n层塔从中移动到右
			System.out.println("Move "+num+"from"+ mid +"to "+to);
			//将1~n-1层塔从左移到右
			int part5 = process(num-1,left,mid,right,from,to);
			return part1+part2+part3+part4+part5;
		}
	}
	public enum Action{
		No, LToM, MToL, MToR, RToM
	}
	//使用栈的方式进行存储
	public int hanoiProblem2(int num,String left,String mid,String right) {
		Stack<Integer> lS = new Stack<Integer>();
		Stack<Integer> mS = new Stack<Integer>();
		Stack<Integer> rS = new Stack<Integer>();
		lS.push(Integer.MAX_VALUE);
		mS.push(Integer.MAX_VALUE);
		rS.push(Integer.MAX_VALUE);
		for(int i=num;i>0;i--) {
			lS.push(i);
		}
		Action[] record = {Action.No};
		int step = 0;
		while(rS.size()!=num+1) {
			step+=fStackToStack(record,Action.MToL,Action.LToM,lS,mS,left,mid);
			step+=fStackToStack(record,Action.LToM,Action.MToL,mS,lS,mid,left);
			step+=fStackToStack(record,Action.RToM,Action.MToL,mS,rS,mid,right);
			step+=fStackToStack(record,Action.MToL,Action.RToM,rS,mS,right,mid);
		}
		return step;
	}
	public static int fStackToStack(Action[] record, Action preNoAct,Action nowAct,Stack<Integer> fStack
			,Stack<Integer> tStack, String from,String to) {
		if(record[0]!=preNoAct&&fStack.peek()<tStack.peek()) {
			tStack.push(fStack.pop());
			System.out.println("Move "+tStack.peek()+" from "+from+" to "+to);
			record[0] = nowAct;
			return 1;
		}
		return 0;
	}
}
