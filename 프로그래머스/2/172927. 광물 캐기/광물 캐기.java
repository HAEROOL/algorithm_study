class Solution {
    static int ans = Integer.MAX_VALUE;
    public void dfs(int[] picks, String[] minerals, int idx, int total, int totalPicks){
        if(totalPicks == 0 || idx >= minerals.length){
            ans = Math.min(total, ans);
            return;
        }
        
        for(int i = 0 ; i < 3 ; i++){
            if(picks[i] > 0){
                picks[i]--;
                int sum = 0;
                for(int j = idx ; j < idx + 5 ; j++){
                    if(j == minerals.length) {
                        break;
                    }
                    if(minerals[j].equals("diamond")){
                        sum += piros[i][0];
                    }else if(minerals[j].equals("iron")){
                        sum += piros[i][1];
                    }else{
                        sum += piros[i][2];
                    }
                }
                dfs(picks, minerals, idx + 5, total + sum, totalPicks - 1);
                picks[i]++;
            }
        }
    }
    static int[][] piros = new int[][]{
        {1, 1, 1},
        {5, 1, 1},
        {25, 5, 1}
    };
    public int solution(int[] picks, String[] minerals) {
        int answer = 0;
        int totalPicks = 0;
        for(int p : picks) totalPicks += p;
        dfs(picks, minerals, 0, 0, totalPicks);
        return ans;
    }
}