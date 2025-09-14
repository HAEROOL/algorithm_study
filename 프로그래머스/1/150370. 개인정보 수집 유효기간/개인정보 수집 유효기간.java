import java.util.*;

public class Solution {
    
    // to_days 함수 변환
    public int toDays(String date) {
        String[] parts = date.split("\\.");
        int year = Integer.parseInt(parts[0]);
        int month = Integer.parseInt(parts[1]);
        int day = Integer.parseInt(parts[2]);
        return year * 28 * 12 + month * 28 + day;
    }
    
    public int[] solution(String today, String[] terms, String[] privacies) {
        // months 딕셔너리 생성
        Map<Character, Integer> months = new HashMap<>();
        for (String term : terms) {
            char type = term.charAt(0);
            int period = Integer.parseInt(term.substring(2)) * 28;
            months.put(type, period);
        }
        
        // 오늘 날짜를 일수로 변환
        int todayDays = toDays(today);
        
        // 만료된 개인정보 번호 찾기
        List<Integer> expiredList = new ArrayList<>();
        for (int i = 0; i < privacies.length; i++) {
            String privacy = privacies[i];
            String date = privacy.substring(0, privacy.length() - 2); // 마지막 2자리 제외
            char type = privacy.charAt(privacy.length() - 1); // 마지막 문자
            
            int privacyDays = toDays(date);
            int expireDays = privacyDays + months.get(type);
            
            if (expireDays <= todayDays) {
                expiredList.add(i + 1); // 1-based 인덱스
            }
        }
        
        // List를 배열로 변환
        return expiredList.stream().mapToInt(Integer::intValue).toArray();
    }
}