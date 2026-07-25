import java.util.*;
class Solution {
    static int[][] board;
    static int N;
    static int answer;
    static boolean isPossible(int row, int col){
        for(int i = row - 1 ; i > -1 ; i--){
                if(board[i][col] == 1 ||
                  (col + (row - i) < N && board[i][col + (row - i)] == 1)||
                  (col - (row - i) >= 0 && board[i][col - (row - i)] == 1)){
                      return false;
                  }
            }
        return true;
    }
    static void backtracking(int row, int count){
        if(row == N){
            // System.out.println(count);
            if(count == N){
                 answer++;
                // for(int[] r : board)System.out.println(Arrays.toString(r));
            }
            return;
        }
        for(int i = 0 ; i < N ; i++){
            if(isPossible(row, i)){
                board[row][i] = 1;
                backtracking(row + 1, count + 1);
                board[row][i] = 0;
            }
        }
        
    }
    public int solution(int n) {
        answer = 0;
        N = n;
        board = new int[n][n];
        backtracking(0, 0);
        return answer;
    }
}