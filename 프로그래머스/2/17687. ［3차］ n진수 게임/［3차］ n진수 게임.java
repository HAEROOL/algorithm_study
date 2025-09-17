class Solution {
    public String solution(int n, int t, int m, int p) {
        String answer = "";
        int start = 0;
        int turn = 0;
        // System.out.println(Integer.toString(, n));
        while(answer.length() < t){
            String num = Integer.toString(start, n);
            for(int i = 0 ; i < num.length() ; i++){
                if((turn) % m == p - 1){
                    answer += ((num.charAt(i)+"").toUpperCase());
                }
                if(answer.length() == t){
                    break;
                }
                turn++;
            }
            start++;
            
        }
        return answer;
    }
}