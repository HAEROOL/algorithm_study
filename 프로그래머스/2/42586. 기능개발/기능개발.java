import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer = {};
        int[] time = new int[progresses.length];
        List<Integer> ans = new ArrayList<>();
        Deque<Integer> q = new ArrayDeque<>();
        q.offer((int)Math.ceil((100 - progresses[0]) / (double)speeds[0]));
        for(int i = 1 ; i < progresses.length ; i++){
            time[i] = (int)Math.ceil((100 - progresses[i]) / (double)speeds[i]);
            if(q.peek() >= time[i]){
                q.offer(time[i]);
            }else{
                ans.add(q.size());
                q = new ArrayDeque<>();
                q.offer(time[i]);
            }
        }
        if(q.size() != 0) ans.add(q.size());
        answer = new int[ans.size()];
        for(int i = 0 ; i < answer.length ; i++){
            answer[i] = ans.get(i);
        }
        return answer;
    }
}