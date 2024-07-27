import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;


public class Main {
  static int N;
  static int mx = -1;
  static class Tile{
    int x, y, val;
    boolean isCombine;
    Tile(int x, int y, int val, boolean isCombine){
      this.x = x;
      this.y = y;
      this.val = val;
      this.isCombine = isCombine;
    }

    void move(int dx, int dy, Tile[][] board){
      if(this.val == 0) return;
      while(true){
        int nx = this.x + dx;
        int ny = this.y + dy;
        if(nx >= N || nx < 0 || ny >= N || ny < 0 || board[nx][ny].val != 0){
          break;
        }
        if(0 <= nx && nx < N && 0 <= ny && ny < N && board[nx][ny].val == 0){
          board[this.x][this.y] = new Tile(this.x, this.y, 0, false);
          board[nx][ny] = new Tile(nx, ny, this.val, false);
          this.x = nx;
          this.y = ny;
        }
      }
    }
    void process(int dx, int dy, Tile[][] board){
      int nx = this.x + dx;
      int ny = this.y + dy;
      if(0 <= nx && nx < N && 0 <= ny && ny < N && board[nx][ny].val == this.val && !board[nx][ny].isCombine){
        board[nx][ny] = new Tile(nx, ny, this.val * 2, true);
        this.isCombine = true;
        board[this.x][this.y] = new Tile(x, y, 0, false);
      }
    }
  }
  static void moveRight(Tile[][] board){
    for(int i = 0 ; i < N ; i ++){
      for(int j = 1 ; j <= N ; j++){
        Tile tile = board[i][N - j];
        if(tile.val == 0) continue;
        tile.move(0, 1, board);
        tile.process(0, 1, board);
      }
    }
  }
  static void moveLeft(Tile[][] board){
    for(int i = 0 ; i < N ; i ++){
      for(int j = 0 ; j < N ; j++){
        Tile tile = board[i][j];
        if(tile.val == 0) continue;
        tile.move(0, -1, board);
        tile.process(0, -1, board);
      }
    }
  }
  static void moveUp(Tile[][] board){
    for(int i = 0 ; i < N ; i ++){
      for(int j = 0 ; j < N ; j++){
        if(board[i][j].val != 0){
          Tile tile = board[i][j];
          if(tile.val == 0) continue;
          tile.move(-1, 0, board);
          tile.process(-1, 0, board);

        }
      }
    }
  }
  static void moveDown(Tile[][] board){
    for(int i = 1 ; i <= N ; i ++){
      for(int j = 0 ; j < N ; j++){
        Tile tile = board[N - i][j];
        if(tile.val == 0) continue;
        tile.move(1, 0, board);
        tile.process(1, 0, board);
      }
    }
  }

  static void combination(int depth, int[] arr, Tile[][] board, Tile[][] tmpBoard){
    if(depth == 5){
      run(arr, board);
      for(int i = 0 ; i < N ; i++){
        for(int j = 0 ; j < N ; j++){
          board[i][j] = new Tile(i, j, tmpBoard[i][j].val, false);
        }
      }
      return;
    }
    for(int i = 1 ; i < 5 ; i++){
      arr[depth] = i;
      combination(depth + 1, arr, board, tmpBoard);
    }
  }

  static void run(int[] arr, Tile[][] board){
    for(int x : arr){
      switch (x){
        case 1:
          moveDown(board);
          break;
        case 2:
          moveUp(board);
          break;
        case 3:
          moveLeft(board);
          break;
        case 4:
          moveRight(board);
          break;
        default:break;
      }
      for(int a = 0 ; a < N ; a++){
        for(int j = 0 ; j < N ; j++){
          board[a][j].isCombine = false;
        }
      }
    }
    for(int i =0 ; i < N ; i++){
      for(int j = 0 ; j < N ; j++){
        mx = Math.max(mx, board[i][j].val);
      }
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(br.readLine());
    Tile[][] board = new Tile[N][N];
    Tile[][] tmpBoard = new Tile[N][N];
    for (int i = 0; i < N; i++) {
      int[] row = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
      for (int j = 0; j < N; j++) {
        board[i][j] = new Tile(i, j, row[j], false);
        tmpBoard[i][j] = new Tile(i, j, row[j], false);
      }
    }

    combination(0, new int[5], board, tmpBoard);
    System.out.print(mx);
//    moveRight();
//    moveLeft();
//    moveUp();
//    moveDown();

  }
}