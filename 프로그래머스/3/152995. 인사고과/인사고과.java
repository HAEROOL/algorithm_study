import java.util.*;

class Solution {
    public int solution(int[][] scores) {
        int answer = 0;
        int[] target = scores[0];
        boolean[] isExcept = new boolean[scores.length];
        Arrays.sort(scores, (a, b) -> a[0] == b[0] ? a[1] - b[1] : b[0] - a[0]);
        int mx = 0;
        
        int rank = 1;
        
        for(int i = 0 ; i < scores.length ; i++){
            if(mx > scores[i][1]){
                if(scores[i][0] == target[0] && scores[i][1] == target[1]){
                    return -1;
                }
            }else{
                mx = Math.max(mx, scores[i][1]);
                if(scores[i][0] + scores[i][1] > target[0] + target[1]){
                    rank++;
                }
            }
        }
        
        return rank;
    }
}