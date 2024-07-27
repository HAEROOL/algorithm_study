import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
  static class Dice {

    List<Integer> rowq;
    List<Integer> colq;
    int top;
    int bottom;
    int x, y;

    Dice(int x, int y) {
      rowq = new ArrayList<>(Arrays.asList(0, 0, 0, 0));
      colq = new ArrayList<>(Arrays.asList(0, 0, 0, 0));
      top = 0;
      bottom = 0;
      this.x = x;
      this.y = y;
    }

    void moveWest() {
      int dx = 0, dy = -1;
      int nx = this.x + dx;
      int ny = this.y + dy;
      if (0 <= nx && nx < N && 0 <= ny && ny < M) {
        rowq.add(rowq.size() - 1, rowq.remove(0));
        top = rowq.get(1);
        bottom = rowq.get(3);
        colq.set(1, top);
        colq.set(3, bottom);

        if (board[nx][ny] == 0) {
          board[nx][ny] = colq.get(3);
        } else {
          colq.set(3, board[nx][ny]);
          rowq.set(3, board[nx][ny]);
          bottom = board[nx][ny];
          board[nx][ny] = 0;
        }
        this.x = nx;
        this.y = ny;
        System.out.println(top);
      }
    }

    void moveEast() {
      int dx = 0, dy = 1;
      int nx = this.x + dx;
      int ny = this.y + dy;
      if (0 <= nx && nx < N && 0 <= ny && ny < M) {
        rowq.add(0, rowq.remove(rowq.size() - 1));
        top = rowq.get(1);
        bottom = rowq.get(3);
        colq.set(1, top);
        colq.set(3, bottom);

        if (board[nx][ny] == 0) {
          board[nx][ny] = colq.get(3);
        } else {
          colq.set(3, board[nx][ny]);
          rowq.set(3, board[nx][ny]);
          bottom = board[nx][ny];
          board[nx][ny] = 0;
        }
        this.x = nx;
        this.y = ny;
        System.out.println(top);
      }
    }

    void moveNorth() {
      int dx = -1, dy = 0;
      int nx = this.x + dx;
      int ny = this.y + dy;
      if (0 <= nx && nx < N && 0 <= ny && ny < M) {
        colq.add(colq.size() - 1, colq.remove(0));
        top = colq.get(1);
        bottom = colq.get(3);
        rowq.set(1, top);
        rowq.set(3, bottom);

        if (board[nx][ny] == 0) {
          board[nx][ny] = colq.get(3);
        } else {
          colq.set(3, board[nx][ny]);
          rowq.set(3, board[nx][ny]);
          bottom = board[nx][ny];
          board[nx][ny] = 0;
        }
        this.x = nx;
        this.y = ny;
        System.out.println(top);
      }
    }

    void moveSouth() {
      int dx = 1, dy = 0;
      int nx = this.x + dx;
      int ny = this.y + dy;
      if (0 <= nx && nx < N && 0 <= ny && ny < M) {
        int tmp = colq.get(colq.size() - 1);
        colq.remove(colq.size() - 1);
        colq.add(0, tmp);
        top = colq.get(1);
        bottom = colq.get(3);
        rowq.set(1, top);
        rowq.set(3, bottom);

        if (board[nx][ny] == 0) {
          board[nx][ny] = colq.get(3);
        } else {
          colq.set(3, board[nx][ny]);
          rowq.set(3, board[nx][ny]);
          bottom = board[nx][ny];
          board[nx][ny] = 0;
        }
        this.x = nx;
        this.y = ny;
        System.out.println(top);
      }
    }
  }
  static int[][] board;
  static int N;
  static int M;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
    N = input[0];
    M = input[1];
    int x = input[2];
    int y = input[3];
    int k = input[4];

    board = new int[N][M];
    for (int i = 0; i < N; i++) {
      board[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
    }
    Dice d = new Dice(x, y);
    int[] cmds = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
    for (int cmd : cmds) {
      switch (cmd) {
        case 1:
          d.moveEast();
          break;
        case 2:
          d.moveWest();
          break;
        case 3:
          d.moveNorth();
          break;
        case 4:
          d.moveSouth();
          break;
        default:
          break;
      }
    }
  }
}