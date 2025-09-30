import java.util.*;

class Solution {
    static String[] orders;
    static Map<String, Integer> menuCount;
    static int maxCount;
    
    // 조합 생성
    static void combination(int idx, int start, char[] sel, String order) {
        if (idx == sel.length) {
            String menu = new String(sel);
            menuCount.put(menu, menuCount.getOrDefault(menu, 0) + 1);
            maxCount = Math.max(maxCount, menuCount.get(menu));
            return;
        }
        
        for (int i = start; i < order.length(); i++) {
            sel[idx] = order.charAt(i);
            combination(idx + 1, i + 1, sel, order);
        }
    }
    
    public String[] solution(String[] orders, int[] course) {
        this.orders = orders;
        List<String> answer = new ArrayList<>();
        
        // 각 코스 크기별로 처리
        for (int size : course) {
            menuCount = new HashMap<>();
            maxCount = 0;
            
            // 각 주문에서 size 크기의 조합 생성
            for (String order : orders) {
                // 주문을 정렬 (AB와 BA를 같은 것으로 처리)
                char[] chars = order.toCharArray();
                Arrays.sort(chars);
                String sortedOrder = new String(chars);
                
                // size보다 짧은 주문은 건너뛰기
                if (sortedOrder.length() < size) continue;
                
                // 조합 생성
                combination(0, 0, new char[size], sortedOrder);
            }
            
            // 최소 2번 이상 주문되고, 최대 주문 횟수인 메뉴만 추가
            if (maxCount >= 2) {
                for (Map.Entry<String, Integer> entry : menuCount.entrySet()) {
                    if (entry.getValue() == maxCount) {
                        answer.add(entry.getKey());
                    }
                }
            }
        }
        
        // 사전순 정렬
        Collections.sort(answer);
        
        return answer.toArray(new String[0]);
    }
}