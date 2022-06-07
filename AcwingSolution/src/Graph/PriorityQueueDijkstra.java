package Graph;

/*
堆优化版的dijkstra算法 适用于 稀疏图 算法复杂度 o(m log m)
 */

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class PriorityQueueDijkstra {
    static int N = 150010;
    static int[] h = new int[N];
    static int[] e = new int[N];
    static int[] ne = new int[N];
    static int[] w = new int[N];
    static int[] d = new int[N];
    static boolean[] st = new boolean[N];
    static int INF = (int) 1e9;
    static int n, m, idx;


    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        n = scn.nextInt();
        m = scn.nextInt();
        //初始化
        Arrays.fill(h, -1);
        Arrays.fill(w, INF);
        Arrays.fill(d, INF);
        for(int i = 0; i < m; i++){
            int a = scn.nextInt();
            int b = scn.nextInt();
            int c = scn.nextInt();
            add(a, b, c);
        }
        System.out.println(solution());
    }

    private static int solution() {
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[0] - o2[0]);
        d[1] = 0;
        pq.add(new int[]{0, 1});
        while(!pq.isEmpty()){
            int[] p = pq.poll();
            st[p[1]] = true;
            for(int i = h[p[1]]; i >= 0; i = ne[i]) {
                int u = e[i];
                if(d[u] > d[p[1]] + w[i]){
                    d[u] = d[p[1]] + w[i];
                    if(!st[u]) pq.add(new int[]{d[u], u});
                }
            }
        }
        return d[n] == INF ? -1 : d[n];
    }

    private static void add(int a, int b, int c) {
        e[idx] = b;
        w[idx] = c;
        ne[idx] = h[a];
        h[a] = idx++;
    }

}
