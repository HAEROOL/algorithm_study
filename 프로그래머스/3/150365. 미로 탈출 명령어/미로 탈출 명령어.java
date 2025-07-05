import java.util.*;
class Solution {
    static int[] dx = {1, 0, 0, -1};
    static int[] dy = {0, -1, 1, 0};
    static String[] dcmd = {"d","l","r","u"};
    static int R, C;
    static String answer = "impossible";
    static int K, N, M;
    // static List<String> ans = new ArrayList<>();
    static void dfs(int x, int y, String cmd){
        if(x == R && y == C){
            if(cmd.length() == K){
                answer = cmd;
                // ans.add(cmd);
                return;    
            }
        }
        if(cmd.length() > K) return;
        if(cmd.length() + Math.abs(R - x) + Math.abs(C - y) > K) return;
        if((K - cmd.length() + Math.abs(R - x) + Math.abs(C - y)) % 2 != 0) return;
        if(!answer.equals("impossible")) return;
        // if(cmd.length() + Math.abs(R - x) + Math.abs(C - y) > K) return;
        for(int i = 0 ; i < 4 ; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];
            String ncmd = cmd + dcmd[i];
            if(0 <= nx && nx < N && 0 <= ny && ny < M){
                dfs(nx, ny, ncmd);
            }
        }
    }
    public String solution(int n, int m, int sx, int sy, int r, int c, int k) {
        int[][] map = new int[n][m];
        R = r - 1;
        C = c - 1;
        K = k;
        N = n;
        M = m;
        answer = "impossible";
        dfs(sx - 1, sy - 1, "");
        
        // System.out.println(ans);
        // Collections.sort(ans);
        return answer;
    }
}