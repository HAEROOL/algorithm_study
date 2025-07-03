import java.util.*;

class Solution {
    static Map<String, Integer> map = new HashMap<>();
    static Set<String> set = new HashSet<>();
    public int solution(String s) {
        map.put("zero", 0);
        map.put("one", 1);
        map.put("two", 2);
        map.put("three", 3);
        map.put("four", 4);
        map.put("five", 5);
        map.put("six", 6);
        map.put("seven", 7);
        map.put("eight", 8);
        map.put("nine", 9);
        set.add("0");
        set.add("1");
        set.add("2");
        set.add("3");
        set.add("4");
        set.add("5");
        set.add("6");
        set.add("7");
        set.add("8");
        set.add("9");
        String answer = "";
        String[] strs = s.split("");
        String str = "";
        for(int i = 0 ; i < strs.length ; i++){
            if(set.contains(strs[i])){
                answer += Integer.parseInt(strs[i]);
                continue;
            }
            str += strs[i];
            if(map.containsKey(str)){
                answer += map.get(str);
                str = "";
            }
        }
        return Integer.parseInt(answer);
    }
}