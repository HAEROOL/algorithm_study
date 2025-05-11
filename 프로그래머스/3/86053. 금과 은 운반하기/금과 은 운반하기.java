class Solution {
    public long solution(int a, int b, int[] g, int[] s, int[] w, int[] t) {
        long answer = -1;
        long start = 0;
        long end = 400000000000000L;
        while(start < end){
            long mid = (start + end) / 2;
            long totalGold = 0;
            long totalSilver = 0;
            long total = 0;
            for(int i = 0 ; i < g.length ; i++){
                long cnt = mid / (t[i] * 2);
                if((mid % (t[i] * 2)) >= t[i]) cnt++;
                long tmp = Math.min(cnt * w[i], g[i] + s[i]);
                total += tmp;
                totalGold += Math.min(tmp, g[i]);
                totalSilver += Math.min(tmp, s[i]);
                
            }
            System.out.println(start + " " + end + " " + mid + " " + total + " "+ totalGold + " "+ totalSilver + " ");
            if(totalGold >= a && totalSilver >= b && total >= a + b){
                end = mid;
                answer = mid;
            }else{
                start = mid + 1;
                answer = mid + 1;
            }
        }
        return answer;
    }
}