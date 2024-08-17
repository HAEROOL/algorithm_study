import java.io.*;
import java.util.*;

public class Main {
  static int N, M;
  static int[][] board;
  static int[] dx = {0, 1, 0, -1};
  static int[] dy = {1, 0, -1, 0};
  static List<int[]> brideges;
  static List<Deque<int[]>> islands;
  static int ans = Integer.MAX_VALUE;
  static void combination(int idx, int k, int[] sel){
    if(k == sel.length){
      int[][] map = new int[islands.size() + 1][islands.size() + 1];
      int total = 0;
      boolean[] v = new boolean[islands.size() + 1];
      for(int i : sel){
        int[] dir = brideges.get(i);
        int to = dir[0];
        int from = dir[1];
        int cost = dir[2];
        total += cost;
        map[from][to] = cost;
        map[to][from] = cost;
      }
      int st = brideges.get(0)[0];
      dfs(st, v, map);
      for(int i = 1; i < v.length ; i++){
        if(!v[i]) return;
      }
      ans = Math.min(ans, total);
      return;
    }
    if(idx == brideges.size()) return;
    combination(idx + 1, k, sel);
    sel[k] = idx;
    combination(idx + 1, k + 1, sel);

  }

  static void dfs(int n, boolean[] visited, int[][] map){
      visited[n] = true;
      for(int i = 1 ; i < map[n].length ; i++){
        int cost = map[n][i];
        if(!visited[i] && cost != 0){
          dfs(i, visited, map);
        }
      }
  }
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter( new OutputStreamWriter(System.out));
    int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
    N = input[0];
    M = input[1];
    board = new int[N][M];
    for(int i = 0 ; i < N ; i++){
      int[] row = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
      board[i] = row;
    }
    // 섬 분류
    boolean[][] visited = new boolean[N][M];
    islands = new ArrayList<>();
    int num = 1;
    for(int i = 0 ; i < N ; i++){
      for(int j = 0 ; j < M ; j++){
        if(!visited[i][j] && board[i][j] == 1){
          Deque<int[]> q = new ArrayDeque<>();
          Deque<int[]> island = new ArrayDeque<>();
          q.offer(new int[]{i, j});
          board[i][j] = num;
          island.offer(new int[]{i, j});
          visited[i][j] = true;
          while(!q.isEmpty()){
            int[] coord = q.poll();
            int x = coord[0];
            int y = coord[1];
            for(int k = 0 ; k < 4 ; k++){
              int nx = x + dx[k];
              int ny = y + dy[k];
              if(0 <= nx && nx < N && 0 <= ny && ny < M && !visited[nx][ny] && board[nx][ny] == 1){
                visited[nx][ny] = true;
                board[nx][ny] = num;
                q.offer(new int[]{nx, ny});
                island.offer(new int[]{nx, ny});
              }
            }
          }
          num++;
          islands.add(island);
        }
      }
    }
    int[][] map = new int[islands.size() + 1][islands.size() + 1];
    brideges = new ArrayList<>();
    // 섬 다리 짓기
    for(Deque<int[]> island : islands){
      int islandN = board[island.peek()[0]][island.peek()[1]];
      for(int[] coord : island){
        for(int i = 0 ; i < 4 ; i++){
          int x = coord[0];
          int y = coord[1];
          int cnt = 0;
          while(true){
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(0 <= nx && nx < N && 0 <= ny && ny < M){
              if(board[nx][ny] == islandN) break;
              if(board[nx][ny] != 0){
                if(cnt == 1){
                  break;
                }
                map[islandN][board[nx][ny]] = map[islandN][board[nx][ny]] == 0 ? cnt : Math.min(cnt, map[islandN][board[nx][ny]]);
                break;
              }
              x = nx;
              y = ny;
              cnt++;
            }else{
              break;
            }
          }
        }
      }
    }
    for(int i = 1 ; i < map.length ; i++){
      for(int j = i + 1 ; j < map.length ; j++){
        if(map[i][j] != 0){
          brideges.add(new int[]{i, j, map[i][j]});
        }
      }
    }
    // mst 찾기
    combination(0, 0, new int[islands.size() - 1]);
    System.out.println(ans == Integer.MAX_VALUE?-1:ans);
  }
}