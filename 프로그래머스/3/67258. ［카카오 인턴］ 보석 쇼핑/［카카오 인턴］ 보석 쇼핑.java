import java.util.*;

class Solution {
    public int[] solution(String[] gems) {
        int[] answer = new int[]{1, gems.length};
        Set<String> types = new HashSet<>();
        Map<String,Integer> dict= new HashMap<>();
        for(String gem :gems){
            types.add(gem);
        }
        int right = 0;
        int left = 0;
        dict.put(gems[left], 1);
        while(left <= right){
            if(dict.size() == types.size() && right - left < answer[1] - answer[0]){
                answer[0] = left + 1;
                answer[1] = right + 1;
            }
            if(dict.size() == types.size()){
                if(dict.get(gems[left]) == 1){
                    dict.remove(gems[left]);
                }else{
                    dict.put(gems[left], dict.get(gems[left]) - 1);
                }
                left++;
            }else{
                if(++right == gems.length) break;
                if(dict.containsKey(gems[right])){
                    dict.put(gems[right], dict.get(gems[right]) + 1);
                }else{
                    dict.put(gems[right], 1);
                }
            }
        }
        return answer;
    }
}