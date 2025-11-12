import java.util.*;

class Solution {
    public int solution(int[] diffs, int[] times, long limit) {
        int answer = 0;
        int[] dp = new int[diffs.length];
        dp[0] = times[0];
        int maxTime = -1;
        int maxLevel = -1;
        for(int i = 1 ; i < diffs.length ; i++){
            dp[i] = dp[i - 1] + times[i];
        }
        for(int i = 0 ; i < diffs.length ; i++){
            maxTime = Math.max(maxTime, times[i]);
            maxLevel = Math.max(maxLevel, diffs[i]);
        }
        
        int start = 1;
        int end = maxLevel;
        // System.out.println(Arrays.toString(dp));
        while(start <= end){
            int mid = (start + end) / 2;
            long time = 0;
            for(int i = 0 ; i < diffs.length ; i++){
                if(mid >= diffs[i]){
                    time += times[i];
                    // System.out.println("time: " + times[i]);
                }else{
                    time += (diffs[i] - mid) * (times[i] + times[i - 1]) + times[i];
                    // System.out.println("time: " + ((diffs[i] - mid) * (times[i] + times[i - 1]) + times[i]));
                }
            }
            if(time > limit){
                start = mid + 1;
            }else{
                // System.out.println(mid + " " + time);
                end = mid - 1;
                answer = mid;
            }
        }
        return answer;
    }
}