import java.util.*;
class Solution {
    public int[] solution(String s) {
        List<Integer> answer = new ArrayList<>();
        s = s.replace("{{", "").replace("}}", "");
        String[] strs = s.split("\\},\\{");
        Arrays.sort(strs, (a,b) -> a.length() - b.length());
        Set<Integer> set = new HashSet<>();
        for(String str : strs){
            String[] tmp = str.split(",");
            int[] nums = new int[tmp.length];
            for(int i = 0 ; i < nums.length ; i++){
                nums[i] = Integer.parseInt(tmp[i]);
            }
            for(int num : nums){
                if(set.contains(num)) continue;
                set.add(num);
                answer.add(num);
            }
            
        }
        int[] ans = new int[answer.size()];
        for(int i = 0 ; i < answer.size() ; i++){
            ans[i] = answer.get(i);
        }
        return ans;
    }
}