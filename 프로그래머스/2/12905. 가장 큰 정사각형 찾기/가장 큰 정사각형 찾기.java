import java.util.*;

class Solution
{
    public int solution(int [][]board)
    {
        int answer = 0;
        int[][] dp = new int[board.length][board[0].length];
        for(int i = 0 ; i < board.length ; i++){
            for(int j = 0 ; j < board[0].length ; j++){
                if(board[i][j] == 1){
                    dp[i][j] = 1;
                    answer = 1;
                }
            }
        }
        for(int i = 1 ; i < board.length ; i++){
            for(int j = 1 ; j < board[0].length ; j++){
                if(board[i][j] == 1){
                    dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i][j - 1], dp[i - 1][j])) + 1;
                    answer = Math.max(dp[i][j] * dp[i][j], answer);
                }
            }
        }
        // for(int[] row : dp) System.out.println(Arrays.toString(row));
        return answer;
    }
}