import java.util.*;

class Solution {
    static int answer = 0;
    public int[][] removeElement(int[][] board, int col, Stack<Integer> stack){
        for(int i = 0 ; i < board.length ; i++){
            if(board[i][col] != 0){
                if(stack.isEmpty()){
                    stack.push(board[i][col]);
                }else{
                    if(stack.peek() == board[i][col]){
                        stack.pop();
                        answer += 2;
                    }else{
                        stack.push(board[i][col]);    
                    }    
                }
                
                board[i][col] = 0;
                break;
            }
        }
        return board;
    }
    public int solution(int[][] board, int[] moves) {
        Stack<Integer> stack = new Stack<>();
        for(int m : moves){
            removeElement(board, m - 1, stack);
        }
        
        return answer;
    }
}