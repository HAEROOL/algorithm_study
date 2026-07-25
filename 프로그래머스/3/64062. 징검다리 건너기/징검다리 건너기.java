class Solution {
    public int solution(int[] stones, int k) {
        int answer = 0;
        
        int left = 0;
        int right = -1;
        for(int i : stones) right = Math.max(i, right);
        
        while(left <= right){
            int mid = (left + right) / 2;
            
            int cnt = 0;
            
            for(int i = 0 ; i < stones.length ; i++){
                if(stones[i] < mid) cnt++;
                else cnt = 0;
                if(cnt == k) break;
            }
            
            if(cnt == k){
                right = mid - 1;
            }else{
                answer = mid;
                left = mid + 1;
            }
        }
        return answer;
    }
}