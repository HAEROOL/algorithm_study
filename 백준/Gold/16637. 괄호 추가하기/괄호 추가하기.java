import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
  static int N;
  static List<String> nums;
  static int mx = Integer.MIN_VALUE;
  static void combination(int idx, int k, boolean[] sel){
    if(idx >= sel.length){
      run(sel);
      return;
    }

    sel[idx] = true;
    combination(idx + 2, k + 1, sel);
    sel[idx] = false;
    combination(idx + 1, k, sel);
  }

  static int cal(int a, String b, int c){
    int result = 0;
    switch (b){
      case "+":
        result = a + c;
        break;
      case "-":
        result = a - c;
        break;
      case "*":
        result = a * c;
        break;
    }
    return result;
  }

  static void run(boolean[] sel){
    List<String> list = new ArrayList<>();
    int total = 0;
    int cnt = 0;
    for(int i = 0 ; i < nums.size() ; i++){
      if(nums.get(i).equals("*") || nums.get(i).equals("+") || nums.get(i).equals("-")){
//        System.out.println(Arrays.toString(sel));
        if(sel[cnt]){
          list.remove(list.size() - 1);
          int a = Integer.parseInt(nums.get(i - 1));
          int c = Integer.parseInt(nums.get(i + 1));
          int result = cal(a, nums.get(i), c);
          list.add(String.valueOf(result));
          i++;
        }else{
          list.add(nums.get(i));
        }
        cnt++;
      }else{
        list.add(nums.get(i));
      }
    }
    total = Integer.parseInt(list.get(0));
    for(int i = 1 ; i < list.size() - 1 ; i+=2){
      total = cal(total, list.get(i), Integer.parseInt(list.get(i + 1)));
    }
    mx = Math.max(total, mx);
  }
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(br.readLine());
    nums = Arrays.asList(br.readLine().split(""));
    combination(0, 0, new boolean[N]);
    System.out.println(mx);
  }
}