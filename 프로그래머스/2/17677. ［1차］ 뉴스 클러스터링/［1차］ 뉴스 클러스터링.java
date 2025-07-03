import java.util.*;

class Solution {
    public int solution(String str1, String str2) {
        List<String> A = new ArrayList<>();
        for(int i = 0 ; i < str1.length() - 1 ; i++){
            String str = str1.substring(i, i+2);
            if(str.matches("[a-zA-Z]{2}"))
                A.add(str.toLowerCase());
        }
        
        List<String> B = new ArrayList<>();
        for(int i = 0 ; i < str2.length() - 1 ; i++){
            String str = str2.substring(i, i+2);
            if(str.matches("[a-zA-Z]{2}"))
                B.add(str.toLowerCase());
        }
        int inter = 0;
        for(String e : A){
            if(B.contains(e)){
                inter++;
                B.remove(e);
            }
        }
        int union = A.size() + B.size();
        if(A.size() == 0 && B.size() == 0) return 65536;
        if(inter == union) return 65536;
        // System.out.println();
        float answer = (float)inter / (float)union * 65536;
        return (int)answer;
    }
}