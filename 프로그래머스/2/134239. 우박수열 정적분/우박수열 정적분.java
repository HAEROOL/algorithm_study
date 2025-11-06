import java.util.*;

class Solution {
    public double[] solution(int k, int[][] ranges) {
        double[] answer = new double[ranges.length];
        List<Integer> arr = new ArrayList<>();
        while(k > 1){
            arr.add(k);
            if(k % 2 == 0) k /= 2;
            else{
                k *= 3;
                k++;
            }
        }
        arr.add(1);
        double[] areas = new double[arr.size()];
        double[] sums = new double[arr.size()+ 1];
        for(int i = 0 ; i < arr.size() - 1 ; i++){
            int start = arr.get(i);
            int end = arr.get(i + 1);
            areas[i] = (double)((start + end) / 2.0);
        }
        sums[0] = 0;
        // System.out.println(arr);
        
        for(int i = 1 ; i < sums.length ; i++){
            sums[i] = sums[i - 1] + areas[i - 1];
        }
        // System.out.println(Arrays.toString(areas));
        // System.out.println(Arrays.toString(sums));
        for(int i = 0 ; i <  ranges.length ; i++){
            int start = ranges[i][0];
            int end = arr.size() + ranges[i][1] - 1;
            // System.out.println(start + " " + end);
            if(start >= sums.length || end >= sums.length || start > end){
                answer[i] = -1.0;
                continue;
            }
            for(int s = start ; s < end ; s++){
                answer[i] += areas[s];
            }
        }
        
        
        
        return answer;
    }
}