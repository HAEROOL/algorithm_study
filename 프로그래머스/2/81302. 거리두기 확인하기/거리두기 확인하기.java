import java.util.*;

class Solution {
    public int[] solution(String[][] places) {
        int[] answer = new int[places.length];
        
        for (int i = 0; i < places.length; i++) {
            answer[i] = bfs(places[i]);
        }
        
        return answer;
    }
    
    public int bfs(String[] p) {
        List<int[]> start = new ArrayList<>();
        
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (p[i].charAt(j) == 'P') {
                    start.add(new int[]{i, j});
                }
            }
        }
        
        for (int[] s : start) {
            Queue<int[]> queue = new LinkedList<>();
            queue.offer(s);  // 큐에 초기값
            
            boolean[][] visited = new boolean[5][5];  
            int[][] distance = new int[5][5];         
            visited[s[0]][s[1]] = true;
            
            while (!queue.isEmpty()) {
                int[] current = queue.poll();
                int y = current[0];
                int x = current[1];
                
                int[] dx = {-1, 1, 0, 0}; 
                int[] dy = {0, 0, -1, 1}; 
                
                for (int i = 0; i < 4; i++) {
                    int nx = x + dx[i];
                    int ny = y + dy[i];
                    
                    if (0 <= nx && nx < 5 && 0 <= ny && ny < 5 && !visited[ny][nx]) {
                        
                        if (p[ny].charAt(nx) == 'O') {
                            queue.offer(new int[]{ny, nx});
                            visited[ny][nx] = true;
                            distance[ny][nx] = distance[y][x] + 1;
                        }
                        
                        if (p[ny].charAt(nx) == 'P' && distance[y][x] <= 1) {
                            return 0;
                        }
                    }
                }
            }
        }
        return 1;
    }
}