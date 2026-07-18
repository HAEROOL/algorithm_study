import java.util.*;
class Solution {
    static List<Integer>[] map;
    static int N;
    static int dijkstra(int start){
        boolean[] v = new boolean[N + 1];
        int[] dist = new int[N + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        
        PriorityQueue<int[]> q = new PriorityQueue<int[]>((a, b) -> {
            return a[1] - b[1];
        });
        
        q.offer(new int[]{start, 0});
        dist[start] = 0;
        
        while(!q.isEmpty()){
            int[] now = q.poll();
            if(v[now[0]]) continue;
            v[now[0]] = true;
            
            for(int next : map[now[0]]){
                if(dist[next] > now[1] + 1){
                    dist[next] = now[1] + 1;
                    q.offer(new int[]{next, dist[next]});
                }
            }
        }
        
        int mx = -1;
        for(int i = 1 ; i < N + 1; i++){
            if(dist[i] == Integer.MAX_VALUE) continue;
            mx = Math.max(mx, dist[i]);
        }
        
        int res = 0;
        for(int i : dist){
            if(mx == i) res++;
        }
        // System.out.println(Arrays.toString(dist));
        return res;
    }
    public int solution(int n, int[][] edge) {
        int answer = 0;
        map = new ArrayList[n + 1];
        N = n;
        
        for(int i = 0 ; i < N + 1 ; i++){
            map[i] = new ArrayList<>();
        }
        for(int[] tmp : edge){
            int from = tmp[0];
            int to = tmp[1];
            map[from].add(to);
            map[to].add(from);
        }
        
        answer = dijkstra(1);
        
        return answer;
    }
}