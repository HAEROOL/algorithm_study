import java.util.*;

class Solution {
    public int[] solution(String msg) {
        List<Integer> answer = new ArrayList<>();;
        Map<String, Integer> dict = new HashMap<>();
        for(int i = 1 ; i < 27 ; i++){
            int code = 64 + i;
            String ascii = String.valueOf((char)code);
            dict.put(ascii, i);
        }
        String[] msgs = msg.split("");
        String token = "";
        int codeVal = 27;
        int i = 0;
        while(i < msgs.length){
            String tmp = msgs[i];
            if(!dict.containsKey(token + tmp)){
                dict.put(token + tmp, codeVal);
                codeVal++;
                answer.add(dict.get(token));
                // System.out.println(i + " " + (token + msgs[i]) + " " + " added");
                token = tmp;
                i++;
                continue;
            }
            token += tmp;
            i++;
        }
        answer.add(dict.get(token));
        int[] ans = new int[answer.size()];
        for(int idx = 0 ; idx < ans.length ; idx++){
            ans[idx] = answer.get(idx);
        }
        return ans;
    }
}