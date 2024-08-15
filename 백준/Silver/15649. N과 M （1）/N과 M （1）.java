import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.lang.reflect.Array;
import java.util.Arrays;

public class Main {
  static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
  static void recursive(int idx, int[] sel, boolean[] visited) throws IOException {
    if(idx == sel.length){
      for(int i : sel){
        bw.write(i + " ");
      }
      bw.write("\n");
      return;
    }
    for(int i = 1 ; i <= N ; i++){
      if(!visited[i]){
        visited[i] = true;
        sel[idx] = i;
        recursive(idx + 1, sel, visited);
        visited[i] =false;
      }
    }
  }
  static int N, M;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
    N = input[0];
    M = input[1];
    // N 개중 M개 고르기
    recursive(0, new int[M], new boolean[N + 1]);
    bw.flush();
    bw.close();
  }
}