import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Main {
  static int N, M;
  static int[][] board;
  static int[] dx = {1, 0, -1, 0};
  static int[] dy = {0, 1, 0, -1};
  static int ans = Integer.MAX_VALUE;
  static int bfs(){
    Deque<int[]> q = new ArrayDeque<>();
    q.add(new int[]{0, 0, 0});
    int[][][] visited = new int[N][M][2];
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < M; j++) {
        visited[i][j][0] = 0;
      }
    }
    visited[0][0][0] = 1;
    while(!q.isEmpty()){
      int[] coords = q.pop();
      int x = coords[0], y = coords[1], z = coords[2];
      if(x == N - 1 && y == M - 1){
        return visited[x][y][z];
      }
      for(int i = 0 ; i < 4 ; i++){
        int nx = x + dx[i];
        int ny = y + dy[i];
        if(0 <= nx && nx < N && 0 <= ny && ny < M){
          if(board[nx][ny] == 1 && z == 0){
            visited[nx][ny][1] = visited[x][y][0] + 1;
            q.add(new int[]{nx, ny, 1});
          }else if(board[nx][ny] == 0 && visited[nx][ny][z] == 0){
            visited[nx][ny][z] = visited[x][y][z] + 1;
            q.add(new int[]{nx, ny, z});
          }
        }
      }
    }
    return -1;
  }
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int[] inputs = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
    N = inputs[0];
    M = inputs[1];
    board = new int[N][M];
    for(int i = 0 ; i < N ; i++) {
      board[i] = Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();
    }
    System.out.println(bfs());
  }
}