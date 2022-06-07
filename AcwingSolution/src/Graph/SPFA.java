package Graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;


/*
    spfa 算法求含有负权的最短路问题， 平均复杂度为 o(m) , 最坏的复杂度达到 o(mn)
 */

public class SPFA {

    static int N = 100010;
    static int[] d = new int[N];
    static int INF = (int) 1e9;
    static int n, m, idx;
    static int[] h = new int[N], e = new int[N], ne = new int[N], w = new int[N];
    static boolean[] st = new boolean[N];



    public static void main(String[] args) {
        // 初始化
        Arrays.fill(h, -1);
        Arrays.fill(d, INF);
        Arrays.fill(w, INF);
        Scanner scn = new Scanner(System.in);
        n = scn.nextInt();
        m = scn.nextInt();
        while(m-- > 0){
            int a = scn.nextInt();
            int b = scn.nextInt();
            int c = scn.nextInt();
            add(a, b, c);
        }
        int ans = spfa();
        System.out.println(ans == INF ? "impossible" : ans);

    }

    /**
     * spfa 算法
     * @return d[n]
     */

    private static int spfa() {
        d[1] = 0;
        LinkedList<Integer> list = new LinkedList<>();
        list.add(1);
        while(!list.isEmpty()) {
            int p = list.pop();
            st[p] = false;
            for (int i = h[p]; i >= 0; i = ne[i]) {
                int t = e[i], weight = w[i];
                if (d[t] > d[p] + weight) {
                    d[t] = d[p] + weight;
                    if (!st[t]) {
                        list.add(t);
                        st[t] = true;
                    }
                }
            }
        }
        return d[n];


    }

    private static void add(int a, int b, int c) {
        e[idx] = b;
        w[idx] = c;
        ne[idx] = h[a];
        h[a] = idx++;
    }
}
