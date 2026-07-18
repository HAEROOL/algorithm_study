import java.util.*;
class Solution {
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        int answer = 0;
        int[] dx = new int[]{0, 1, 0, -1};
        int[] dy = new int[]{1, 0, -1, 0};
        int[][] map = new int[101][101];
        
        for(int[] coord : rectangle){
            int sy = coord[0] * 2;
            int sx = coord[1] * 2;
            int ey = coord[2] * 2;
            int ex = coord[3] * 2;
            
            for(int i = sx ; i < ex ; i++){
                map[i][sy] = 1;
            }
            for(int i = sx ; i < ex ; i++){
                map[i][ey] = 1;
            }
            for(int i = sy ; i <= ey ; i++){
                map[sx][i] = 1;
            }
            for(int i = sy ; i <= ey ; i++){
                map[ex][i] = 1;
            }
        }
        
        for(int[] coord : rectangle){
            int sy = coord[0] * 2;
            int sx = coord[1] * 2;
            int ey = coord[2] * 2;
            int ex = coord[3] * 2;
            
            for(int i = sx + 1 ; i < ex ; i++){
                for(int j = sy + 1 ; j < ey ; j++){
                    map[i][j] = 0;
                }
            }
        }
        
//         for(int[] row : map){
//             System.out.println(Arrays.toString(row));
//         }
        
        int cy = characterX * 2;
        int cx = characterY * 2;
        
        int ty = itemX * 2;
        int tx = itemY * 2;
        
        int[][] v = new int[101][101];
        Deque<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{cx, cy});
        v[cx][cy] = 1;
        
        while(!q.isEmpty()){
            int[] now = q.poll();
            
            if(now[0] == tx && now[1] == ty){
                answer = (v[now[0]][now[1]] - 1) / 2;
                break;
            }
            
            for(int i = 0 ; i < 4 ; i++){
                int nx = now[0] + dx[i];
                int ny = now[1] + dy[i];
                
                if(0 <= nx && nx < 101 && 0 <= ny && ny < 101 && v[nx][ny] == 0 && map[nx][ny] == 1){
                    q.offer(new int[]{nx, ny});
                    v[nx][ny] = v[now[0]][now[1]] + 1;
                }
            }
        }
        
        
        return answer;
    }
}