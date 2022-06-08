package Graph;

import java.util.*;

/*
    SPFA 判断是否含有负环， cnt[]  数组用于记录最短路的边数， 若存在 cnt >= n + 1 表示有两个点重合 说明含有负环
 */
public class SPFA01 {
    static int N = 2010;
    static int M = 10010;
    static int m , n, idx;
    static int INF = (int) 1e9;
    static int[] d = new int[N], h = new int[N], e = new int[M], ne = new int[M], w = new int[M];
    static int[] cnt = new int[N]; // 用于记录最短路的边数
    static boolean[] st = new boolean[N];

    static void add(int a, int b, int c){
        e[idx] = b;
        w[idx] = c;
        ne[idx] = h[a];
        h[a] = idx++;
    }

    public static void main(String[] args){

        Arrays.fill(d, INF);
        Arrays.fill(w, INF);
        Arrays.fill(h, -1);

        Scanner scn = new Scanner(System.in);
        n = scn.nextInt();
        m = scn.nextInt();
        while(m-- > 0){
            int a = scn.nextInt();
            int b = scn.nextInt();
            int c = scn.nextInt();
            add(a, b, c);
        }

        System.out.println(spfa() ? "Yes" : "No");

    }

    private static boolean spfa(){

        //这里需要对每个点都判断一遍，因为负环可能不和 1 号点连通;
        for(int i = 1; i <= n ; i++){
            d[i] = 0;
            cnt[i] = 1;
            LinkedList<Integer> list = new LinkedList<>();
            list.add(i);
            while(!list.isEmpty()){
                int p = list.pop();
                st[p] = false;
                for(int j = h[p]; j >= 0; j = ne[j]){
                    int t = e[j];
                    if(d[t] > d[p] + w[j]){
                        cnt[t] = cnt[p] + 1;
                        d[t] = d[p] + w[j];
                        if(cnt[t] >= n + 1) return true;
                        if(!st[t]){
                            st[t] = true;
                            list.add(t);
                        }
                    }
                }
            }
        }

        return false;

    }

}