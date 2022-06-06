public class Problem329 {

    public int longestIncreasingPath(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int[][] dp = new int[m][n];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                dp[i][j] = -1;
            }
        }
        int ans = 0;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                ans = Math.max(ans, dfs(matrix, i, j, -1, 0,dp));
            }
        }

        return ans;
    }

    public int dfs(int[][] matrix, int i, int j, int pre, int count, int[][] dp){
        if(i < 0 || i >= matrix.length || j < 0 || j >= matrix[0].length || matrix[i][j] <= pre){
            return 0;
        }
        if(dp[i][j] != -1){
            return dp[i][j];
        }
        int max = 0;
        max = Math.max(dfs(matrix, i + 1, j, matrix[i][j], count + 1,dp),max);
        max = Math.max(dfs(matrix, i - 1, j, matrix[i][j], count + 1,dp),max);
        max = Math.max(dfs(matrix, i, j - 1, matrix[i][j], count + 1,dp),max);
        max = Math.max(dfs(matrix, i, j + 1, matrix[i][j], count + 1,dp),max);

        dp[i][j] = max  + 1;
        return max  + 1;

    }
}
