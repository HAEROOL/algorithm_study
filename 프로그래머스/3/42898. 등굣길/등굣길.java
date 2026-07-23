import java.util.*;

class Solution {
    public int solution(int m, int n, int[][] puddles) {
        int answer = 0;
        int[][] dp = new int[n][m];
        for(int i = 0 ; i < n ; i++) dp[i][0] = 1;
        for(int j = 0 ; j < m ; j++) dp[0][j] = 1;
        for(int[] p : puddles){
            int y = p[0] - 1;
            int x = p[1] - 1;
            dp[x][y] = -1;
            if(y == 0){
                for(int i = x ; i < n ; i++)dp[i][0] = -1;
            }else if(x == 0){
                for(int i = y ; i < m ; i++)dp[0][i] = -1;
            }
        }
        
        for(int i = 1 ; i < n ; i++){
            for(int j = 1 ; j < m ; j++){
                if(dp[i][j] == -1) continue;
                int a = dp[i - 1][j] == -1? 0 : dp[i - 1][j];
                int b = dp[i][j - 1] == -1? 0 : dp[i][j - 1];
                dp[i][j] = (a + b)% 1000000007;
            }
        }
        answer = dp[n - 1][m - 1];
        // for(int[] row : dp){
        //     System.out.println(Arrays.toString(row));
        // }
        return answer;
    }
}