import java.util.*;

class Solution {
    static boolean[] isPrime = new boolean[10000001];
    static void getPrime(){
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;
        for(int i = 2 ; i <= Math.sqrt(isPrime.length - 1) ; i++){
            if(isPrime[i]){
                for(int j = i * i ; j < isPrime.length ; j += i){
                    isPrime[j] = false;
                }
            }
        }
    }
    public int[] solution(long begin, long end) {
        int[] answer = new int[(int)end - (int)begin + 1];
        getPrime();
        for(int i = 0 ; i < answer.length ; i++){
            long num = begin + i;
            
            int mxDiv = 1;
            for(long div = 2 ; div <= Math.sqrt(num) ; div++){
                if(num % div == 0){
                    int div1 = (int) div;
                    int div2 = (int)(num / div);
                    mxDiv = Math.max(mxDiv, div1);
                    if(div2 <= 10000000){
                        mxDiv = Math.max(mxDiv, div2);
                    }
                }
            }
            answer[i] = mxDiv;
        }
        if(begin == 1){
            answer[0] = 0;
        }
        return answer;
    }
}