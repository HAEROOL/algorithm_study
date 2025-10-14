import java.util.*;

class Solution {
    public int solution(int n, int k, int[] enemy) {
        int answer = 0;
        
        if(k >= enemy.length) return enemy.length;
        
        int total = 0;
        int barrier = k;
        int idx = 0;
        PriorityQueue<Integer> q = new PriorityQueue<>((a, b) -> b - a);
        while(true){
            int e = enemy[idx++];
            q.offer(e);
            total += e;
            
            if(total > n){
                if(barrier > 0){
                    barrier--;
                    total -= q.poll();
                }else{
                    answer = idx - 1;
                    break;
                }
            }
            if(idx == enemy.length) {
                answer = idx;
                break;
            }
        }
        return answer;
    }
}