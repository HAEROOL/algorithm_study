import java.util.*;

class Solution {
    static boolean isPrime(long N) {
    if (N < 2) return false;
    if (N % 2 == 0) return (N == 2);
    int r = (int)Math.sqrt(N);
    for (int i = 3; i <= r; i += 2) {
        if (N % i == 0) return false;
    }
    return true;
}
    public int solution(int n, int k) {
        int answer = 0;
        String prime = Integer.toString(n, k);
        // checkPrime(n);
        
        String[] arr = prime.split("0");
        // System.out.println(Arrays.toString(arr));
        for(String s : arr){
            
            if(s.equals("")) continue;
            long num = Long.parseLong(s);
            if(isPrime(num)){
                answer++;
            }
        }
        return answer;
    }
}