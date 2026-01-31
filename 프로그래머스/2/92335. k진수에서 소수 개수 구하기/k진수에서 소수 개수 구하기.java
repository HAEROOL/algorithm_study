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
        String[] num = Integer.toString(n, k).split("0");
        for(String s : num){
            if(s.equals("")) continue;
            if(isPrime(Long.parseLong(s))){
                answer++;
            }
        }
        System.out.println(Arrays.toString(num));
        return answer;
    }
}