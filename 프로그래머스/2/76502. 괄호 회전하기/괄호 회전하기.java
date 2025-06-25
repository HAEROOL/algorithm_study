import java.util.Stack;

class Solution {
    public int solution(String s) {
        // 올바른 괄호 문자열의 개수를 저장할 변수
        int answer = 0;

        for (int i = 0; i < s.length(); i++) {
            // 주어진 문자열이 올바른 괄호 문자열인지 검사
            if (verification(s)) {
                answer++;
            }

            // 문자열을 한 칸씩 회전
            s = shift(s);
        }

        return answer;
    }

    // 올바른 괄호인지 검사하는 함수
    private boolean verification(String s) {
        // 괄호를 저장할 스택
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '[') {
                stack.push(s.charAt(i));
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                if (stack.peek() == '(' && s.charAt(i) == ')')  {
                    stack.pop();
                } else if (stack.peek() == '{' && s.charAt(i) == '}') {
                    stack.pop();
                } else if (stack.peek() == '[' && s.charAt(i) == ']') {
                    stack.pop();
                } else return false;
            }
        }

        return stack.isEmpty();
    }
    private String shift(String s) {
        return s.substring(1) + s.charAt(0);
    }
}
