import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 0;
        
        Map<String, Integer> map = new HashMap<>();
        
        for(String[] c: clothes){
            map.putIfAbsent(c[1], 0);
            map.put(c[1], map.get(c[1]) + 1);
        }
        int tmp = 1;
        for(String k : map.keySet()){
            tmp *= (map.get(k) + 1);
        }
        answer += (tmp - 1);
        return answer;
    }
}