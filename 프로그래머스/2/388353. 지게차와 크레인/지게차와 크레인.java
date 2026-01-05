import java.util.*;

class Solution {
    int[] dx = {-1, 1, 0, 0};
    int[] dy = {0, 0, -1, 1};
    int n, m;

    public int solution(String[] storage, String[] requests) {
        n = storage.length;
        m = storage[0].length();
        char[][] board = new char[n + 2][m + 2];

        // 테두리를 포함한 보드 초기화
        for (int i = 0; i < n + 2; i++) {
            Arrays.fill(board[i], '.');
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                board[i + 1][j + 1] = storage[i].charAt(j);
            }
        }

        for (String req : requests) {
            char target = req.charAt(0);
            List<int[]> toRemove = new ArrayList<>();

            if (req.length() == 1) {
                // 외부와 연결된 타겟만 찾기 위해 BFS 사용
                boolean[][] accessible = getAccessible(board);
                for (int i = 1; i <= n; i++) {
                    for (int j = 1; j <= m; j++) {
                        if (board[i][j] == target) {
                            for (int k = 0; k < 4; k++) {
                                if (accessible[i + dx[k]][j + dy[k]]) {
                                    toRemove.add(new int[]{i, j});
                                    break;
                                }
                            }
                        }
                    }
                }
            } else {
                // 2글자 요청: 모든 타겟 제거
                for (int i = 1; i <= n; i++) {
                    for (int j = 1; j <= m; j++) {
                        if (board[i][j] == target) {
                            toRemove.add(new int[]{i, j});
                        }
                    }
                }
            }

            // 한 번에 제거 처리
            for (int[] pos : toRemove) {
                board[pos[0]][pos[1]] = '.';
            }
        }

        // 남은 컨테이너 개수 세기
        int answer = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (board[i][j] != '.') answer++;
            }
        }
        return answer;
    }

    // (0,0)부터 시작하여 외부에서 접근 가능한 빈 공간을 찾는 BFS
    private boolean[][] getAccessible(char[][] board) {
        int rows = board.length;
        int cols = board[0].length;
        boolean[][] visited = new boolean[rows][cols];
        Queue<int[]> q = new LinkedList<>();

        q.add(new int[]{0, 0});
        visited[0][0] = true;

        while (!q.isEmpty()) {
            int[] curr = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = curr[0] + dx[i];
                int ny = curr[1] + dy[i];

                if (nx >= 0 && nx < rows && ny >= 0 && ny < cols) {
                    if (!visited[nx][ny] && board[nx][ny] == '.') {
                        visited[nx][ny] = true;
                        q.add(new int[]{nx, ny});
                    }
                }
            }
        }
        return visited;
    }
}