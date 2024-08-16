import java.io.*;
import java.util.*;

public class Main {
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
  static int N, M;
  static int[] arr;
  static void recursive(int idx, int k, int[] sel, boolean[] visited) throws IOException {
    if(idx == sel.length){
      for(int i : sel){
        bw.write(arr[i] + " ");
      }
      bw.write("\n");
      return;
    }
    int tmp = 0;
    for(int i = 0 ; i < N ; i++){
      if(!visited[i] && tmp != arr[i]){
        sel[idx] = i;
        visited[i] = true;
        tmp = arr[i];
        recursive(idx + 1, i, sel, visited);
        visited[i] = false;
      }


    }

  }

  public static void main(String[] args) throws IOException {
    int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
    N = input[0];
    M = input[1];
    arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
    Arrays.sort(arr);
    // N개중 M개 고르기
    recursive(0,  0, new int[M], new boolean[N]);
    bw.flush();
    bw.close();
  }
}