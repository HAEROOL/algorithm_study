import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main {
  static int[][] board = new int[9][9];
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static ArrayList<int[]> targets = new ArrayList<>();
  static Map<Integer, int[]> rowDict = new HashMap<>();
  static Map<Integer, int[]> colDict = new HashMap<>();
  static int[][][] boxDict = new int[3][3][10];
  static boolean isFinished = false;
  static boolean isPossible(int tx, int ty, int i) {
    int[] rowTmp = rowDict.get(tx);
    int[] colTmp = colDict.get(ty);
    if (rowTmp[i] > 1 || colTmp[i] > 1 || boxDict[(tx - 1) / 3][(ty - 1) / 3][i] > 1) {
      return false;
    }
    return true;
  }

  static void dfs(int depth){
    if(isFinished) return;
    if(depth == targets.size()){
      for(int[] row : board){
        for(int x : row){
          System.out.print(x + " ");
        }
        System.out.println();
      }
      System.out.println();
      isFinished = true;
      return;
    }
    int tx = targets.get(depth)[0];
    int ty = targets.get(depth)[1];
    for(int i = 1; i < 10; i++){
      int[] rowTmp = rowDict.get(tx + 1);
      int[] colTmp = colDict.get(ty + 1);
      rowTmp[i] += 1;
      colTmp[i] += 1;
      boxDict[tx / 3][ty / 3][i] += 1;
      rowDict.put(tx + 1, rowTmp);
      colDict.put(ty + 1, colTmp);
      board[tx][ty] = i;
      if(isPossible(tx + 1, ty + 1, i)){
        dfs(depth+1);
      }
      rowTmp = rowDict.get(tx + 1);
      colTmp = colDict.get(ty + 1);

      rowTmp[i] -= 1;
      colTmp[i] -= 1;
      boxDict[tx / 3][ty / 3][i] -= 1;
      rowDict.put(tx + 1, rowTmp);
      colDict.put(ty + 1, colTmp);
      board[tx][ty] = 0;
    }
  }

  public static void main(String[] args) throws IOException {

    for(int x = 1; x < 10; x++){
      rowDict.put(x, new int[10]);
      colDict.put(x, new int[10]);
    }
    for (int i = 1; i < 10; i++) {
      int[] row = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
      board[i - 1] = row.clone();
      for(int j = 1; j < 10; j++){
        if(board[i - 1][j - 1] == 0) {
          targets.add(new int[]{i - 1, j - 1});
        }else{
          int[] rowTmp = rowDict.get(i);
          int[] colTmp = colDict.get(j);
          rowTmp[board[i - 1][j - 1]] = 1;
          colTmp[board[i - 1][j - 1]] = 1;
          boxDict[(i - 1) / 3][(j - 1) / 3][board[i - 1][j - 1]] = 1;
        }
      }

    }
//    System.out.println(rowDict.toString());
//    System.out.println(colDict.toString());
    dfs(0);


  }
}