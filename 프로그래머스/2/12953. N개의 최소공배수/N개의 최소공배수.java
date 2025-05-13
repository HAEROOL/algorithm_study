import java.util.*;

class Solution {
    static int gcd(int a, int b){
        return b == 0? a : gcd(b, a % b);
    }
    static int lcm(int a, int b){
        int g = gcd(a, b);
        return (a / g) * b;
    }
    public int solution(int[] arr) {
        int answer = 1;
        Arrays.sort(arr);
        int l = 1;
        l = arr[0];
        for(int i = 1 ; i < arr.length ; i++){
            l  = lcm(l, arr[i]);
        }
        answer = l;
        return answer;
    }
}