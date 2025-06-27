import java.util.*;

class Solution {
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int prim(int[][] land, int height){
        int[][] cost = new int[land.length][land.length];
        boolean[][] v = new boolean[land.length][land.length];
        for(int i = 0 ; i < land.length ; i++){
            for(int j = 0 ; j < land.length ; j++){
                cost[i][j] = Integer.MAX_VALUE;
            }
        }
        PriorityQueue<int[]> q = new PriorityQueue<int[]>((a, b) -> {
            return a[2] - b[2]; 
        });
        cost[0][0] = 0;
        q.offer(new int[]{0, 0, 0});
        int total = 0;
        while(!q.isEmpty()){
            int[] node = q.poll();
            int x = node[0];
            int y = node[1];
            int nowcost = node[2];
            if(v[x][y]) continue;
            v[x][y] = true;
            total += nowcost;
            for(int i = 0 ; i < 4 ; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];
                if(0 <= nx && nx < land.length && 0 <= ny && ny < land.length && !v[nx][ny]){
                    int ncost = 0;
                    if(Math.abs(land[x][y] - land[nx][ny]) > height){
                        ncost = Math.abs(land[x][y] - land[nx][ny]);
                    }
                    q.offer(new int[]{nx, ny, ncost});
                }
            }
        }
        return total;
    }
    public int solution(int[][] land, int height) {
        int answer = prim(land, height);
        return answer;
    }
}