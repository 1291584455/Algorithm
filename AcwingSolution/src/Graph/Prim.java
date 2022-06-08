package Graph;

import java.util.*;

/**
 * prim 算法 求最小生成树 ， 从一个点出发， 更新其他点到集合的距离， 找到最小距离的点 然后继续更新
 *
 */
public class Prim{
    static int N = 510;
    static int[][] g = new int[N][N];
    static int INF = (int) 5e7;
    static int n , m;
    static boolean[] st = new boolean[N];
    static int[] d = new int[N];

    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        Arrays.fill(d, INF);
        for(int i = 0; i < N; i++){
            Arrays.fill(g[i], INF);
        }
        n = scn.nextInt();
        m = scn.nextInt();
        while(m-- > 0){
            int a = scn.nextInt();
            int b = scn.nextInt();
            int c = scn.nextInt();
            g[a][b] = Math.min(Math.min(g[a][b], g[b][a]), c);
            g[b][a] = g[a][b];
        }
        int ans = prim();
        if(ans >= INF / 2) System.out.println("impossible");
        else System.out.println(ans);

    }

    private static int prim(){
        int ans = 0;
        d[1] = 0;
        for(int i = 0; i < n; i++){
            int t = -1;
            for(int j = 1; j <= n; j ++){
                if(!st[j] && (t == -1 || d[t] > d[j])){
                    t = j;
                }
            }
            st[t] = true;
            ans += d[t];
            for(int j = 1; j <= n ; j++){
                d[j] = Math.min(d[j], g[t][j]);
            }
        }
        return ans;
    }

}