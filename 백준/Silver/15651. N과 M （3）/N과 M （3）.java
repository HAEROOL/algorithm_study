import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Main {
  static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
  static public void recursive(int k, int idx, int[] sel) throws IOException {
    if(idx == M){
      for(int i : sel){
        bw.write(i + " ");
      }
      bw.write("\n");
      return;
    }
    for(int i = 1 ; i < N + 1 ; i++){
        sel[idx] = i;
        recursive(k, idx + 1, sel);
      }
    }

  static int N, M;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

    N = input[0];
    M = input[1];
    recursive(0, 0, new int[M]);
    bw.flush();
    bw.close();
  }
}