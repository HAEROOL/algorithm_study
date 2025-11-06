class Solution {
    // a에서 b를 거쳐 c를 간다
    static void hanoi(int from, int to, int cnt){
        if(cnt == 1){
            answer[idx][0] = from;
            answer[idx++][1] = to;
            return;
        }
        hanoi(from, 6 - (from + to), cnt - 1);
        hanoi(from, to, 1);
        hanoi(6 - (from + to), to, cnt - 1);
        
    }
    static int[][] answer;
    static int idx = 0;
    public int[][] solution(int n) {
        answer = new int[(int) Math.pow(2,n)-1][2];
        hanoi(1, 3, n);
        return answer;
    }
}