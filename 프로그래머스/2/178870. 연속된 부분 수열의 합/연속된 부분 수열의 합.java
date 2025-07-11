class Solution {
    public int[] solution(int[] sequence, int k) {
        int[] answer = new int[]{0, sequence.length - 1};
        int start = 0;
        int end = 0;
        int total = sequence[0];
        while(start <= end && start < sequence.length && end < sequence.length){
            if(total >= k){
                if(total == k && answer[1] - answer[0] > end - start){
                    // System.out.println(start + " " + end);
                    answer[0] = start;
                    answer[1] = end;
                }
                total -= sequence[start];
                start++;
            }else if(total < k){
                end++;
                if(end == sequence.length) break;
                total += sequence[end];
            }
        }
        return answer;
    }
}