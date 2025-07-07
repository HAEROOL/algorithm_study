import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];
        Stack<Integer> s = new Stack<>();
        
        for(int i = numbers.length - 1 ; i > -1 ; i--){
            int now = numbers[i];
            if(s.isEmpty()){
                answer[i] = -1;
                s.push(now);
                continue;
            }
            if(s.peek() > now){
                answer[i] = s.peek();
                s.push(now);
            }else{
                while(!s.isEmpty()){
                    if(s.peek() > now){
                        answer[i] = s.peek();
                        s.push(numbers[i]);
                        break;
                    }else{
                        s.pop();
                    }
                }
                 if(s.isEmpty()){
                answer[i] = -1;
                s.push(now);
                continue;
            }
            }
        }
        return answer;
    }
}