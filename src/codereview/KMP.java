package codereview;

/**
 * @author: guangxush
 * @create: 2019/03/18
 */
public class KMP {
    public static int[] getNext(String ps){
        char[] strKey = ps.toCharArray();
        int[] next = new int[strKey.length];

        //初始条件
        int j = 0;
        int k = -1;
        next[0] = -1;

        //根据已知的前j位推测j+1位
        while(j<strKey.length-1){
            if(k==-1||strKey[j]==strKey[k]){
                // 如果str[j + 1] == str[k + 1]，回退后仍然失配，所以要继续回退
                if(strKey[j+1]==strKey[k+1]){
                    next[++j] = next[++k];
                }else{
                    next[++j] = ++k;
                }
            }else{
                k = next[k];
            }
        }
        return next;
    }
}
