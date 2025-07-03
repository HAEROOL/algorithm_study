import java.util.*;

class Solution {
    static String[] convertCode(int n, int num){
        String[] res = new String[n];
        Arrays.fill(res, " ");
        int base = num;
        int point = n - 1;
        // System.out.println(num);
        while(base >= 1){
            if(base % 2 == 1){
                res[point] = "#";
            }else{
                res[point] = " ";
            }
            point--;
            base /= 2;
        }
        return res;
    }
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        String[][] map1 = new String[n][n];
        String[][] map2 = new String[n][n];
        String[][] map3 = new String[n][n];
        for(int i = 0 ; i < arr1.length ; i++){
            int tmp = arr1[i] | arr2[i];
            String res = String.join("",convertCode(n, tmp));
            answer[i] = res;
            
        }
        return answer;
    }
}