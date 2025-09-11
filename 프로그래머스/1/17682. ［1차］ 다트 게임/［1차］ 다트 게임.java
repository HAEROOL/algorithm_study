import java.util.*;

class Solution {
    public int solution(String dartResult) {
        int answer = 0;
        String[] tokens = dartResult.split("");
        Stack<Integer> s = new Stack<>();
        
        int tmp = 0;
        
        for(int i = 0 ; i < tokens.length ; i++){
            String tkn = tokens[i];
            
            if(tkn.equals("S")){
                s.push(tmp);
                tmp = 0;
            }else if(tkn.equals("D")){
                s.push(tmp * tmp);
                tmp = 0;
            }else if(tkn.equals("T")){
                s.push(tmp * tmp * tmp);
                tmp = 0;
            }else if(tkn.equals("*")){
                if(s.size() > 1){
                    int ex = s.pop();
                    int ex2 = s.pop();
                    s.push(ex2 * 2);   
                    s.push(ex * 2);
                     
                }else{
                    int ex = s.pop();
                    s.push(ex * 2);
                }
                
            }else if(tkn.equals("#")){
                int ex = s.pop();
                s.push(ex * -1);
            }else{
                tmp = Integer.parseInt(tmp + tkn);
            }
            
        }
        while(!s.isEmpty()){
            int a = s.pop();
            // System.out.println(a);  
            answer += a;
        }
        return answer;
    }
}