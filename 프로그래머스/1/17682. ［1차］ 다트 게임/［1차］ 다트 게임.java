import java.util.*;

class Solution {
    public int solution(String dartResult) {
        int answer = 0;
        String[] strs = dartResult.split("");
        List<Integer> nums = new ArrayList<>();
        String token = "";
        for(int i = 0 ; i < strs.length ; i++){
            if(strs[i].equals("S") || strs[i].equals("D") || strs[i].equals("T")){
                int n = Integer.parseInt(token);
                if(strs[i].equals("D")){
                    n = (int)Math.pow(n, 2);
                }else if(strs[i].equals("T")){
                    n = (int)Math.pow(n, 3);
                }
                nums.add(n);
                token = "";
            }else if(strs[i].equals("#") || strs[i].equals("*")){
                if(strs[i].equals("#")){
                    int cur = nums.get(nums.size() - 1) * -1;
                    nums.remove(nums.size() - 1);
                    nums.add(cur);                             
                }else if(strs[i].equals("*")){
                    int cur = nums.get(nums.size() - 1) * 2;
                    int prev = 0;
                    if(nums.size() > 1){
                        prev = nums.get(nums.size() - 2) * 2;
                    }
                    nums.remove(nums.size() - 1);
                    if(prev != 0) {
                        nums.remove(nums.size() - 1);
                        nums.add(prev);
                    }
                    nums.add(cur);
                }
            }else{
                token += strs[i];
            }
        }
        // System.out.println(nums);
        for(int i : nums){
            answer += i;
        }
        return answer;
    }
}