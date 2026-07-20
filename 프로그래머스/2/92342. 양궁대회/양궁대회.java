import java.util.*;

class Solution {
    static int N;
    static int[] info;
    static int[] answer;
    static int mx;
    static boolean isBetter(int[] sel, int[] ans){
        for(int i = sel.length - 1 ; i > -1 ; i--){
            if(sel[i] > ans[i]) return true;
            if(sel[i] < ans[i]) return false;
        }
        return false;
    }
    static void dfs(int idx, int total, int leftScore, int leftArrow, int[] sel, int pscore){
        if(idx == sel.length){
            if(pscore < total){
                sel[10] += leftArrow;
                if(mx == total - pscore){
                    if(isBetter(sel, answer)) answer = sel.clone();
                }else if(mx < total - pscore){
                    mx = total - pscore;
                    answer = sel.clone();
                }
                sel[10] -= leftArrow;;
            }
            return;
        }
        
        if(leftArrow >= info[idx] + 1){
            sel[idx] = info[idx] + 1;
            if(info[idx] > 0) pscore -= 10 - idx;
            dfs(idx + 1, total + (10 - idx), leftScore - (10 - idx), leftArrow - info[idx] - 1, sel, pscore);    
            if(info[idx] > 0) pscore += 10 - idx;
            sel[idx] = 0;
        }
        dfs(idx + 1, total, leftScore - (10 - idx), leftArrow, sel, pscore);
    }
    public int[] solution(int n, int[] info) {
        this.info = info;
        answer = new int[info.length];
        N = n;
        mx = -1;
        int pscore = 0;
        for(int i = 0 ; i < 11 ; i++){
            if(info[i] > 0){
                pscore += 10 - i;
            }
        }
        dfs(0, 0, 55, N, new int[11], pscore);
        if(mx == -1) answer = new int[]{-1};
        return answer;
    }
}