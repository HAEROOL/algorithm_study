import java.util.*;

class Solution {
    static int[]dist;
    static List<Integer>[] map;
    static void dijkstra(int start, int n){
        PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        boolean[] v = new boolean[n + 1];
        dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        q.offer(new int[]{start, 0});
        dist[start] = 0;
        while(!q.isEmpty()){
            int[] now = q.poll();
            
            
            if(v[now[0]]) continue;
            v[now[0]] = true;
            for(int next : map[now[0]]){
                if(dist[next] > dist[now[0]] + 1){
                    
                    dist[next] = 1 + dist[now[0]];
                    q.offer(new int[]{next, dist[next]});
                }
            }
        }
        // System.out.println(Arrays.toString(dist));
    }
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        int[] answer = new int[sources.length];
        Arrays.fill(answer, -1);
        map = new ArrayList[n + 1];
        for(int i = 1 ; i < n + 1 ; i++){
            map[i] = new ArrayList<>();
        }
        for(int[] road : roads){
            int a = road[0];
            int b = road[1];
            map[a].add(b);
            map[b].add(a);
        }
        dijkstra(destination, n);
        for(int s = 0 ; s < sources.length ; s++){
            answer[s] = dist[sources[s]] == Integer.MAX_VALUE?-1:dist[sources[s]];
        }

        return answer;
    }
}