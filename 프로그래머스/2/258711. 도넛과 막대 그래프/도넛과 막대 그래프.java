import java.util.*;

class Solution {
    static int[] inCount, outCount;
    public int[] solution(int[][] edges) {
        int[] answer = new int[4];
        int maxN = -1;
        for(int[] edge : edges){
            int from = edge[0];
            int to = edge[1];
            maxN = Math.max(from, Math.max(to, maxN));
        }
        inCount = new int[maxN + 1];
        outCount = new int[maxN + 1];
        for(int[] edge : edges){
            int from = edge[0];
            int to = edge[1];
            outCount[from]++;
            inCount[to]++;
        }
        int totalGraph = 0;
        for(int i = 1 ; i < maxN + 1 ; i++){
            if(inCount[i] == 0 && outCount[i] > 1){
                answer[0] = i;
                totalGraph = outCount[i];
                break;
            }
        }
        
        for(int i = 1 ; i < maxN + 1 ; i++){
            if(outCount[i] == 2 && inCount[i] >= 2) answer[3]++;
            if(outCount[i] == 0 && inCount[i] >= 1) answer[2]++;
        }
        answer[1] = totalGraph - (answer[2] + answer[3]);
        return answer;
    }
}