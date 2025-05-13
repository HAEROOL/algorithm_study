import java.util.*;

class Solution {
    static Map<String, String> memberMap;
    static Map<String, Integer> memberAmount;
    static void dfs(String member, int cost){
        String parent = memberMap.get(member);
        int total = cost - (int)(cost * 0.1);
        if(cost == 0) return;
        if(member.equals(parent)){
            memberAmount.put(member, memberAmount.get(member) + total);
            return;
        }
        memberAmount.put(member, memberAmount.get(member) + total);
        dfs(parent, (int)(cost * 0.1));
    }
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        int[] answer = new int[enroll.length];
        memberMap = new HashMap<String,String>();
        memberAmount = new HashMap<String,Integer>();
        for(int i = 0 ; i < enroll.length ; i++){
            String member = enroll[i];
            String parent = referral[i];
            if(parent.equals("-")){
                memberMap.put(member, member);
                memberAmount.put(member, 0);
            }else{
                memberMap.put(member, parent);
                memberAmount.put(member, 0);
            }
        }

        for(int i = 0 ; i < seller.length ; i++){
            dfs(seller[i], amount[i] * 100);
        }

        for(int i = 0 ; i < enroll.length ; i++){
            answer[i] = memberAmount.get(enroll[i]);
        }
        return answer;
    }
}