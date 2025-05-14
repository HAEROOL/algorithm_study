import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 1;
        Deque<int[]> q = new ArrayDeque<int[]>();
        for(int i = 0 ; i < priorities.length ; i++){
            q.offer(new int[]{i, priorities[i]});
        }
        while(true){
            int[] p = q.poll();
            boolean isBreak = false;
            for(int i = 0 ; i < priorities.length ; i++){
                if(priorities[i] > p[1]){
                    q.offer(p);
                    isBreak = true;
                    break;
                }
            }
            if(isBreak) continue;
            else{
                priorities[p[0]] = -1;
            }
            if(p[0] == location) break;
            answer++;
        }
        return answer;
    }
}