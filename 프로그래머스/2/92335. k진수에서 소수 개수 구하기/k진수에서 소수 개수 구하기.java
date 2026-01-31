import java.util.*;
class Solution {
    static boolean isPrime(Long n){
        if(n == 1) return false;
        if(n == 2) return true;
        for(int i = 2 ; i <= (int)Math.sqrt(n) ; i++){
            if(n % i == 0) return false;
        }
        return true;
    }
    public int solution(int n, int k) {
        int answer = 0;
        String nstr = Integer.toString(n, k);
        String[] str = nstr.split("0");
        // System.out.println(Arrays.toString(str) + "/" + nstr);
        for(String s : str){
            if(s.equals("")) continue;
            // System.out.println(s);
            if(isPrime(Long.parseLong(s))){
                answer++;
                // System.out.println(s);
            } 
        }
        return answer;
    }
}