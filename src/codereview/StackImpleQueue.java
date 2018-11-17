package codereview;

import java.util.Stack;

/**
 * Created by gshan on 2018/11/17
 */
public class StackImpleQueue {
    public Stack<Integer> stack1 = new Stack<>();
    public Stack<Integer> stack2 = new Stack<>();

    public void offer(int i){
        stack1.push(i);
    }

    public int poll(){
        if(!stack2.isEmpty()){
            return stack2.pop();
        }else{
            while(!stack1.isEmpty()){
                stack2.push(stack1.pop());
            }
        }
        if(!stack2.isEmpty()){
            return stack2.pop();
        }else{
            throw new IllegalArgumentException("the queue is empty!");
        }
    }

    public int getLength(){
        return stack1.size()+stack2.size();
    }

    public static void main(String[] args){
        StackImpleQueue queue = new StackImpleQueue();
        queue.offer(1);
        queue.offer(4);
        queue.offer(2);
        queue.offer(3);
        queue.offer(5);
        System.out.println("length:"+queue.getLength());
        System.out.println(queue.poll());
        System.out.println("length:"+queue.getLength());
        queue.offer(6);
        System.out.println(queue.poll());
        System.out.println("length:"+queue.getLength());
    }
}
