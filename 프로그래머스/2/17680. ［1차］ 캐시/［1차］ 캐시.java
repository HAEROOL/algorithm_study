import java.util.*;

class Solution {
    Set<String> set = new HashSet<>();
    Map<String, Integer> map = new HashMap<>();
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        int time = 0;
        for(String c : cities){
            // set에 있으면 hit
            String city = c.toLowerCase();
            time++;
            if(set.contains(city)){
                // System.out.println(city + " cache hit");
                map.put(city, time);
                answer+=1;
                continue;
            }
            
            set.add(city);
            map.put(city, time);
            answer+=5;
            if(set.size() <= cacheSize) continue;
            int oldtime = Integer.MAX_VALUE;
            String oldkey = "";
            for(String key : map.keySet()){
                if(map.get(key) < oldtime){
                    oldtime = map.get(key);
                    oldkey = key;
                }
            }
            // System.out.println(oldkey + "removed");
            set.remove(oldkey);
            map.remove(oldkey);
        }
        return answer;
    }
}