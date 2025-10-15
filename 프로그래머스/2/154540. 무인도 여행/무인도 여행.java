import java.util.*;

class Solution {
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    public int[] solution(String[] maps) {
        int[] answer = {};
        
        String[][] board = new String[maps.length][maps[0].length()];
        for(int i = 0 ; i < board.length ; i++){
            String[] tmp = maps[i].split("");
            for(int j = 0 ; j < tmp.length ; j++){
                board[i][j] = tmp[j];
            }
        }
        int N = board.length;
        int M = board[0].length;
        List<Integer> list = new ArrayList<>();
        boolean[][] v = new boolean[N][M];
        for(int i = 0 ; i < board.length ; i++){
            for(int j = 0 ; j < board[0].length ; j++){
                
                if(!board[i][j].equals("X")){
                    if(!v[i][j]){
                        int total = 0;
                        Deque<int[]> q = new ArrayDeque<>();
                        q.offer(new int[]{i, j});
                        v[i][j] = true;
                        total += Integer.parseInt(board[i][j]);
                        while(!q.isEmpty()){
                            int[] now = q.poll();
                            
                            for(int k = 0 ; k < 4 ; k++){
                                int nx = now[0] + dx[k];
                                int ny = now[1] + dy[k];
                                
                                if(0 <= nx && nx < N && 0 <= ny && ny < M && !v[nx][ny] && !board[nx][ny].equals("X")){
                                    q.offer(new int[]{nx, ny});
                                    v[nx][ny] = true;
                                    total += Integer.parseInt(board[nx][ny]);
                                }
                            }
                        }
                        list.add(total);
                    }
                }
            }
        }
        // System.out.println(list);
        Collections.sort(list);
        answer = new int[list.size()];
        
        for(int i = 0 ; i < answer.length ; i++){
            answer[i] = list.get(i);
        }
        if(answer.length == 0) return new int[]{-1};
        return answer;
    }
}