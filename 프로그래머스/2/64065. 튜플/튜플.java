import java.util.*;
class Solution {
    public int[] solution(String s) {
        
        s = s.replace("{{", "").replace("}}", "");
        String[] tmp = s.split("\\},\\{");
        Arrays.sort(tmp, (a, b) -> a.length() - b.length());
        int[] ans = new int[tmp.length];
        Set<String> set = new HashSet<>();
        for(int i = 0 ; i < tmp.length ; i++){
            String[] token = tmp[i].split(",");
            for(String t : token){
                if(set.contains(t)) continue;
                ans[i] = Integer.parseInt(t);
                set.add(t);
            }
        }
        return ans;
    }
}