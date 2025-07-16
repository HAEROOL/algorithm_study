import java.util.*;

class Solution {
    public int solution(int storey) {
        int answer = 0;
        int p = (storey + "").length() - 1;
        while(storey > 0){
            int n = storey % 10;
            storey /= 10;
            
            if(n == 0) continue;
            if(n < 5){
                answer += n;
            }else if(n > 5){
                answer += (10 - n);
                storey++;
            }else{
                answer += 5;
                if(storey % 10 >= 5) storey++;
            }
        }
        return answer;
    }
}