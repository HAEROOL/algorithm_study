class Solution {
    static int N, M;
    static int answer;
    static int[][][] dp;
    static int[][] map;
    // 0: 하(남), 1: 우(동), 2: 상(북), 3: 좌(서)
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    static void dfs(int x, int y, int total, int ex) {
        // [수정] 첫 출발점(0,0)이 아닐 때만 기존 dp 값과 비교하여 가지치기 (인덱스 에러 방지)
        if (x != 0 || y != 0) {
            if (total >= dp[x][y][ex]) {
                return; 
            }
            dp[x][y][ex] = total;
        }
        
        // 목적지 도달 시 정답 업데이트 후 종료
        if (x == N - 1 && y == M - 1) {
            answer = Math.min(answer, total);
            return;
        }

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (0 <= nx && nx < N && 0 <= ny && ny < M && map[nx][ny] == 0) {
                int cost = 100;
                
                // 첫 출발이 아닐 때만 방향을 비교해서 코너 비용(500원) 추가
                if (ex != -1) { 
                    if ((ex == 1 || ex == 3) && (i == 0 || i == 2)) cost += 500;
                    else if ((ex == 0 || ex == 2) && (i == 1 || i == 3)) cost += 500;
                }

                dfs(nx, ny, total + cost, i);
            }
        }
    }

    public int solution(int[][] board) {
        answer = Integer.MAX_VALUE;
        N = board.length;
        M = board[0].length;
        map = board;
        dp = new int[N][M][4];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                for (int k = 0; k < 4; k++) {
                    dp[i][j][k] = Integer.MAX_VALUE;    
                }
            }
        }

        // 시작점 (0,0)은 이전 방향이 없으므로 ex 자리에 -1을 넣어 안전하게 출발합니다.
        dfs(0, 0, 0, -1); 
        
        return answer;
    }
}