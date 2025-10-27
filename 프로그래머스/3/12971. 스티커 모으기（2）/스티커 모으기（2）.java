import java.util.*;

class Solution {
    public int solution(int sticker[]) {
        int answer = 0;
        int[] dp1 = new int[sticker.length + 1];
        int[] dp2 = new int[sticker.length + 1];
        
        if(sticker.length <= 3){
            for(int i = 0 ; i < sticker.length ; i++){
                answer = Math.max(answer, sticker[i]);
            }
            return answer;
        }
        
        dp1[0] = dp2[0] = 0;
        
        for(int i = 1 ; i < sticker.length ; i++){
            dp1[i] = sticker[i - 1];
            dp2[i] = sticker[i];
        }
        
        for(int i = 2 ; i < sticker.length + 1 ; i++){
            dp1[i] = Math.max(dp1[i - 1], dp1[i] + dp1[i - 2]);
            dp2[i] = Math.max(dp2[i - 1], dp2[i] + dp2[i - 2]);
        }
        // System.out.println(Arrays.toString(dp1));
        // System.out.println(Arrays.toString(dp2));
        answer = Math.max(dp1[sticker.length],dp2[sticker.length]);
        return answer;
    }
}