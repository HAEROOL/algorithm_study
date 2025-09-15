import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        int HIT = 1;
        int MISS = 5;
        Map<String, Integer> timeMap = new HashMap<String, Integer>();
        Set<String> cacheSet = new HashSet<String>();
        
        for(String city : cities){
            timeMap.put(city.toLowerCase(), Integer.MAX_VALUE);
        }
        if(cacheSize == 0) return cities.length * MISS;
        for(int i = 0 ; i < cities.length ; i++){
            String city = cities[i].toLowerCase();
            // System.out.println(cacheSet);
            if(cacheSet.contains(city)){
                answer += HIT;
                timeMap.replace(city, i);
                // System.out.println("HIT: " + city);
                // System.out.println(timeMap);
            }else{
                if(cacheSet.size() == cacheSize){
                    int time = i;
                    String rcity = "";
                    for(String key : timeMap.keySet()){
                        if(time > timeMap.get(key) && cacheSet.contains(key)){
                            rcity = key;
                            time = timeMap.get(key);
                        }
                    }
                    cacheSet.remove(rcity);
                    answer += MISS;
                    cacheSet.add(city);
                    timeMap.replace(city, i);
                }else{
                    answer += MISS;
                    cacheSet.add(city);
                    timeMap.replace(city, i);
                }
            }
            
        }
        return answer;
    }
}