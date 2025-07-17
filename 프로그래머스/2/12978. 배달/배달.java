import java.util.*;

class Solution {
    static int N;
    static int K;
    static List<int[]>[] map;
    static int dijkstra(){
        int[] dist = new int[N + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        boolean[] v = new boolean[N + 1];
        PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> {
            return a[1] - b[1];
        });
        
        q.offer(new int[]{1, 0});
        dist[1] = 0;
        
        while(!q.isEmpty()){
            int[] now = q.poll();
            int node = now[0];
            if(v[node]) continue;
            v[node] = true;
            for(int[] next : map[node]){
                int nextNode = next[0];
                int nextCost = next[1];
                if(dist[nextNode] > dist[node] + nextCost){
                    dist[nextNode] = dist[node] + nextCost;
                    q.offer(new int[]{nextNode, dist[nextNode]});
                }
            }
        }
        int cnt = 0;
        for(int i : dist){
            if(i <= K) cnt++;
        }
        // System.out.println(Arrays.toString(dist));
        return cnt;
    }
    public int solution(int n, int[][] road, int k) {
        int answer = 0;
        N = n;
        K = k;
        map = new ArrayList[N + 1];
        for(int i = 1 ; i < N + 1 ; i++){
            map[i] = new ArrayList<>();
        }
        for(int[] r : road){
            int from = r[0];
            int to = r[1];
            int cost = r[2];
            map[from].add(new int[]{to, cost});
            map[to].add(new int[]{from, cost});
        }
        answer = dijkstra();
        return answer;
    }
}