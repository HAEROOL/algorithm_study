import java.util.*;

class Solution {
    public int[] solution(String[] gems) {
        int[] answer = {};
        Set<String> gemSet = new HashSet<>();
        Map<String, Integer> map = new HashMap<>();
        
        for(int i = 0 ; i < gems.length ; i++){
            gemSet.add(gems[i]);
            map.putIfAbsent(gems[i], 0);
        }
        int left = 0;
        int right = 0;
        int total = 1;
        map.put(gems[0], 1);
        int mx = Integer.MAX_VALUE;
        while(left <= right){
            if(right == gems.length || left == gems.length) break;
            
            if(total < gemSet.size()){
                right++;
                if(right == gems.length) break;
                map.put(gems[right], map.get(gems[right]) + 1);
                if(map.get(gems[right]) == 1) total++;
                
            }else if(total == gemSet.size()){
                if(mx > right - left){
                    mx = right - left;
                    answer = new int[]{left + 1, right + 1};
                }
                map.put(gems[left], map.get(gems[left]) - 1);
                if(map.get(gems[left]) == 0) total--;
                
                left++;
            }
        }
        
        
        return answer;
    }
}