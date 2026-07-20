import java.util.*;

class Solution {
    public int solution(int[][] board, int[][] skill) {
        int answer = 0;
        int[][] map = new int[board.length][board[0].length];
        int N = board.length;
        int M = board[0].length;
        for(int[] s : skill){
            int type = s[0];
            int r1 = s[1];
            int c1 = s[2];
            int r2 = s[3];
            int c2 = s[4];
            int degree = s[5];
            int ops = type == 1 ? -1 : 1;
            degree *= ops;
            map[r1][c1] += degree;
            if(r2 + 1 < N) map[r2 + 1][c1] -= degree;
            if(c2 + 1 < M) map[r1][c2 + 1] -= degree;
            if(r2 + 1 < N && c2 + 1 < M) map[r2 + 1][c2 + 1] += degree;
        }
        
        // for(int[] row : map){
        //     System.out.println(Arrays.toString(row));
        // }
        // System.out.println("");
            
        for(int i = 0 ; i < board.length; i++){
            for(int j = 1 ; j < board[0].length ; j++){
                map[i][j] += map[i][j - 1];
            }
        }
        
        for(int j = 0 ; j < board[0].length; j++){
            for(int i = 1 ; i < board.length ; i++){
                map[i][j] += map[i - 1][j];
            }
        }
        
        for(int i = 0 ; i < board.length; i++){
            for(int j = 0 ; j < board[0].length ; j++){
                board[i][j] += map[i][j];
                if(board[i][j] > 0) answer++;
            }
        }
//         for(int[] row : map){
//             System.out.println(Arrays.toString(row));
//         }
//         System.out.println("");
//         for(int[] row : board){
//             System.out.println(Arrays.toString(row));
//         }
        
        
        return answer;
    }
}