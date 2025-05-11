import java.util.*;

class Solution {
    public int solution(int[] a) {
        int answer = 0;
        int[] lmn = new int[a.length];
        int[] rmn = new int[a.length];
        lmn[0] = a[0];
        rmn[a.length - 1] = a[a.length - 1];
        for(int i = 1 ; i < a.length ; i++){
            lmn[i] = Math.min(lmn[i - 1], a[i]);
        }
        for(int i = a.length - 2 ; i > -1 ; i--){
            rmn[i] = Math.min(a[i], rmn[i + 1]);
        }
        answer = 2;
        if(a.length <= 2) answer = a.length;
        // System.out.println(Arrays.toString(lmn));
        // System.out.println(Arrays.toString(rmn));
        for(int i = 1 ; i < a.length - 1; i++){
            boolean x = lmn[i - 1] < a[i];
            boolean y = rmn[i + 1] < a[i];
            if(x && y) continue;
            answer++;
            
        }
        return answer;
    }
}