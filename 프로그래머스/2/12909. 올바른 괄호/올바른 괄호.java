import java.util.*;

class Solution {
    boolean solution(String s) {
        Deque<Character> stack = new ArrayDeque<Character>();
        if(s.length() % 2 == 1 || s.charAt(0) == ')') return false;
        for(int i = 0 ; i < s.length() ; i++){
            if(stack.isEmpty()){
                stack.offer(s.charAt(i));
                continue;
            }
            if(stack.peek() == '(' && s.charAt(i) == ')'){
                stack.pop();
            }else {
                stack.offer(s.charAt(i));
            }
        }
        return stack.isEmpty();
    }
}