import java.util.*;

class Solution {
    public int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];
        int[][] board = new int[rows][columns];
        for(int i = 0 ; i < rows ; i++){
            for(int j = 0 ; j < columns ; j++){
                board[i][j] = columns * i + (j + 1); 
            }
        }
        int idx = 0;
        for(int[] query : queries){
            int x1 = query[0] - 1;
            int y1 = query[1] - 1;
            int x2 = query[2] - 1;
            int y2 = query[3] - 1;
            int mn = Integer.MAX_VALUE;
            
            int tmp = board[x1][y1];
            for(int i = y1 + 1 ; i <= y2 ; i++){
                mn = Math.min(mn, tmp);
                // System.out.println(mn);
                int tmp2 = board[x1][i];
                board[x1][i] = tmp;
                tmp = tmp2;
            }

            for(int i = x1 + 1 ; i <= x2 ; i++){
                mn = Math.min(mn, tmp);
                // System.out.println(mn);
                int tmp2 = board[i][y2];
                board[i][y2] = tmp;
                tmp = tmp2;
            }
            for(int i = y2 - 1 ; i >= y1 ; i--){
                mn = Math.min(mn, tmp);
                // System.out.println(mn);
                int tmp2 = board[x2][i];
                board[x2][i] = tmp;
                tmp = tmp2;
            }
            for(int i = x2 - 1 ; i >= x1 ; i--){
                mn = Math.min(mn, tmp);
                // System.out.println(mn);
                int tmp2 = board[i][y1];
                board[i][y1] = tmp;
                tmp = tmp2;
            }
            // board[x2]
            // for(int[] row : board){
            //     System.out.println(Arrays.toString(row));
            // }
            answer[idx++] = mn;
        }
        return answer;
    }
}