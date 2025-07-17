import java.util.*;

class Solution {
    static int[] bfs(int sx, int sy, String tgt){
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};
        boolean[][] v = new boolean[map.length][map[0].length];
        Deque<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{sx, sy});
        v[sx][sy] = true;
        int time = 0;
        while(!q.isEmpty()){
            int size = q.size();
            for(int t = 0 ; t < size ; t++){
                int[] now = q.poll();
                int x = now[0];
                int y = now[1];
                if(map[x][y].equals(tgt)){
                    return new int[]{x, y, time};
                }
                for(int i = 0 ; i < 4 ; i++){
                    int nx = x + dx[i];
                    int ny = y + dy[i];
                    if(0 <= nx && nx < N && 0 <= ny && ny < M && !v[nx][ny] && !map[nx][ny].equals("X")){
                        v[nx][ny] = true;
                        q.offer(new int[]{nx, ny});
                    }
                }
            }
            time++;
        }
        return new int[]{-1, -1, -1};
    }
    static int N, M;
    static String[][] map;
    public int solution(String[] maps) {
        int answer = 0;
        map = new String[maps.length][maps[0].length()];
        N = maps.length;
        M = map[0].length;
        int sx = -1, sy = -1;
        for(int i = 0 ; i < maps.length ; i++){
            String[] row = maps[i].split("");
            for(int j = 0 ; j < row.length ; j++){
                map[i][j] = row[j];
                if(row[j].equals("S")){
                    sx = i;
                    sy = j;
                }
            }
        }
        // for(String[] row : map){
        //     System.out.println(Arrays.toString(row));
        // }
        
        int[] ld = bfs(sx, sy, "L");
        if(ld[0] == -1) return -1;
        // System.out.println(Arrays.toString(ld));
        answer += ld[2];
        int[] ed = bfs(ld[0], ld[1], "E");
        if(ed[0] == -1) return -1;
        // System.out.println(Arrays.toString(ed));
        answer += ed[2];
        return answer;
    }
}