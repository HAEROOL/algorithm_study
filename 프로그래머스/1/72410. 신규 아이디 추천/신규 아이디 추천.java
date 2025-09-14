public class Solution {
    public String solution(String newId) {
        String answer = "";
        
        // 1단계: 소문자로 변환 후 유효하지 않은 문자 제거
        answer = newId.toLowerCase().replaceAll("[^0-9a-z_.\\-]", "");
        
        // 3단계: 연속된 마침표를 하나로 압축
        answer = answer.replaceAll("\\.{2,}", ".");
        
        // 4단계: 양끝 마침표 제거
        if (answer.startsWith(".")) {
            answer = answer.substring(1);
        }
        if (answer.endsWith(".")) {
            answer = answer.substring(0, answer.length() - 1);
        }
        
        // 5단계: 빈 문자열이면 "a" 추가
        if (answer.isEmpty()) {
            answer = "a";
        }
        
        // 6단계: 15개 문자를 제외하고 모두 제거, 우측 마침표 제거
        if (answer.length() > 15) {
            answer = answer.substring(0, 15);
        }
        if (answer.endsWith(".")) {
            answer = answer.substring(0, answer.length() - 1);
        }
        
        // 7단계: 길이가 3이 될 때까지 마지막 문자 반복 추가
        while (answer.length() < 3) {
            answer += answer.charAt(answer.length() - 1);
        }
        
        return answer;
    }
}