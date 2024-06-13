import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Stream;

public class Main {


  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt();
    sc.nextLine();
    int[] scores = Stream.of(sc.nextLine().split(" "))
        .mapToInt(Integer::parseInt)
        .toArray();
    float max = Arrays.stream(scores).max().getAsInt();
    float total = 0;
    for (int num : scores) {
      total += num / max * 100;
    }
    System.out.println(total / N);
  }
}