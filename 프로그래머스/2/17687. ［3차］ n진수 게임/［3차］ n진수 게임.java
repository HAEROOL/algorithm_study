class Solution {
    public String solution(int n, int t, int m, int p) {
        String answer = "";
        int turn = 0;
        int person = 0;
        while(answer.length() <= t){
            String num = Integer.toString(turn++, n);
            for(int i = 0 ; i < num.length() ; i++){
                // System.out.println(num);
                if(person == p - 1) answer += (num.charAt(i) + "").toUpperCase();
                person = (person + 1) % m;
            }
        }
        // System.out.println(answer);
        return answer.substring(0, t);
    }
}