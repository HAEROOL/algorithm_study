class Solution {
    static boolean[] v;
    static int answer;
    static int[][] dungeons;
    static void dfs(int clear, int piro){
        // System.out.println(clear);
        answer = Math.max(clear, answer);
        
        for(int i = 0 ; i < dungeons.length ; i++){
            int minpiro = dungeons[i][0];
            int cost = dungeons[i][1];
            if(piro >= minpiro && !v[i]){
                v[i] = true;
                dfs(clear + 1, piro - cost);
                v[i] = false;
            }
        }
    }
    public int solution(int k, int[][] dungeons) {
        answer = 0;
        this.dungeons = dungeons;
        v = new boolean[dungeons.length];
        dfs(0, k);
        return answer;
    }
}