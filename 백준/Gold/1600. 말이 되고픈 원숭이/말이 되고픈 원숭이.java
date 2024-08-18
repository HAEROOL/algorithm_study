import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Main {
  static int K, W, H;
  static int[][] board;
  static int[][][] visited;
  static int[] dx = {1, 0, -1, 0};
  static int[] dy = {0, 1, 0, -1};
  static int[] hdx = {-2, -1, 1, 2, 2, 1, -1, -2};
  static int[] hdy = {-1, -2, -2, -1, 1, 2, 2, 1};
  static int ans = Integer.MAX_VALUE;

  static void bfs(){
    Deque<int[]> q = new ArrayDeque<>();
    q.add(new int[]{0, 0, 0});
    visited[0][0][0] = 0;
    while(!q.isEmpty()){
      int[] coord = q.pop();
      int sx = coord[0];
      int sy = coord[1];
      int k = coord[2];
      if(sx == H - 1 && sy == W - 1){
        ans = Math.min(visited[k][sx][sy], ans);
        break;
      }
      if(k < K){
        for(int i = 0 ; i < 8 ; i++){
          int nx = sx + hdx[i];
          int ny = sy + hdy[i];
          if(0 <= nx && nx < H && 0 <= ny && ny < W && board[nx][ny] == 0){
            if(visited[k + 1][nx][ny] == 0){
              visited[k + 1][nx][ny] = visited[k][sx][sy] + 1;
              q.add(new int[]{nx, ny, k + 1});
            }
          }
        }
      }for(int i = 0 ; i < 4 ; i++){
          int nx = sx + dx[i];
          int ny = sy + dy[i];
          if(0 <= nx && nx < H && 0 <= ny && ny < W && board[nx][ny] == 0){
            if(visited[k][nx][ny] == 0){
              visited[k][nx][ny] = visited[k][sx][sy] + 1;
              q.add(new int[]{nx, ny, k});
            }
          }
        }

    }




  }
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    K = Integer.parseInt(br.readLine());
    int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
    W = input[0];
    H = input[1];
    board = new int[H][W];
    for(int i = 0 ; i < H ; i ++){
      int[] row = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
      board[i] = row;
    }
    visited = new int[K + 1][H][W];
    bfs();
    System.out.println(ans == Integer.MAX_VALUE?-1:ans);
  }
}