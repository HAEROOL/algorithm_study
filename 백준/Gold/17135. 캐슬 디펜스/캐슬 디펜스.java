import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;


public class Main {
  static int N, M, D;
  static int[][] map;
  static int[][] copyMap;
  static int ans;
  public static void main(String[] args) throws NumberFormatException,IOException {
    // TODO Auto-generated method stub
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
    N = input[0];
    M = input[1];
    D = input[2];

    map = new int[N + 1][M + 1];
    copyMap = new int[N + 1][M + 1];
    for(int i = 1; i <= N ; i++){
      int[] row = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
      for(int j = 1 ; j <= M ; j++){
        map[i][j] = row[j - 1];
        copyMap[i][j] = row[j - 1];
      }
    }

    List<Integer> archers = new ArrayList<>();
    ans = 0;
    combination(1, M, 3, archers);

    bw.write(ans + "\n");
    bw.flush();
    bw.close();
    br.close();
  }

  static void init(){
    for(int i = 1 ; i < N + 1 ; i++){
      for(int j = 1 ; j < M + 1 ; j++){
        map[i][j] = copyMap[i][j];
      }
    }
  }

  static int getDistance(int r1, int r2, int c1, int c2){
    return Math.abs(r1 - r2) + Math.abs(c1 - c2);
  }

  static void combination(int start, int n, int r, List<Integer> archers){
    if(r == 0){
      init();
      attack(archers);
      return;
    }
    for(int i = start ; i <= n ; i++){
      archers.add(i);
      combination(i + 1, n, r - 1, archers);
      archers.remove(archers.size() - 1);
    }
  }

  static void attack(List<Integer> archers){
    int res = 0;
    for(int n = 1 ; n <= N ; n++){
      boolean[][] visited = new boolean[N + 1][M + 1];
      for(int k = 0 ; k < archers.size() ; k++){
        int tmp = archers.get(k);
        int minD = Integer.MAX_VALUE;
        int minR = Integer.MAX_VALUE;
        int minC = Integer.MAX_VALUE;

        for(int i = 1 ; i <= N ; i++){
          for(int j = 1 ; j <= M ; j++){
            if(map[i][j] == 1){
              if(minD >= getDistance(i, N + 1, j, tmp)){
                if(minD > getDistance(i, N + 1, j, tmp)){
                  minD = getDistance(i, N + 1, j, tmp);
                  minR = i;
                  minC = j;
                }else{
                  if(minC > j){
                    minR = i;
                    minC = j;
                  }
                }
              }
            }
          }
        }
        if(minD <= D){
          visited[minR][minC] = true;
        }
      }
      for(int i = 1 ; i <= N ; i++){
        for(int j = 1 ; j <= M ; j++){
          if(visited[i][j]){
            map[i][j] = 0;
            res++;
          }
        }
      }
      for(int i = 1; i <= M ; i++){
        map[N][i] = 0;
      }
      for(int i = N ; i >= 1 ; i--){
        for(int j = 1 ; j <= M ; j++){
          map[i][j] = map[i - 1][j];
        }
      }
    }
    ans = Math.max(ans, res);
  }
}