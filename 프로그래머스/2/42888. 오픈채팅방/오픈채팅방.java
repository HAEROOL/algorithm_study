import java.util.*;

class Solution {
    public String[] solution(String[] record) {
        
        Map<String,String> map = new HashMap<>();
        int size = record.length;
        for(String reco : record){
            String[] tmp = reco.split(" ");
            if(tmp[0].equals("Enter")){
                map.put(tmp[1], tmp[2]);
            }else if(tmp[0].equals("Change")){
                map.replace(tmp[1], tmp[2]);
            }
        }
        
        List<String> answer = new ArrayList<String>();
        for(int i = 0 ; i < record.length ; i++){
            String[] tmp = record[i].split(" ");
            if(tmp[0].equals("Enter")){
                answer.add(map.get(tmp[1]) + "님이 들어왔습니다.");
            }else if(tmp[0].equals("Leave")){
                answer.add(map.get(tmp[1]) + "님이 나갔습니다.");
            }
        }
        String[] ans = new String[answer.size()];
        for(int i = 0 ; i < ans.length ; i++){
            ans[i] = answer.get(i);
        }
        return ans;
    }
}