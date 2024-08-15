import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {
  static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
  static int[] arr;
  static public void recursive(int k, int idx, int[] sel) throws IOException {
    if(idx == M){
      for(int i : sel){
        bw.write(arr[i] + " ");
      }
      bw.write("\n");
      return;
    }
    if(k > N){
      return;
    }
    for(int i = 0 ; i < N ; i++){
          sel[idx] = i;
          recursive(i, idx + 1, sel);

      }
    }

  static int N, M;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
    arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
    N = input[0];
    M = input[1];
    Arrays.sort(arr);
    // N 개중 M개 고르기
    recursive(0, 0, new int[M]);
    bw.flush();
    bw.close();
  }
}