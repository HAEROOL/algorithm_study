import java.util.*;
class Solution {

    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        String[] strs = skill.split("");
        
        Set<String> set = new HashSet<>();
        for(String str : strs){
            set.add(str);
        }
        
        for(String st : skill_trees){
            String[] sk = st.split("");
            Deque<String> q = new ArrayDeque<>();
            for(String str : strs){
                q.offer(str);
            }
            boolean isPossible = true;
            for(int i = 0 ; i < sk.length ; i++){
                if(set.contains(sk[i])){
                    if(q.peek().equals(sk[i])){
                        q.poll();    
                    }else{
                        isPossible = false;
                        break;
                    }
                }
            }
            if(isPossible){
                answer++;
                // System.out.println(st); 
            } 
        }
        
        return answer;
    }
}