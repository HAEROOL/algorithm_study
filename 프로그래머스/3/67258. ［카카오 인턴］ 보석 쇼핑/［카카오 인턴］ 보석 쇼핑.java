import java.util.*;

class Solution {
    public int[] solution(String[] gems) {
        int[] answer = {};
        Map<String, Integer> map = new HashMap<>();
        Set<String> set = new HashSet<>();
        Set<String> ansSet = new HashSet<>();
        for(String g : gems) ansSet.add(g);
        int tgt = ansSet.size();
        int start = 0;
        int end = 0;
        int size = Integer.MAX_VALUE;
        while(start <= end){
            if(set.size() < tgt && end < gems.length){
                set.add(gems[end]);
                if(map.containsKey(gems[end])) map.replace(gems[end], map.get(gems[end]) + 1);
                else map.put(gems[end], 1);
                end++;
                // System.out.println(set + " " + start + " " + end);
            }else{
                if(start == gems.length) break;
                if(set.size() == tgt && end - start + 1 < size){
                    answer = new int[]{start + 1, end};
                    size = end - start + 1;
                }
                String gem = gems[start];
                int cnt = map.get(gem);
                if(cnt == 1) {
                    set.remove(gem);
                }
                map.replace(gem, cnt - 1);
                start++;

                
                // System.out.println(set + " " + start + " " + end);
            }
        }
        return answer;
    }
}