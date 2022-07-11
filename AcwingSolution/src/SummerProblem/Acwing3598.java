package SummerProblem;

import java.time.chrono.MinguoDate;
import java.util.Scanner;

public class Acwing3598 {
    static int N = 30;
    static int index;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            char[] pre = sc.next().toCharArray();
            char[] or = sc.next().toCharArray();
            int l = 0, r = pre.length - 1;
            int[] map = new int[N];
            for(int i = 0;i <= r; i++){
                map[or[i] - 'A'] = i;
            }
            index = 0;
            dfs(pre, or, l, r, map);
            System.out.println();
        }
    }

    private static void dfs(char[] pre, char[] or, int l, int r, int[] map) {
        if(l > r){
            return;
        }
        int idx = map[pre[index++]];
        dfs(pre, or, l , idx - 1, map);
        dfs(pre, or, idx + 1, r, map);
        System.out.print(or[idx]);
    }


}
