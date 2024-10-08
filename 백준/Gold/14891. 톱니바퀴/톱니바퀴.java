import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Main {
  static List<Integer>[] wheels;
  static boolean[] visited = new boolean[4];
  static void rotate(int n, int dir){
    visited[n] = true;
    if(n + 1 < 4 && !Objects.equals(wheels[n].get(2), wheels[n + 1].get(6)) && !visited[n + 1]){
      rotate(n + 1, dir * -1);
    }
    if(n - 1 >= 0 && ! Objects.equals(wheels[n - 1].get(2), wheels[n].get(6)) && !visited[n - 1]){
      rotate(n - 1, dir * -1);
    }
    if(dir == 1){
      wheels[n].add(0, wheels[n].remove(7));
    }else{
      wheels[n].add(7, wheels[n].remove(0));
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    wheels = new ArrayList[4];
    for(int i = 0 ; i < 4 ; i++){
      wheels[i] = new ArrayList<>();
      int[] row = Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();
      for(int j : row){
        wheels[i].add(j);
      }
    }
    int K = Integer.parseInt(br.readLine());

    for(int i = 0 ; i < K ; i++){
      int[] input =  Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
      visited = new boolean[4];
      rotate(input[0] - 1, input[1]);

//      for(List a : wheels){
//        System.out.println(a.toString());
//      }
    }
    int total = 0;
    for(int i = 0 ; i < 4 ; i++){
      if(wheels[i].get(0) == 1){
        total += Math.pow(2, i);
      }
    }
    System.out.println(total);
  }
}