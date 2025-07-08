import java.util.*;

class Solution {
    public int solution(int[] order) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();
        int id = 1;
        for(int i = 0 ; i < order.length ; i++){
            while(id < order[i]){
                stack.push(id++);
            }
            if(order[i] == id){
                answer++;
                // System.out.println(order[i]);
                id++;
                
            }else{
                if(!stack.isEmpty() && stack.peek() == order[i]){
                    answer++;
                    stack.pop();
                }else{
                    // System.out.println(order[i]);
                    break;
                }
            }
            
        }
        return answer;
    }
}