package codereview;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by gshan on 2018/11/17
 */
public class QueueImplStack {
    Queue<Integer> queue1 = new LinkedList();
    Queue<Integer> queue2 = new LinkedList();

    public void push(int e){
        queue1.offer(e);
    }

    public int pop(){
        if(!queue2.isEmpty()){
            return queue2.poll();
        }else{
            while(!queue1.isEmpty()){
                queue2.offer(queue1.poll());
            }
        }
        if(!queue2.isEmpty()){
            return queue2.poll();
        }else{
            throw new IllegalArgumentException("The elements don't exist");
        }
    }

    public int getLength(){
        return queue1.size()+queue2.size();
    }

    public static void main(String[] args){
        QueueImplStack stack = new QueueImplStack();
        stack.push(1);
        stack.push(3);
        stack.push(2);
        stack.push(4);
        stack.push(5);
        stack.push(6);
        System.out.println(stack.getLength());
        System.out.println(stack.pop());
        System.out.println(stack.getLength());
        stack.push(6);
        System.out.println(stack.pop());
        System.out.println(stack.getLength());
    }
}
