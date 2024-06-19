import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Main {

  public static void main(String[] args) throws IOException {
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt();

    Deque<Integer> stack = new ArrayDeque<>(N);
    for (int i = 0; i < N; i++) {
      int num = sc.nextInt();
      while (!stack.isEmpty() && stack.peek() <= num) {
        stack.pop();
      }
      stack.push(num);
    }
    System.out.println(stack.size());
  }
}