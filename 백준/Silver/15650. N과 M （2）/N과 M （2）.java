import java.io.*;
import java.util.*;

public class Main {
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
  static int N, M;
  static void recursive(int idx, int k, int[] sel, boolean[] visited) throws IOException {
    if(idx == sel.length){
      for(int i : sel){
        bw.write(i + " ");
      }
      bw.write("\n");
      return;
    }

    for(int i = k + 1 ; i <= N ; i++){
      if(!visited[i]){
        visited[i] = true;
        sel[idx] = i;
        recursive(idx + 1, i, sel, visited);
        visited[i] = false;
      }
    }
  }

  public static void main(String[] args) throws IOException {
    int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
    N = input[0];
    M = input[1];
    recursive(0, 0, new int[M], new boolean[N + 1]);
    bw.flush();
    bw.close();
  }
}