package interview.huawei;

import java.util.Scanner;

/**
 * @author: guangxush
 * @create: 2019/04/10
 */
public class Test3 {
    private static int count = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int a[][] = new int[n][m];
        boolean b[][] = new boolean[n][m];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                a[i][j] = sc.nextInt();
            }
        }
        int x = sc.nextInt();
        int y = sc.nextInt();
        b[x][y] = true;
        int z = sc.nextInt();
        int w = sc.nextInt();
        b[z][w] = true;
        isOK(a, b, x, y, z, w);
        System.out.println(count);
    }
    private static void isOK(int a[][], boolean b[][], int x, int y, int z, int w){
        if(x==z&&y==w){
            count = (++count)%(int)10e9;
            return;
        }
        if(x>0&&b[x-1][y]&&a[x-1][y]>a[x][y]){
            b[x-1][y] = true;
            isOK(a, b, x-1, y, z, w);
            b[x-1][y] = false;
        }
        if(y>0&&b[x][y-1]&&a[x][y-1]>a[x][y]){
            b[x][y-1] = true;
            isOK(a, b, x, y-1, z, w);
            b[x][y-1] = false;
        }
        if(x<a.length-1&&b[x+1][y]&&a[x+1][y]>a[x][y]){
            b[x+1][y] = true;
            isOK(a, b, x+1, y, z, w);
            b[x+1][y] = false;
        }
        if(y<a[0].length-1&&b[x][y+1]&&a[x][y+1]>a[x][y]){
            b[x][y+1] = true;
            isOK(a, b, x, y+1, z, w);
            b[x][y+1] = false;
        }
        return;
    }
}
