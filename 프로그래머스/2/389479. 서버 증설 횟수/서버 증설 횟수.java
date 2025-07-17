import java.util.*;

class Solution {
    public int solution(int[] players, int m, int k) {
        int answer = 0;
        int[] time = new int[24 + k];
        Arrays.fill(time, 1);
        for(int i = 0 ; i < 24 ; i++){
            int p = players[i];
            if(p >= m * time[i]){
                int cnt = (p - (m * time[i]) + 1) / m;
                if((p - (m * time[i]) + 1) % m > 0) cnt++;
                // System.out.println(p - (m * time[i]) + 1);
                // System.out.println("시각 : " + i + " / 이용자 수 : " + p + " / 총 서버 수 : " + time[i] + " / 증설할 서버 수"+ cnt);
                answer += cnt;
                for(int j = i ; j < i + k ; j++){
                    time[j] += cnt;
                }
            }
        }
        // System.out.println(Arrays.toString(time));
        return answer;
    }
}