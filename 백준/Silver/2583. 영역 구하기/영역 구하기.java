import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class Main {
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
  static int N, M, K;
  static int[][] board;
  static boolean[][] v;
  static int[] dx = {1, 0, -1, 0};
  static int[] dy = {0, 1, 0, -1};
  static List<Integer> ans = new ArrayList<>();
  static int anscnt = 0;
  static void fill(int sx, int sy, int xr, int yr){
    for(int i = sx ; i < sx + xr ; i++){
      for(int j = sy ; j < sy + yr ; j++){
        board[i][j] = 1;
      }
    }
  }
  static void bfs(int sx, int sy){
    Deque<int[]> q = new ArrayDeque<>();
    q.offer(new int[]{sx, sy});
    v[sx][sy] = true;
    int cnt = 1;
    while(!q.isEmpty()){
      int[] coord = q.poll();
      int x = coord[0];
      int y = coord[1];
      for(int i = 0 ; i < 4 ; i++){
        int nx = x + dx[i];
        int ny = y + dy[i];
        if(0 <= nx && nx < M && 0 <= ny && ny < N && !v[nx][ny] && board[nx][ny] == 0){
          v[nx][ny] = true;
          q.offer(new int[]{nx, ny});
          cnt++;
        }
      }
    }
    ans.add(cnt);
  }
  public static void main(String[] args) throws IOException {
    StringTokenizer st = new StringTokenizer(br.readLine());
    M = Integer.parseInt(st.nextToken());
    N = Integer.parseInt(st.nextToken());
    K = Integer.parseInt(st.nextToken());
    board = new int[M][N];
    v = new boolean[M][N];
    for(int i = 0 ; i < K ; i++){
      st = new StringTokenizer(br.readLine());
      int sy = Integer.parseInt(st.nextToken());
      int sx = M - Integer.parseInt(st.nextToken());
      int ey = Integer.parseInt(st.nextToken());
      int ex = M - Integer.parseInt(st.nextToken());

      fill(Math.min(sx, ex), Math.min(sy, ey), Math.abs(sx - ex), Math.abs(sy - ey));
    }

    for(int i = 0 ; i < M ; i++){
      for(int j = 0 ; j < N ; j++){
        if(!v[i][j] && board[i][j] == 0){
          anscnt++;
          bfs(i, j);
        }
      }
    }
    Collections.sort(ans);
    bw.write(anscnt+"\n");
    for(int a : ans){
      bw.write(a+" ");
    }
    bw.close();
  }
}