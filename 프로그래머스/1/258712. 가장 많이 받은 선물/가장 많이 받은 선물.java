import java.util.*;

class Solution {
    public int solution(String[] friends, String[] gifts) {
        int answer = 0;
        Map<String,Map<String, Integer>> map = new HashMap<>();
        Map<String, Integer> ratioMap = new HashMap<>();
        for(int i = 0 ; i < friends.length ; i++){
            Map<String, Integer> fmap = new HashMap<>();
            
            for(int j = 0 ; j < friends.length ; j++){
                if(i == j) continue;
                fmap.put(friends[j], 0);
            }
            map.put(friends[i], fmap);
            ratioMap.put(friends[i], 0);
        }
        
        for(int i = 0 ; i < gifts.length ; i++){
            String[] tmp = gifts[i].split(" ");
            String giver = tmp[0];
            String reciever = tmp[1];
            
            map.get(reciever).replace(giver, map.get(reciever).get(giver) + 1);
            
            ratioMap.replace(giver, ratioMap.get(giver) + 1);
            ratioMap.replace(reciever, ratioMap.get(reciever) - 1);
        }
        for(String key : ratioMap.keySet()){
            System.out.println(key + " " + ratioMap.get(key));
        }
        for(int i = 0 ; i < friends.length ; i++){
            int total = 0;
            String rname = friends[i];
            Map<String, Integer> fmap = map.get(rname);
            
            for(String name : fmap.keySet()){
                int rnum = map.get(name).get(rname);
                if(rnum > map.get(rname).get(name)){
                    total++;
                }else if(rnum == map.get(rname).get(name)){
                    int rratio = ratioMap.get(rname);
                    int gratio = ratioMap.get(name);
                    
                    if(gratio < rratio) total++;
                }
            }
            answer = Math.max(total, answer);
        }
        
        
        return answer;
    }
}