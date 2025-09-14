import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        Map<String, Set<String>> users = new HashMap<>();
        Map<String, Set<String>> rusers = new HashMap<>();
        for(String id : id_list){
            users.put(id, new HashSet<String>());
            rusers.put(id, new HashSet<String>());
        }
        
        for(String r : report){
            String[] res = r.split(" ");
            
            users.get(res[1]).add(res[0]);
            rusers.get(res[0]).add(res[1]);
        }
        
        for(String user : users.keySet()){
            if(users.get(user).size() >= k){
                for(String u : users.get(user)){
                    for(int i = 0 ; i < id_list.length ; i++){
                        if(id_list[i].equals(u)){
                            answer[i]++;
                            break;
                        }
                    }
                }
            }
        }
        return answer;
    }
}