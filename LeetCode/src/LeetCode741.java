public class LeetCode741 {
    /**
     * f[k][i][j] 表示两次同时摘樱桃，走到 i k -i 和 j k - j 时， 能摘到的最大的樱桃的数量;
     * [i, k - i] [j , k - j] 可以分别是 下下 下右 右下 右右 转移过来，
     */
    int INF = (int)1e9;
    public int cherryPickup(int[][] w) {
        int m = w.length;
        int n = w[0].length;
        int[][][] f = new int[m + n + 1][m + 1][m + 1];
        for(int i = 0; i <= m + n; i++){
            for(int j = 0; j <= m; j++){
                for(int k = 0; k <= m; k++){
                    f[i][j][k] = -INF;
                }
            }
        }
        f[2][1][1] = w[0][0];
        for(int i = 2; i <= m + n; i++){
            for(int j = 1; j <= m; j++){
                for(int k = 1; k <= m; k++){
                    int y1 = i - j ,y2 = i - k;
                    if(y1 >= 1 && y2 >= 1 && y1 <= m && y2 <= m && (w[j - 1][y1 - 1] != -1 && w[k -1][y2 - 1] != -1)){
                        int t = w[j - 1][y1 - 1];
                        if(k != j || y1 != y2) t += w[k - 1][y2 - 1];
                        f[i][j][k] = Math.max(f[i][j][k], f[i - 1][j][k] + t);
                        f[i][j][k] = Math.max(f[i][j][k], f[i - 1][j - 1][k] + t);
                        f[i][j][k] = Math.max(f[i][j][k], f[i - 1][j][k - 1] + t);
                        f[i][j][k] = Math.max(f[i][j][k], f[i - 1][j - 1][k - 1] + t);
                    }
                }
            }
        }
        return f[m + n][m][m] >= 0 ? f[m + n][m][n] : 0;
    }
}
