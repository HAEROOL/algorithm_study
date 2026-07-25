import java.util.*;

class Solution {
    // 상, 하, 좌, 우
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public int solution(int[][] board) {
        int N = board.length;

        // 1. 테두리 외곽을 1(벽)로 두르기 (OOB 조건문 완전히 제거용)
        int[][] map = new int[N + 2][N + 2];
        for (int[] row : map) Arrays.fill(row, 1);
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                map[i + 1][j + 1] = board[i][j];
            }
        }

        // 방문 및 거리 배열 [x][y][dir] (dir: 0-가로, 1-세로)
        int[][][] dist = new int[N + 2][N + 2][2];
        Deque<int[]> q = new ArrayDeque<>();

        // 시작점: (1, 1) 위치, 가로(0) 상태
        q.offer(new int[]{1, 1, 0});
        dist[1][1][0] = 1; // 이동 횟수 계산을 위해 1부터 시작 (나중에 -1)

        while (!q.isEmpty()) {
            int[] now = q.poll();
            int x = now[0];
            int y = now[1];
            int pos = now[2];

            // 도착 조건: 로봇의 두 칸 중 하나라도 (N, N)에 도달했을 때
            if ((pos == 0 && (x == N && y + 1 == N)) ||
                (pos == 1 && (x + 1 == N && y == N)) ||
                (x == N && y == N)) {
                return dist[x][y][pos] - 1;
            }

            // --------------------------------------------------
            // 1. 평행 이동 (상, 하, 좌, 우 4방향)
            // --------------------------------------------------
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (pos == 0) { // 가로 상태
                    if (map[nx][ny] == 0 && map[nx][ny + 1] == 0 && dist[nx][ny][0] == 0) {
                        dist[nx][ny][0] = dist[x][y][0] + 1;
                        q.offer(new int[]{nx, ny, 0});
                    }
                } else { // 세로 상태
                    if (map[nx][ny] == 0 && map[nx + 1][ny] == 0 && dist[nx][ny][1] == 0) {
                        dist[nx][ny][1] = dist[x][y][1] + 1;
                        q.offer(new int[]{nx, ny, 1});
                    }
                }
            }

            // --------------------------------------------------
            // 2. 회전 이동 (가로 <-> 세로)
            // --------------------------------------------------
            if (pos == 0) { // 현재 가로 상태 -> 세로 상태로 회전
                // 위쪽 2칸이 비어있는 경우 (위로 회전)
                if (map[x - 1][y] == 0 && map[x - 1][y + 1] == 0) {
                    if (dist[x - 1][y][1] == 0) {
                        dist[x - 1][y][1] = dist[x][y][0] + 1;
                        q.offer(new int[]{x - 1, y, 1});
                    }
                    if (dist[x - 1][y + 1][1] == 0) {
                        dist[x - 1][y + 1][1] = dist[x][y][0] + 1;
                        q.offer(new int[]{x - 1, y + 1, 1});
                    }
                }
                // 아래쪽 2칸이 비어있는 경우 (아래로 회전)
                if (map[x + 1][y] == 0 && map[x + 1][y + 1] == 0) {
                    if (dist[x][y][1] == 0) {
                        dist[x][y][1] = dist[x][y][0] + 1;
                        q.offer(new int[]{x, y, 1});
                    }
                    if (dist[x][y + 1][1] == 0) {
                        dist[x][y + 1][1] = dist[x][y][0] + 1;
                        q.offer(new int[]{x, y + 1, 1});
                    }
                }
            } else { // 현재 세로 상태 -> 가로 상태로 회전
                // 왼쪽 2칸이 비어있는 경우 (왼쪽으로 회전)
                if (map[x][y - 1] == 0 && map[x + 1][y - 1] == 0) {
                    if (dist[x][y - 1][0] == 0) {
                        dist[x][y - 1][0] = dist[x][y][1] + 1;
                        q.offer(new int[]{x, y - 1, 0});
                    }
                    if (dist[x + 1][y - 1][0] == 0) {
                        dist[x + 1][y - 1][0] = dist[x][y][1] + 1;
                        q.offer(new int[]{x + 1, y - 1, 0});
                    }
                }
                // 오른쪽 2칸이 비어있는 경우 (오른쪽으로 회전)
                if (map[x][y + 1] == 0 && map[x + 1][y + 1] == 0) {
                    if (dist[x][y][0] == 0) {
                        dist[x][y][0] = dist[x][y][1] + 1;
                        q.offer(new int[]{x, y, 0});
                    }
                    if (dist[x + 1][y][0] == 0) {
                        dist[x + 1][y][0] = dist[x][y][1] + 1;
                        q.offer(new int[]{x + 1, y, 0});
                    }
                }
            }
        }
        return 0;
    }
}