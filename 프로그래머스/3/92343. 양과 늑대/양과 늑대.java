import java.util.*;

class Solution {
    static List<Integer>[] map;
    static int[] INFO;
    static int ans = 0;
    static boolean[] v;
    static void dfs(int now, List<Integer> candi, int wolf, int sheep){
        // System.out.println(now + " " + sheep + " " + wolf);
        List<Integer> tmp = new ArrayList<Integer>(candi);
        for(int n : map[now]){
            if(!v[n]) tmp.add(n);
        }
        for(int next : tmp){
            if(!v[next] && INFO[next] == 0){
                v[next] = true;
                dfs(next, tmp, wolf, sheep + 1);
                v[next] = false;
            }else if(!v[next] && INFO[next] == 1 && wolf + 1 < sheep){
                v[next] = false;
                dfs(next, tmp, wolf + 1, sheep);
                v[next] = false;
            }
        }
        ans = Math.max(ans, sheep);
    }
    public int solution(int[] info, int[][] edges) {
        int answer = 0;
        INFO = info;
        map = new ArrayList[info.length];
        v = new boolean[info.length];
        for(int i = 0 ; i < info.length ; i++){
            map[i] = new ArrayList<Integer>();
        }
        for(int[] nodes : edges){
            int from = nodes[0];
            int to = nodes[1];
            map[from].add(to);
            map[to].add(from);
        }

        int st = 0;
        INFO[0] = -1;
        dfs(0, new ArrayList<Integer>(), 0, 1);
        return ans;
    }
}