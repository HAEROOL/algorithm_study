import java.util.*;

class Solution {
    public int solution(int[] topping) {
        int answer = 0;
        if(topping.length == 1) return 0;
        Map<Integer, Integer> a = new HashMap<Integer, Integer>();
        Map<Integer, Integer> b = new HashMap<Integer, Integer>();
        int acnt = 1;
        int bcnt = 0;
        a.put(topping[0], 1);
        for(int i = 1 ; i < topping.length ; i++){
            if(b.containsKey(topping[i])){
                b.put(topping[i], b.get(topping[i]) + 1);
            }else{
                b.put(topping[i], 1);
                bcnt++;
            }
        }

        for(int i = 1 ; i < topping.length - 1 ; i++){
            int top = topping[i];
            b.put(top, b.get(top) - 1);
            if(b.get(top) == 0) bcnt--;
            if(a.containsKey(top)){
                a.put(top, a.get(top) + 1);
            }else{
                a.put(topping[i], 1);
                acnt++;
            }
            if(acnt == bcnt) answer++;
        }
        return answer;
    }
}