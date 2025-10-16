import java.util.*;

class Solution {
    public int[] solution(int n, long k) {
        int[] answer = new int[n];

        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= n; i++) list.add(i);

        long fact = 1;
        for (int i = 2; i <= n; i++) fact *= i;

        k--;
        for (int i = 0; i < n; i++) {
            fact /= (n - i);                
            int index = (int) (k / fact);  

            answer[i] = list.get(index);    
            list.remove(index);             
            k %= fact;                      
        }

        return answer;
    }

}