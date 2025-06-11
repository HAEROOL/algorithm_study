import java.util.*;

class Solution {
    public long solution(int n, int[] times) {
        long answer = 0;
        Arrays.sort(times);
        long start = 0;
        long end = (long)Math.pow(10, 18);
        while(start < end){
            long mid = (start + end) / 2;
            long total = 0;
            for(int i = 0 ; i < times.length ; i++){
                total += mid / times[i];
            }
            if(total < n){
                start = mid + 1;
                answer = start;
            }else{
                end = mid;
                answer = mid;
            }
        }
        // answer = (start + end) / 2; 
        return answer;
    }
}