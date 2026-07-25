import java.util.*;

class Solution {
    static int N;
    static int[][] map;
    static int prim(){
        int[] dist = new int[N];
        boolean[] v = new boolean[N];
        PriorityQueue<int[]> q = new PriorityQueue<int[]>((a, b) -> {
            return a[1] - b[1];
        });
        
        Arrays.fill(dist, Integer.MAX_VALUE);
        
        q.offer(new int[]{0, 0});
        dist[0] = 0;
        int total = 0;
        while(!q.isEmpty()){
            int[] now = q.poll();
            int node = now[0];
            int cost = now[1];
            
            if(v[node]) continue;
            v[node] = true;
            total += cost;
            for(int i = 0 ; i < N ; i++){
                if(dist[i] > map[node][i]){
                    dist[i] = map[node][i];
                    q.offer(new int[]{i, dist[i]});
                }
            }
        }
        // System.out.println(Arrays.toString(dist));
        
        return total;
    }
    public int solution(int n, int[][] costs) {
        int answer = 0;
        N = n;
        map = new int[n][n];
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < n ; j++){
                map[i][j] = Integer.MAX_VALUE;
            }
        }
        for(int[] cost : costs){
            int a = cost[0];
            int b = cost[1];
            int c = cost[2];
            map[a][b] = c;
            map[b][a] = c;
        }
        
        return prim();
    }
}