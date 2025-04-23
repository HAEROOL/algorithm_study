import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int N = Integer.parseInt(st.nextToken());  // 가로 칸 수
    int M = Integer.parseInt(st.nextToken());  // 세로 칸 수
    boolean[][] blockedRight = new boolean[M+1][N];
    boolean[][] blockedDown  = new boolean[M][N+1];

    int K = Integer.parseInt(br.readLine());
    for (int i = 0; i < K; i++) {
      st = new StringTokenizer(br.readLine());
      int x1 = Integer.parseInt(st.nextToken());
      int y1 = Integer.parseInt(st.nextToken());
      int x2 = Integer.parseInt(st.nextToken());
      int y2 = Integer.parseInt(st.nextToken());

      if (y1 == y2) {
        int x = Math.min(x1, x2);
        blockedRight[y1][x] = true;
      } else {
        int y = Math.min(y1, y2);
        blockedDown[y][x1] = true;
      }
    }

    long[][] dp = new long[M+1][N+1];
    dp[0][0] = 1;
    for (int y = 0; y <= M; y++) {
      for (int x = 0; x <= N; x++) {
        if (y > 0 && !blockedDown[y-1][x]) {
          dp[y][x] += dp[y-1][x];
        }
        if (x > 0 && !blockedRight[y][x-1]) {
          dp[y][x] += dp[y][x-1];
        }
      }
    }

    System.out.println(dp[M][N]);
  }
}