import java.util.*;

class Solution {
    public int solution(int[][] maps) {
        int answer = 0;
        int N = maps.length;
        int M = maps[0].length;
        int[][] v = new int[N][M];
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};
        Deque<int[]> q = new ArrayDeque<>();
        for(int i = 0 ; i < N ; i++){
            for(int j = 0 ; j < M ; j++){
                v[i][j] = -1;
            }
        }
        q.offer(new int[]{0, 0});
        v[0][0] = 1;
        
        while(!q.isEmpty()){
            int[] now = q.poll();
            if(now[0] == N - 1 && now[1] == M - 1){
                break;
            }
            for(int i = 0 ; i < 4 ; i++){
                int nx = now[0] + dx[i];
                int ny = now[1] + dy[i];
                
                if(0 <= nx && nx < N && 0 <= ny && ny < M && v[nx][ny] == -1 && maps[nx][ny] == 1){
                    q.offer(new int[]{nx, ny});
                    v[nx][ny] = v[now[0]][now[1]] + 1;
                }
            }
        }
        answer = v[N - 1][M - 1];
        return answer;
    }
}