import java.util.*;

class Solution {
    public int solution(int[] A, int[] B) {
        int answer = 0;
        Arrays.sort(A);
        Arrays.sort(B);
        
        int bp = 0; 
        int ap = 0;
        
        while(bp != B.length && ap != A.length){
            if(A[ap] >= B[bp]){
                bp++;
            }else{
                ap++;
                bp++;
                answer++;
            }
        }
        return answer;
    }
}