class Solution {
    public long solution(int k, int d) {
        long answer = 0;
        long dd = (long)Math.pow(d, 2);
        for(int i = 0 ; i < d + 1 ; i += k){
            long xx = (long) Math.pow(i, 2);
            
            long y = (long)Math.sqrt(dd - xx);
            answer += (y / (long)k) + 1;
            
        }
        return answer;
    }
}

