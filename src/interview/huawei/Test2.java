package interview.huawei;

import java.util.Scanner;
import java.util.Stack;

/**
 * @author: guangxush
 * @create: 2019/04/10
 */
public class Test2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
           String str = in.next();
           StringBuilder sb = new StringBuilder();
           char[] cArr = str.toCharArray();
           Stack<Character> stack = new Stack<>();
           Stack<Integer> stack1 =new Stack<>();
           int i = 0;
           while(i<cArr.length){
               if(('a'<=cArr[i]&&cArr[i]<='z')||('A'<=cArr[i]&&cArr[i]<='Z')){
                   stack.push(Character.valueOf(cArr[i]));
                   i++;
               }else if('0'<cArr[i]&& cArr[i]<='9'){
                   int number = cArr[i]-'0';
                   //找到所有的数字
                   i++;
                   while('0'<=cArr[i]&& cArr[i]<='9'){
                       number = number*10+(cArr[i]-'0');
                       i++;
                   }
                   stack1.push(number);
               }else if(cArr[i]=='('){
                   stack.push('(');
                   i++;
               }else if(cArr[i]=='['){
                   stack.push('[');
                   i++;
               }else if(cArr[i]=='{'){
                   stack.push('{');
                   i++;
               }else if(cArr[i]==')'){
                   StringBuilder sb1 = new StringBuilder();
                   while(stack.peek()!='('){
                       sb1.append(stack.pop());
                   }
                   stack.pop();
                   sb1.reverse();
                   int num = stack1.pop();
                   StringBuilder sb2 = new StringBuilder();
                   while(num!=0){
                       sb2.append(sb1);
                       num--;
                   }
                   char[] c_temp = sb2.toString().toCharArray();
                   for(int j=0;j<c_temp.length;j++){
                       stack.push(c_temp[j]);
                   }
                   i++;
               }else if(cArr[i]==']'){
                   StringBuilder sb1 = new StringBuilder();
                   while(stack.peek()!='['){
                       sb1.append(stack.pop());
                   }
                   stack.pop();
                   sb1.reverse();
                   int num = stack1.pop();
                   StringBuilder sb2 = new StringBuilder();
                   while(num!=0){
                       sb2.append(sb1);
                       num--;
                   }
                   char[] c_temp = sb2.toString().toCharArray();
                   for(int j=0;j<c_temp.length;j++){
                       stack.push(c_temp[j]);
                   }                   i++;
               }else if(cArr[i]=='}'){
                   StringBuilder sb1 = new StringBuilder();
                   while(stack.peek()!='{'){
                       sb1.append(stack.pop());
                   }
                   stack.pop();
                   sb1.reverse();
                   int num = stack1.pop();
                   StringBuilder sb2 = new StringBuilder();
                   while(num!=0){
                       sb2.append(sb1);
                       num--;
                   }
                   char[] c_temp = sb2.toString().toCharArray();
                   for(int j=0;j<c_temp.length;j++){
                       stack.push(c_temp[j]);
                   }                   i++;
               }
           }
           while(!stack.isEmpty()){
               sb.append(stack.pop());
           }
           System.out.println(sb);
        }
    }
}
