import java.util.*;

class Solution {
    public int[] solution(int N, int[] stages) {
        double[][] tmp = new double[N][2];
        for(int i = 0 ; i < N ; i++){
            int stage = i + 1;
            int notClearCount = 0;
            int totalCount = 0;
            for(int j = 0 ; j < stages.length ; j++){
                if(stages[j] == stage){
                    notClearCount++;
                    totalCount++;
                }else if(stages[j] > stage){
                    totalCount++;
                }
            }
            double rate = totalCount != 0 ? (double)notClearCount / (double)totalCount : 0;
            // System.out.println(stage + " " + totalCount + " " + notClearCount + " " + rate);
            tmp[i] = new double[]{stage, rate};
        }
        Arrays.sort(tmp, (a, b) -> {
            if(a[1] == b[1]){
                return Double.compare(a[0], b[0]);
            }
            return Double.compare(b[1], a[1]);
        });
        // for(double[] row : tmp){
        //     System.out.println(Arrays.toString(row));
        // }
        int[] answer = new int[N];
        for(int i = 0 ; i < N ; i++){
            answer[i] = (int)tmp[i][0];
        }
        return answer;
    }
}