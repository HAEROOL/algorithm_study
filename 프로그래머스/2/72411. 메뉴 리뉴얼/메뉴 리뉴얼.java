import java.util.*;

class Solution {
    static Map<String, Integer> map;
    static int mxCnt;
    static void combination(int idx, int k, char[] sel, String order){
        if(idx == sel.length){
            String menu = new String(sel);
            map.put(menu, map.getOrDefault(menu, 0) + 1);
            mxCnt = Math.max(mxCnt, map.get(menu));
            return;
        }
        
        for(int i = k ; i < order.length() ; i++){
            sel[idx] = order.charAt(i);
            combination(idx + 1, i + 1, sel, order);
        }
    }
    public String[] solution(String[] orders, int[] course) {
        List<String> answer = new ArrayList<>();
        for(int size : course){
            map = new HashMap<>();
            mxCnt = 0;
            for(String order : orders){
                char[] charArr = order.toCharArray();
                Arrays.sort(charArr);
                String sortedOrder = new String(charArr);
                
                combination(0, 0, new char[size], sortedOrder);
            }
            for(String menu : map.keySet()){
                if(map.get(menu) == mxCnt && map.get(menu) > 1){
                    answer.add(menu);
                }
            }
        }
        Collections.sort(answer);
        
        return answer.toArray(new String[0]);
    }
}