package Graph;

/*
BellmanFord 算法用于含有负权的最短路问题, 时间复杂度为 o(nm), 通常适用于有边数限制的最短路问题
 */

import java.util.Arrays;
import java.util.Scanner;

public class BellmanFord {

    static int n,m,k;
    static int N = 510;
    static int M = 10010;
    static Edge[] edges = new Edge[M];
    static int[] d = new int[N];
    static int INF = (int) 1e9;

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        n = scn.nextInt();
        m = scn.nextInt();
        k = scn.nextInt();
        Arrays.fill(d, INF);
        for(int i = 0; i < m; i++){
            int a = scn.nextInt();
            int b = scn.nextInt();
            int c = scn.nextInt();
            edges[i] = new Edge(a, b, c);
        }

        System.out.println(bellmanFord());
    }


    /**
     * bellman_ford 算法 外层循环 0 - k 表示从经过 k 条边的 最短路
     * @return d[n] >= INF / 2 表示不存在 最短路
     */
    private static int bellmanFord() {
        d[1] = 0;
        for(int i = 0; i < k; i++){
            int[] cl = d.clone();
            for(int j = 0; j < m; j++){
                int f = edges[j].from, t = edges[j].to, w = edges[j].weight;
                d[t] = Math.min(d[t], cl[f] + w);
            }
        }

        return d[n];
    }
}

class Edge{
    int from;
    int to;
    int weight;

    public Edge(int from, int to, int weight) {
        this.from = from;
        this.to = to;
        this.weight = weight;
    }
}
