import java.util.*;

class Solution {
    Map<String, String> map = new HashMap<>();
    public int solution(String s) {
        map.put("zero", "0");
        map.put("one", "1");
        map.put("two", "2");
        map.put("three", "3");
        map.put("four", "4");
        map.put("five", "5");
        map.put("six", "6");
        map.put("seven", "7");
        map.put("eight", "8");
        map.put("nine", "9");
        String[] strs = s.split("");
        String answer = "";
        String token = "";
        for(int i = 0 ; i < strs.length ; i++){
            if(map.containsValue(strs[i])){
                System.out.println(strs[i]);
                answer += strs[i];
            }else{
                token += strs[i];
                if(map.containsKey(token)){
                    answer += map.get(token);
                    token = "";
                }
            }
        }
        // System.out.println(answer);
        return Integer.parseInt(answer);
        // return 123;
    }
}