import java.util.*;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        int answer = 0;
        Deque<Integer> q1 = new ArrayDeque<Integer>();
        Deque<Integer> q2 = new ArrayDeque<Integer>();
        long sumA = 0;
        long sumB = 0;
        for(int i = 0 ; i < queue1.length ; i++){
            sumA += queue1[i];
            q1.offer(queue1[i]);
            sumB += queue2[i];
            q2.offer(queue2[i]);
        }
        if(sumA == sumB) return 0;
        while(sumA != sumB){
            if(answer >= 1500001) {
                answer = -1;
                break;
            }
            if(sumA > sumB){
                int a = q1.poll();
                sumA -= a;
                sumB += a;
                q2.offer(a);
                answer++;
            }else{
                int a = q2.poll();
                sumA += a;
                sumB -= a;
                q1.offer(a);
                answer++;
            }
        }
        return answer;
    }
}