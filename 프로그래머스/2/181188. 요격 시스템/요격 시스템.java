import java.util.*;

class Solution {
    public int solution(int[][] targets) {
        int answer = 0;
        Arrays.sort(targets, (a, b) -> a[1] - b[1]);
        // for(int[] target: targets) System.out.println(Arrays.toString(target));
        int p = 0;
        for(int[] target : targets){
            if(p > target[0]){
                continue;
            }else{
                p = target[1];
                answer++;
            }
        }
        return answer;
    }
}