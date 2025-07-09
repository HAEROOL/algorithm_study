import java.util.*;

class Solution {
    public int solution(int x, int y, int n) {
        int answer = -1;
        boolean[] v = new boolean[y + 1];
        Deque<int[]> q = new ArrayDeque<>();
        v[x] = true;
        q.offer(new int[]{x, 0});
        
        while(!q.isEmpty()){
            int[] now = q.poll();
            int num = now[0];
            int count = now[1];
            
            if(num == y){
                answer = count;
                break;
            }
            
            if(num * 2 <= y && !v[num * 2]){
                v[num * 2] = true;
                q.offer(new int[]{num * 2, count + 1});
            }
            if(num * 3 <= y && !v[num * 3]){
                v[num * 3] = true;
                q.offer(new int[]{num * 3, count + 1});
            }
            if(num + n <= y && !v[num + n]){
                v[num + n] = true;
                q.offer(new int[]{num + n, count + 1});
            }
        }
        return answer;
    }
}