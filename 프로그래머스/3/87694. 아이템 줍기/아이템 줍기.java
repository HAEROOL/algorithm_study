import java.util.*;

class Solution {
    static int answer;
    static int[][] map;
    static int[] dx = new int[]{1, 0, -1, 0};
    static int[] dy = new int[]{0, 1, 0, -1};
    static void drawMap(int lx, int ly, int rx, int ry){
        for(int i = lx ; i < rx + 1 ; i++){
            for(int j = ly ; j < ry + 1 ; j++){
                if((i == lx || i == rx || j == ly || j == ry) && map[i][j] != 2) map[i][j] = 1;
                else map[i][j] = 2;
            }
        }
    }
    static int bfs(int sx, int sy, int tx, int ty){
        boolean[][] v = new boolean[101][101];
        Deque<int[]> q = new ArrayDeque<int[]>();
        q.offer(new int[]{sx, sy, 0});
        v[sx][sy] = true;
        while(!q.isEmpty()){
            int[] coord = q.poll();
            int x = coord[0];
            int y = coord[1];
            if(x == tx && y == ty) {
                return coord[2] / 2;
            }
            for(int i = 0 ; i < 4 ; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];
                if(0 <= nx && nx < 101 && 0 <= ny && ny < 101 && !v[nx][ny] && map[nx][ny] == 1){
                    v[nx][ny] = true;
                    q.offer(new int[]{nx, ny, coord[2] + 1});
                }
            }
        }
        return 0;
        
    }
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        answer = 0;
        map = new int[101][101];
        for(int[] coord : rectangle){
            int ly = coord[0];
            int lx = coord[1];
            int ry = coord[2];
            int rx = coord[3];
            drawMap(lx * 2, ly * 2, rx * 2, ry * 2);
        }
        answer = bfs(characterY * 2, characterX * 2, itemY * 2, itemX * 2);
        return answer;
    }
}