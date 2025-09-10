import java.util.*;

class Solution {
    public String parseString(int num1, int num2, int n){
        String tmp = Integer.toBinaryString(num1 | num2);
        while(tmp.length() < n){
            tmp = "0" + tmp;
        }
        String res = "";
        String[] tokens = tmp.split("");
        // System.out.println(Arrays.toString(tokens));
        for(String s : tokens){
            if(s.equals("1")){
                res += "#"; 
            }else{
                res += " ";
            }
        }
        return res;
    }
    public String[] solution(int n, int[] arr1, int[] arr2) {
        // 문자열 파싱
        String[] answer = new String[n];
        for(int i = 0 ; i < n ; i++){
            answer[i] = parseString(arr1[i], arr2[i], n);
        }
        return answer;
    }
}