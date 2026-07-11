import java.util.*;

class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        Arrays.sort(citations);
        for(int i = 0 ; i < citations[citations.length - 1] ; i++){
            int cnt = 0;
            int ncnt = 0;
            for(int j = 0 ; j < citations.length ; j++){
                if(citations[j] >= i){
                    cnt++;
                }else{
                    ncnt++;
                }
            }
            if(cnt >= i && ncnt <= i) answer = i;
        }
        return answer;
    }
}