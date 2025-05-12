class Solution {
    public int solution(int[][] matrix_sizes) {
        int N = matrix_sizes.length;
        // dp[i][j]: i…j 구간 최소 곱셈 횟수
        int[][] dp = new int[N][N];
        // 1) i==j인 구간은 0으로 초기화(디폴트)
        // 2) 나머지는 충분히 큰 값
        final int INF = Integer.MAX_VALUE / 2;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (i != j) dp[i][j] = INF;
            }
        }

        // 3) 구간 길이 L = 2부터 N까지
        for (int L = 2; L <= N; L++) {
            for (int i = 0; i + L <= N; i++) {
                int j = i + L - 1;
                // i…j 구간을 분할할 k
                for (int k = i; k < j; k++) {
                    int cost = dp[i][k]
                             + dp[k+1][j]
                             + matrix_sizes[i][0]      // A_i 행 수
                             * matrix_sizes[k][1]      // A_k 열 수
                             * matrix_sizes[j][1];     // A_j 열 수
                    dp[i][j] = Math.min(dp[i][j], cost);
                }
            }
        }

        // 전체 체인(0…N-1)의 최소 곱셈 횟수
        return dp[0][N-1];
    }
}