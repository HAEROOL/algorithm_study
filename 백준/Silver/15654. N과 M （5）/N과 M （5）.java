import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.lang.reflect.Array;
import java.util.Arrays;

public class Main {
  static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
  static int[] arr;
  static void recursive(int idx, int[] sel, boolean[] visited) throws IOException {
    if(idx == sel.length){
      for(int i : sel){
        bw.write(arr[i] + " ");
      }
      bw.write("\n");
      return;
    }
    for(int i = 0 ; i < N ; i++){
      if(!visited[i]){
        visited[i] = true;
        sel[idx] = i;
        recursive(idx + 1, sel, visited);
        visited[i] = false;
      }
    }
  }
  static int N, M;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
    N = input[0];
    M = input[1];
    arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
    Arrays.sort(arr);
    // N 개중 M개 고르기
    recursive(0, new int[M], new boolean[N]);
    bw.flush();
    bw.close();
  }
}