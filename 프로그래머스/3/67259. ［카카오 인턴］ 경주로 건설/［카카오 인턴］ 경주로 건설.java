import java.util.*;

class Solution {
    public int solution(int[][] board) {
        int answer = 0;
        int N = board.length;
        int M = board[0].length;
        int[][][] dp = new int[N][M][4];
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};
        PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> {
            return a[2] - b[2];
        });
        for(int i = 0 ; i < N ; i++){
            for(int j = 0 ; j < M ; j++){
                for(int k = 0 ; k < 4 ; k++){
                    dp[i][j][k] = Integer.MAX_VALUE;
                }
            }
        }
        
        q.offer(new int[]{0, 0, 0, 0});
        q.offer(new int[]{0, 0, 0, 1});
        
        while(!q.isEmpty()){
            int[] node = q.poll();
            int x = node[0];
            int y = node[1];
            int cost = node[2];
            if(x == N - 1 && y == M - 1){
                answer = cost;
                break;
            }
            int dir = node[3];
            if(dp[x][y][dir] < cost) continue;
            dp[x][y][dir] = cost;
            
            for(int i = 0 ; i < 4 ; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];
                int nextcost = 100;
                if(i != dir) nextcost += 500;
                if(0 <= nx && nx < N && 0 <= ny && ny < M && board[nx][ny] == 0){
                    q.offer(new int[]{nx, ny, cost + nextcost, i});
                }
            }
            
        }
        
        
        return answer;
    }
}