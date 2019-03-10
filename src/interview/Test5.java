package interview;

import java.util.Scanner;

/**
 * @Description
 * @auther guangxush
 * @create 2019/3/10
 */
public class Test5 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {//注意while处理多个case
            String a = in.nextLine();
            String b = in.nextLine();
            long sum = 0;
            String temp = a;
            for(int i=0;i<b.length()-1;i++){
                sum+=length(temp,temp.charAt(i));
                int index = temp.indexOf(b.charAt(i));
                if(index!=-1){
                    temp = temp.substring(0,index)+b.charAt(i)+temp.substring(index,temp.length()-1);
                }
            }
            sum+=addString(b, b.charAt(b.indexOf(b.length()-1)==-1?0:b.indexOf(b.length()-1)));
            System.out.println((int)sum%(Math.pow(10,9)+7));
        }
    }
    private static int addString(String s, char c){
        if('('==c){
            return s.length()- s.lastIndexOf(c)+1;
        }else{
            return s.length()-s.indexOf('(')+1;
        }
    }
    private static int length(String s, char c){
        if(s.indexOf(c)!=-1){
            return s.length()+1;
        }else{
            return s.length();
        }
    }
}
