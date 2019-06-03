package interview.toutiao;

import java.util.Scanner;

/**
 * @author: guangxush
 * @create: 2019/03/16
 */
public class Test2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int j = 0; j < n; j++){
            String str = sc.next();
            int count1 = 0;
            boolean flag = false;
            for(int i=0;i<str.length()-1;i++){
                if(str.indexOf(i)==str.indexOf(i+1)){
                    count1++;
                }else{
                    count1=0;
                }
                while(count1>=3){
                    str=str.substring(0,i)+str.substring(i+1,str.length());
                    count1--;
                    i--;
                }
                if(count1==2&&flag==false){
                    flag=true;
                    count1=0;
                }else if(count1==2&&flag==true){
                    str=str.substring(0,i)+str.substring(i+1,str.length());
                    i--;
                    flag=false;
                }
            }
            System.out.println(str);
        }
    }
}
