package codingInterviews;

import java.util.Arrays;

/**
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。是则返回true，否则返回false。
 */
public class VerfiySequenceOfBST {
	public boolean verfiySequenceOfBST(int[] sequence){
		if(sequence==null||sequence.length==0) return false;
		int length = sequence.length;
		int root = sequence[length-1];//找到根节点
		int i = 0;
		//在二叉搜索树中左子树的节点小于根节点
		for(;i<length-1;i++) {
			if(sequence[i]>root) {
				break;
			}
		}
		//在二叉树的右子树中节点大于根节点
		int j = i;
		for(;j<length-1;j++) {
			if(sequence[j]<root) {
				break;
			}
		}
		//判断左子树是不是二叉搜索树
		boolean left = true;
		if(i>0)
			left = verfiySequenceOfBST(Arrays.copyOfRange(sequence, 0, i));
		//判断右子树是不是二叉搜索树
		boolean right = true;
		if(j<length-1)
			right= verfiySequenceOfBST(Arrays.copyOfRange(sequence,i+1,length-j-1)); 
		return (right&&left);
	}
	public static void main(String[] args) {
		int[] array={5,7,6,9,11,10,8};
		//int[] array={7,4,6,5};
		//int[] array={6,7,8,5};
		VerfiySequenceOfBST res=new VerfiySequenceOfBST();
		System.out.println(res.verfiySequenceOfBST(array));
	}
}
/**
 * 后序遍历最后一个数字是树的根节点的值，数组中的前面 的数字可以分为两个部分，第一部分是做子树节点的值
 * 他们都比根节点的值小，第二部分是右子树节点的值，他们都比根节点的值大。
 * 8是根节点，前三个5，7，6都比8小，是8的左子树节点
 * 后三个数字9，11，10都比8大，是值位8的节点的右子树节点
 * 同时递归的遍历左边5 7 6 右边9 11 10如果他们是二叉搜索树后序遍历那么就是。*/
