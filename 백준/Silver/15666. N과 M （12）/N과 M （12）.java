import java.io.*;
import java.util.*;

public class Main {
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
  static int N, M;
  static int[] arr;
  static void recursive(int idx, int k, int[] sel) throws IOException {
    if(idx == sel.length){
      for(int i : sel){
        bw.write(arr[i] + " ");
      }
      bw.write("\n");
      return;
    }
    int tmp = 0;
    for(int i = k ; i < N ; i++){
      if(tmp != arr[i]){
        sel[idx] = i;
        tmp = arr[i];
        recursive(idx + 1, i, sel);
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
    recursive(0,  0, new int[M]);
    bw.flush();
    bw.close();
  }
}