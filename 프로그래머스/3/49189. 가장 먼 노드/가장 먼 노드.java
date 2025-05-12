import java.util.*;

class Solution {
    static List<Integer>[] map;
    static int N;
    static int answer = 0;
    
    public int solution(int n, int[][] edge) {
        answer = 0;
        N = n;
        map = new ArrayList[n + 1];
        for(int i = 1 ; i < n + 1 ; i++){
            map[i] = new ArrayList<Integer>();
        }
        
        for(int[] e : edge){
            int a = e[0];
            int b = e[1];
            map[a].add(b);
            map[b].add(a);
        }
        
        int[] v = new int[n + 1];
        v[1] = 1;
        Deque<Integer> q = new ArrayDeque<Integer>();
        q.offer(1);
        
        int mx = -1;
        while(!q.isEmpty()){
            int now = q.poll();
            mx = Math.max(mx, v[now]);
            for(int next : map[now]){
                if(v[next] == 0){
                    v[next] = v[now] + 1;
                    q.offer(next);
                }
            }
        }
        // System.out.println(Arrays.toString(v) + " " + mx);
        for(int i : v){
            if(mx == i) answer++;
        }
        
        
        return answer;
    }
}