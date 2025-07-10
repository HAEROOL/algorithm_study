import java.util.*;

class Solution {
    int[] dx = {1, 0, -1};
    int[] dy = {0, 1, -1};
    public int[] solution(int n) {
        int[] answer = new int[(n * (n + 1)) / 2];
        int[][] board = new int[n][n];
        int count = 1;
        int x = -1;
        int y = 0;
        int d = 0;
        for(int i = n ; i > 0 ; i--){
            for(int j = 0 ; j < i ; j++){
                int nx = x + dx[d % 3];
                int ny = y + dy[d % 3];
                // System.out.println(nx + "," + ny);
                board[nx][ny] = count++;
                x = nx;
                y = ny;
            }
            d++;
        }
        int idx = 0;
        for(int[] row : board){
            for(int e : row){
                if(e != 0){
                    answer[idx++] = e;
                }
            }
        }
        
        return answer;
    }
}