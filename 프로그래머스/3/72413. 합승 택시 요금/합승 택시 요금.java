import java.util.*;

class Solution {
    static List<int[]>[] map;
    static int N;
    static int[] dijkstra(int start){
        int[] dist = new int[N + 1];
        boolean[] v = new boolean[N + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        PriorityQueue<int[]> q = new PriorityQueue<int[]>((a, b) -> {
            return a[1] - b[1];
        });
        
        q.offer(new int[]{start, 0});
        dist[start] = 0;
        
        while(!q.isEmpty()){
            int[] now = q.poll();
            int node = now[0];
            int cost = now[1];
            
            if(v[node]) continue;
            v[node] = true;
            
            for(int[] next : map[node]){
                int nextNode = next[0];
                int nextCost = next[1];
                if(dist[nextNode] > nextCost + dist[node]){
                    dist[nextNode] = nextCost + dist[node];
                    q.offer(new int[]{nextNode, dist[nextNode]});
                }
            }
        }
        
        // System.out.println(Arrays.toString(dist));
        return dist;
    }
    public int solution(int n, int s, int a, int b, int[][] fares) {
        int answer = Integer.MAX_VALUE;
        map = new ArrayList[n + 1];
        N = n;
        for(int i = 1 ; i < N + 1 ; i++){
            map[i] = new ArrayList<int[]>();
        }
        for(int[] edge : fares){
            int from = edge[0];
            int to = edge[1];
            int cost = edge[2];
            map[from].add(new int[]{to, cost});
            map[to].add(new int[]{from, cost});
        }
        int[] together = dijkstra(s);
        for(int i = 1 ; i < N + 1 ; i++){
            int[] dist = dijkstra(i);
            int acost = dist[a];
            int bcost = dist[b];
            
            answer = Math.min(together[i] + acost + bcost, answer);
            
        }
        return answer;
    }
}