import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
  static int N;
  static int r;
  static int c;
  static int count = 0;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String input[] = br.readLine().split(" ");
    N = Integer.parseInt(input[0]);
    r = Integer.parseInt(input[1]);
    c = Integer.parseInt(input[2]);
    solution(N, r, c);
  }
  static void solution(int n, int rr, int cc){
    if (n == 0){
      System.out.println(count);
      return;
    }
    n--;
    if(rr < Math.pow(2, n) && cc < Math.pow(2, n)){
      solution(n, rr, cc);
    }else if(rr < Math.pow(2, n) && cc >= Math.pow(2, n)){
      count += (int)Math.pow(2, n) * (int)Math.pow(2, n);
      solution(n, rr, cc - (int)Math.pow(2, n));
    }else if(rr >= Math.pow(2, n) && cc < Math.pow(2, n)){
      count += (int)Math.pow(2, n) * (int)Math.pow(2, n) * 2;
      solution(n, rr - (int)Math.pow(2, n), cc);
    }else{
      count += (int)Math.pow(2, n) * (int)Math.pow(2, n) * 3;
      solution(n, rr - (int)Math.pow(2, n), cc - (int)Math.pow(2, n));
    }
  }
}