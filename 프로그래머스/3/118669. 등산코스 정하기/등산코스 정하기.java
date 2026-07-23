import java.util.*;

class Solution {
    static List<int[]>[] map;
    static int n;
    static int[] summits;
    static int[] gates;
    static boolean[] isSummit;
    static boolean[] isGate;
    static int[] dijkstra(){
        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        boolean[] v = new boolean[n + 1];
        PriorityQueue<int[]> q = new PriorityQueue<int[]>((a, b) -> {
            return a[1] - b[1];
        });
        
        for(int i : gates){
            q.offer(new int[]{i, 0});
            dist[i] = 0; 
        }

        
        while(!q.isEmpty()){
            int[] now = q.poll();
            int node = now[0];
            int cost = now[1];
            
            if(isSummit[node]) continue;
            if(dist[node] < cost) continue;
            
            for(int[] next : map[node]){
                int nextNode = next[0];
                int nextCost = next[1];
                if(isGate[nextNode]) continue;
                if(dist[nextNode] > Math.max(dist[node], nextCost)){
                    dist[nextNode] = Math.max(dist[node], nextCost);
                    q.offer(new int[]{nextNode, dist[nextNode]});
                }
            }
        }
        Arrays.sort(summits);
        
        int minNode = -1;
        int minIntensity = Integer.MAX_VALUE;

        // 2. 산봉우리들 중 intensity가 가장 작은 것 선택
        for(int summit : summits){
            if(dist[summit] < minIntensity){
                minIntensity = dist[summit];
                minNode = summit;
            }
        }
        
        return new int[]{minNode, minIntensity};
    }
    public int[] solution(int n, int[][] paths, int[] gates, int[] summits) {
        int[] answer = {};
        this.summits = summits;
        this.gates = gates;
        isSummit = new boolean[n + 1];
        isGate = new boolean[n + 1];
        for(int i : summits) isSummit[i] = true;
        for(int i : gates) isGate[i] = true;
        this.n = n;
        map = new ArrayList[n + 1];
        for(int i = 1 ; i < n + 1 ; i++){
            map[i] = new ArrayList<>();
        }
        for(int i = 0 ; i < paths.length ; i++){
            int[] path = paths[i];
            int a = path[0];
            int b = path[1];
            int cost = path[2];
            map[a].add(new int[]{b, cost});
            map[b].add(new int[]{a, cost});
        }
        answer = dijkstra();
        return answer;
    }
}