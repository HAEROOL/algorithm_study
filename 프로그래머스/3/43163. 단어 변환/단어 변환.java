import java.util.*;

class Solution {
    static int getDiffLen(String a, String b){
        int cnt = 0;
        for(int i = 0 ; i < a.length() ; i++){
            if(a.charAt(i) != b.charAt(i)){
                cnt++;
            }
        }
        return cnt;
    }
    static void dfs(boolean[]v, int total, String now){
        if(now.equals(target)){
            answer = Math.min(total, answer);
            return;
        }
        if(total == words.length) return;
        for(int i = 0 ; i < words.length ; i++){
            if(!v[i] && getDiffLen(now, words[i]) == 1){
                v[i] = true;
                dfs(v, total + 1, words[i]);
                v[i] = false;
            }
        }
    }
    static int answer;
    static String target;
    static String[] words;
    public int solution(String begin, String target, String[] words) {
        answer = Integer.MAX_VALUE;
        this.target = target;
        this.words = words;
        dfs(new boolean[words.length], 0, begin);
        return answer == Integer.MAX_VALUE ? 0 : answer;
    }
}