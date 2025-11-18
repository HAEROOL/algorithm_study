import java.util.*;

class Solution {
    static void combination(int idx, int[] sel, int k, int n){
        if(idx == sel.length){
            cal(sel);
            return;
        }
        
        if(k > n){
            return;
        }
        
        combination(idx, sel, k + 1, n);
        sel[idx] = k;
        combination(idx + 1, sel, k + 1, n);
    }
    static void cal(int[] sel){
        int cnt = 0;
        Set<Integer> set = new HashSet<>();
        for(int e : sel) set.add(e);
        for(int i = 0 ; i < q.length ; i++){
            int c = 0;
            for(int e : q[i]){
                if(set.contains(e)) c++;
            }
            if(c != ans[i]) return;
        }
        answer++;
    }
    static int answer = 0;
    static int[] ans;
    static int[][] q;
    public int solution(int n, int[][] q, int[] ans) {
        this.ans = ans;
        this.q = q;
        combination(0, new int[5], 1, n);
        return answer;
    }
}