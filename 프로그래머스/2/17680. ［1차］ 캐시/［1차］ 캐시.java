import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        List<String> cache = new ArrayList<>();
        
        // 도시를 입력받는다
        for(String city : cities){
            // 캐시에 없을 경우(+ 5)
            String c = city.toLowerCase();
            if(!cache.contains(c)){
                // 캐시에 추가한다.
                cache.add(0, c);
                answer += 5;
            }else{
                // 캐시에 있을 경우(+ 1)
                // 캐시에서 빼서 다시 앞으로 둔다
                cache.remove(c);
                cache.add(0, c);
                answer += 1;
            }
            // 캐시에 들어간 값이 cacheZise 보다 크면 마지막 요소를 없앤다.            
            if(cache.size() > cacheSize){
                cache.remove(cache.size() - 1);
            }
        } 

        return answer;
    }
}