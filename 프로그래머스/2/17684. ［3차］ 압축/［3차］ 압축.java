import java.util.*;

class Solution {
    public int[] solution(String msg) {
        int[] answer = {};
        List<Integer> list = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        for(int i = 1 ; i < 27 ; i++){
            int code = 64 + i;
            String ascii = String.valueOf((char)code);
            map.put(ascii, i);
        }
        
        String[] arr = msg.split("");
        
        int pos = 1;
        int id = 27;
        String token = arr[0];
        while(pos < arr.length){
            if(map.containsKey(token + arr[pos])){
                token += arr[pos];    
            }else{
                list.add(map.get(token));
                map.put(token + arr[pos], id++);
                token = arr[pos];
            }
            pos++;
        }
        list.add(map.get(token));
        
        answer = new int[list.size()];
        for(int i = 0 ; i < answer.length ; i++) answer[i] = list.get(i);
        return answer;
    }
}