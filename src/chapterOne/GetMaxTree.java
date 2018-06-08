package chapterOne;

import java.util.HashMap;
import java.util.Stack;

/**
 * 满足如下定义：
 * 1.数组没有重复元素
 * 2.MaxTree是一颗二叉树，数组中的每一个值对应二叉树的一个节点
 * 3.包括MaxTree树在内在其中的每一个子树上，值最大的节点就是树的根节点
 * 建树原则：
 * 1.每一个数的父节点是他左边第一个比他大的数和右边比他大的数里面较小的那个
 * 2.如果一个数左右都没有比他大的数，那么他就是这个MaxTree的根节点
 *
 */
public class GetMaxTree {
    public Node getMaxTree(int[] arr){
        Node[] nArr = new Node[arr.length];
        for(int i=0;i!=arr.length;i++){
            nArr[i] = new Node(arr[i]);
        }
        Stack<Node> stack = new Stack<>();
        HashMap<Node,Node> lBigMap = new HashMap<>();
        HashMap<Node,Node> rBigMap = new HashMap<>();
        for(int i=0;i!=nArr.length;i++){
            Node curNode = nArr[i];
            while(!stack.isEmpty()&&stack.peek().value<curNode.value){
                popStackSetMap(stack,lBigMap);
            }
            stack.push(curNode);
        }
        while (!stack.isEmpty()){
            popStackSetMap(stack,lBigMap);
        }
        for(int i=nArr.length-;i!=-1;i--){
            Node curNode = nArr[i];
            while(!stack.isEmpty()&&stack.peek().value<curNode.value){
                popStackSetMap(stack,rBigMap);
            }
            stack.push(curNode);
        }
        while (!stack.isEmpty()){
            popStackSetMap(stack,lBigMap);
        }
        Node head = null;
        for(int i=0;i!=nArr.length;i++){
            Node curNode = nArr[i];
            Node left = lBigMap.get(curNode);
            Node right = rBigMap.get(curNode);
            if(left==null&&right==null){
                head  = curNode;
            }else if(left==null){
                if(right.left==null){
                    right.left=curNode;
                }else{
                    right.right=curNode;
                }
            }else if(right==null){
                if(left.left==null){
                    left.left=curNode;
                }else{
                    left.right=curNode;
                }
            }else{
                Node parent = left.value<right.value?:left:right;
                if(parent.left==null){
                    parent.left=curNode;
                }else{
                    parent.right=curNode;
                }
            }
        }
        return head;
    }
    public void popStackSetMap(Stack<Node> stack,HashMap<Node,Node> map){
        Node popNode = stack.pop();
        if(stack.isEmpty()){
            map.put(popNode,null);
        }else{
            map.put(popNode,stack.peek());
        }
    }
}
