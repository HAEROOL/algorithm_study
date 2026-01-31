import java.util.*;

class Solution {
    public int solution(String str1, String str2) {
        List<String> A = new ArrayList<>();
        List<String> B = new ArrayList<>();
        
        for(int i = 0 ; i < str1.length() - 1 ; i++){
            String str = str1.substring(i, i + 2);
            if(str.matches("[a-zA-Z]{2}")){
                A.add(str.toLowerCase());
            }
        }
        for(int i = 0 ; i < str2.length() - 1 ; i++){
            String str = str2.substring(i, i + 2);
            if(str.matches("[a-zA-Z]{2}")){
                B.add(str.toLowerCase());
            }
        }
        
        int inter = 0;
        for(int i = 0 ; i < A.size() ; i++){
            String s = A.get(i);
            if(B.contains(s)){
                B.remove(s);
                inter++;
            }
        }
        
        int union = A.size() + B.size();
        
        if(A.size() == 0 && B.size() == 0) return 65536;
        if(inter == union) return 65536;
        float answer = (float)inter / (float)union * 65536;
        
        return (int)answer;
    }
}