package chapterThree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 二叉树的序列化和反序列化
 * 序列化：二叉树被记录成文件的过程
 * 反序列化：通过文件内容重建二叉树
 */
public class SerialBinaryTree {
    //先序遍历实现序列化
    public String sericalByPre(Node head){
        if(head==null) return "#!";
        String res = head.value+"!";
        res+=sericalByPre(head.left);
        res+=sericalByPre(head.right);
        return res;
    }
    //先序遍历反序列化
    public Node reconByPreString(String preStr){
        String[] value = preStr.split("!");
        Queue<String> queue = new LinkedList<>();
        for(int i=0;i!=value.length;i++){
            queue.offer(value[i]);
        }
        return reconPreOrder(queue);
    }
    public Node reconPreOrder(Queue<String> queue){
        String value = queue.poll();
        if(value.equals("#")){
            return null;
        }
        Node head = new Node(Integer.valueOf(value));
        head.left = reconPreOrder(queue);
        head.right = reconPreOrder(queue);
        return head;
    }
    //通过层次遍历实现序列化
    public String serialByLevel(Node head){
        if(head==null) return "#!";
        String res = head.value+"!";
        Queue<Node> queue = new LinkedList<>();
        queue.offer(head);
        while(!queue.isEmpty()){
            head = queue.poll();
            if(head.left!=null){
                res+=head.left.value+"!";
                queue.offer(head.left);
            }else{
                res+="#!";
            }
            if(head.right!=null){
                res+=head.right.value+"!";
                queue.offer(head.right);
            }else{
                res+="#!";
            }
        }
        return res;
    }
    //层次遍历实现二叉树的反序列化
    public Node reconByLevelString(String levelStr){
        String[] values = levelStr.split("!");
        int index = 0;
        Node head = generateNodeByString(values[index++]);
        Queue<Node> queue = new LinkedList<>();
        if(head!=null) queue.offer(head);
        Node node = null;
        while(!queue.isEmpty()){
            node = queue.poll();
            node.left = generateNodeByString(values[index++]);
            node.right = generateNodeByString(values[index++]);
            if(node.left!=null){
                queue.offer(node.left);
            }
            if(node.right!=null){
                queue.offer(node.right);
            }
        }
        return head;
    }
    public Node generateNodeByString(String val){
        if(val.equals("#")){
            return null;
        }
        return new Node(Integer.valueOf(val));
    }
}
