package Graph;
/**
 * 朴素版dijkstra算法 适合稠密图 复杂度 o(n^2)
 */

import java.util.*;

public class dijkstra {
    static int N = 510;
    static int[][] g = new int[N][N];
    static boolean[] st = new boolean[N];
    static int[] d = new int[N];
    static int n, m;
    static int INF = (int) 1e7;

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        n = scn.nextInt();
        m = scn.nextInt();
        // 初始化所有点到1号点的距离为 INF;
        Arrays.fill(d, INF);
        // 初始化所有两个点的距离为 INF;
        for(int i = 0; i < n; i++){
            Arrays.fill(g[i], INF);
        }
        while (m-- > 0){
            int a = scn.nextInt();
            int b = scn.nextInt();
            int c = scn.nextInt();
            g[a][b] = Math.min(g[a][b], c);
        }

        System.out.println(solution());

    }

    /**
     * dijkstra算法
     * @return  表示从 1 号点到 n 号点的距离
     */
    private static int solution() {
        //初始化 d[1] = 0;
        d[1]  = 0;
        for(int i = 0; i < n; i++){
            int t = -1;
            for(int j = 1; j <= n ; j ++){
                if(!st[j] && (t == -1 || d[t] > d[j])){
                    t = j;
                }
            }
            st[t] = true;
            for(int j = 1; j <= n; j++){
                d[j] = Math.min(d[j], d[t] + g[t][j]);
            }
        }
        return d[n] == INF ? -1 : d[n];
    }
}


