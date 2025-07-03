class Solution {
    public String solution(int n, int t, int m, int p) {
        String answer = "";
        int start = 0;
        int turn = -1;
        while(answer.length() != t){
            String r = Integer.toString(start, n);
            String[] res = r.split("");
            // System.out.println(res);
            
            for(int i = 0 ; i < res.length ; i++){
                turn++;
                if(turn % m == (p - 1)){
                    answer += res[i];
                    if(answer.length() == t) return answer.toUpperCase();
                }
            }
            start++;;
        }
        return answer.toUpperCase();
    }
}