import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Main {

  public static void main(String[] args) throws IOException {
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt();

    Deque<Integer> q = new ArrayDeque<>(N);
    for (int i = 1; i < N + 1; i++) {
      q.add(i);
    }
    while (q.size() > 1) {
      q.pop();
      int tmp = q.pop();
      q.add(tmp);
    }
    System.out.println(q.peek());
  }
}