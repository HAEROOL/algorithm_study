import java.util.*;

class Solution {
    static List<Integer>[] map;
    static int N;
    static int answer = 0;
    static void dijkstra(int start){
        int[] dist = new int[N + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        boolean[] v = new boolean[N + 1];
        
        dist[start] = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((a, b) -> {
            return a[1] - b[1];
        });
        pq.offer(new int[]{start, 0});
        while(!pq.isEmpty()){
            int[] n = pq.poll();
            int now = n[0];
            
            if(v[now]) continue;
            v[now] = true;
            for(int next : map[now]){
                int nextNode = next;
                int nextCost = 1;
                if(dist[nextNode] > dist[now] + nextCost){
                    pq.offer(new int[]{nextNode, dist[now] + 1});
                    dist[nextNode] = dist[now] + 1;
                }
            }
        }
        int mx = -1;
        for(int i : dist){
            if(i == Integer.MAX_VALUE) continue;
            mx = Math.max(i, mx);
        }
        for(int i : dist){
            if(i == mx) answer++;
        }
         
    }
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
        
        dijkstra(1);
        return answer;
    }
}