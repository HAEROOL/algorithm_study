import java.util.*;

class Solution {
    static String[][] map;
    static int bfs(int sx, int sy){
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};
        
        Deque<int[]> q = new ArrayDeque<>();
        boolean[][][] v = new boolean[4][map.length][map[0].length];
        
        q.offer(new int[]{sx, sy, 0, 0});
        q.offer(new int[]{sx, sy, 1, 0});
        q.offer(new int[]{sx, sy, 2, 0});
        q.offer(new int[]{sx, sy, 3, 0});
        v[0][sx][sy] = true;
        v[1][sx][sy] = true;
        v[2][sx][sy] = true;
        v[3][sx][sy] = true;
        
        while(!q.isEmpty()){
            int[] now = q.poll();
            
            int x = now[0];
            int y = now[1];
            // System.out.println(x + " " + y + "  dir: " + now[2] + "/ " + now[3]);
            if(map[x][y].equals("G")){
                return now[3];
            }
            
            for(int i = 0 ; i < 4 ; i++){
                int tx = x;
                int ty = y;
                while(true){
                    int nx = tx + dx[i];
                    int ny = ty + dy[i];
                    if(0 <= nx && nx < map.length && 0 <= ny && ny < map[0].length && !map[nx][ny].equals("D")){
                        tx = nx;
                        ty = ny;
                    }else{
                        break;
                    }
                }
                if(!v[i][tx][ty]){
                    q.offer(new int[]{tx, ty, i, now[3] + 1});
                    v[i][tx][ty] = true;
                }

            }
            
        }
        return -1;
        
    }
    public int solution(String[] board) {
        int answer = 0;
        map = new String[board.length][board[0].length()];
        for(int i = 0 ; i < board.length ; i++){
            String[] tmp = board[i].split("");
            for(int j = 0 ; j < tmp.length ; j++){
                map[i][j] = tmp[j];
            }
        }
        
        for(int i = 0 ; i < map.length ; i++){
            for(int j = 0 ; j < map[0].length ; j++){
                if(map[i][j].equals("R")){
                    answer = bfs(i, j);    
                }
            }
        }
        return answer;
    }
}