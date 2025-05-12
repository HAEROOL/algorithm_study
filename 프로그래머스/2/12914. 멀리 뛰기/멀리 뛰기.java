import java.util.*;

class Solution {
    public long solution(int n) {
        long answer = 0;
        long[] dp = new long[n + 1];
        if(n <= 3) return n;
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 3;
        for(int i = 4 ; i < n + 1 ; i++){
            dp[i] = (dp[i - 1] + dp[i - 2]) % 1234567;
        }
        answer = dp[n];
        System.out.println(Arrays.toString(dp));
        return answer;
    }
}