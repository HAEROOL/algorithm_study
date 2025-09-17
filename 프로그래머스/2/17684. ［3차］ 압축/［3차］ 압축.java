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
        String[] strs = msg.split("");
        String w = strs[0];
        int id = 27;
        for(int i = 1 ; i < strs.length ; i++ ){
            String c = strs[i];
            String wc = w + c;
            if(dict.containsKey(wc)){
                w = wc;
            }else{
                answer.add(dict.get(w));
                dict.put(wc, id++);
                w = c;
            }
        }
        answer.add(dict.get(w));
        int[] ans = new int[answer.size()];
        for(int i = 0 ; i < ans.length ; i++){
            ans[i] = answer.get(i);
        }
        return ans;
    }
}