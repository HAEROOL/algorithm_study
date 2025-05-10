import java.util.*;

class Solution {
    public int solution(int n, int[] money) {
        int answer = 0;
        int[] dp = new int[n + 1];
        dp[0] = 1;
        for(int i = 0 ; i < money.length ; i++){
            for(int j = 0 ; j < n + 1 ; j++){
                if(j < money[i]) continue;
                dp[j] += dp[j - money[i]] % 1000000007;
            }
        }
        // for(int[] row: dp){
        //     System.out.println(Arrays.toString(row));
        // }
        return dp[n];
    }
}