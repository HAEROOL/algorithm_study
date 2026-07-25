import java.util.*;

class Solution {
    static int[] info;
    static boolean[] v;
    static void dfs(int now, List<Integer> tmp, int sheep, int wolf){
        List<Integer> nexts = new ArrayList<>(tmp);
        for(int i : tree[now]){
            if(!v[i]) nexts.add(i);
        }
        
        for(int next : nexts){
            if(!v[next] && info[next] == 0){
                v[next] = true;
                dfs(next, nexts, sheep + 1, wolf);
                v[next] = false;
            }else if(!v[next] && info[next] == 1){
                if(wolf + 1 < sheep){
                    v[next] = true;
                    dfs(next, nexts, sheep, wolf + 1);
                    v[next] = false;
                }
            }
        }
        answer = Math.max(answer, sheep);
    }
    static ArrayList<Integer>[] tree;
    static int answer;
    public int solution(int[] info, int[][] edges) {
        answer = 0;
        this.info = info;
        tree = new ArrayList[info.length];
        v = new boolean[info.length];
        for(int i = 0 ; i < info.length ; i++) tree[i] = new ArrayList<Integer>();
        for(int[] e : edges){
            tree[e[0]].add(e[1]);
            tree[e[1]].add(e[0]);
        }
        v[0] = true;
        dfs(0, new ArrayList<>(), 1, 0);
        return answer;
    }
}