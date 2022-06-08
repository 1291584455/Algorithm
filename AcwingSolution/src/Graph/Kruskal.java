package Graph;

import java.util.*;
public class Kruskal{
    static int N = 100010;
    static int m, n;
    static Edge[] edges;
    static int[] p = new int[N];

    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        n = scn.nextInt();
        m = scn.nextInt();
        for(int i = 0; i < N; i++){
            p[i] = i;
        }
        edges =  new Edge[m];
        for(int i = 0; i < m; i++){
            int a = scn.nextInt();
            int b = scn.nextInt();
            int c = scn.nextInt();
            edges[i] = new Edge(a, b, c);
        }
        Arrays.sort(edges,(o1, o2) -> o1.weight - o2.weight);
        int ans = kruskal();
        if(ans == Integer.MAX_VALUE) System.out.println("impossible");
        else System.out.println(ans);
    }

    private static int find(int x){
        if(p[x] != x) p[x] = find(p[x]);
        return p[x];
    }

    private static int kruskal() {
        int ans = 0;
        int cnt = 0;
        for(int i = 0; i < m; i++){
            int a = edges[i].from;
            int b = edges[i].to;
            int c = edges[i].weight;
            if(find(a) != find(b)){
                ans += c;
                p[b] = find(a);
                cnt++;
            }
        }
        return cnt == n - 1 ? ans : Integer.MAX_VALUE;
    }


}
