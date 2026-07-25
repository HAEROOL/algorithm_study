public class Solution {
    public long solution(int[][] land, int P, int Q) {
        long answer = Long.MAX_VALUE;
        long left = 0;
        long right = -1;
        for(int i = 0 ; i < land.length ; i++){
            for(int j = 0 ; j < land[0].length ; j++){
                right = Math.max(right, land[i][j]);
            }
        }
        
        while(left <= right){
            long mid = (left + right) / 2;
            long cost = 0;
            long cost2 = 0;
            for(int i = 0 ; i < land.length ; i++){
                for(int j = 0 ; j < land[0].length ; j++){
                    if(land[i][j] < mid) cost += (mid - land[i][j]) * P;
                    else if(land[i][j] > mid) cost += (land[i][j] - mid) * Q;
                    
                    if(land[i][j] < mid + 1) cost2 += (mid + 1 - land[i][j]) * P;
                    else if(land[i][j] > mid + 1) cost2 += (land[i][j] - (mid + 1)) * Q;
                }
            }
            
            if(cost > cost2){
                left = mid + 1;
                answer = Math.min(cost2, answer);
            }else{
                right = mid - 1;
                answer = Math.min(cost, answer);
            }
        }
        // System.out.println(left +"/" + right);
        return answer;
    }
}