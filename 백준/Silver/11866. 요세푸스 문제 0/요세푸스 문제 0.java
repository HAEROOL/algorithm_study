import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

  static Queue<Integer> queue = new LinkedList<>();// 정수를 저장하는 큐

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    StringTokenizer st =new StringTokenizer(br.readLine());

    int N = Integer.parseInt(st.nextToken()); // N : 사람 수
    int K = Integer.parseInt(st.nextToken()); //K : 제거해야하는 인덱스(사람 순서)

    br.close();

    for(int i = 1; i <= N; i++){ //1~N번까지의 사람
      queue.add(i);
    }

    sb.append("<"); //여는 괄호

    while(queue.size() > 1){ //마지막 숫자는 ',' 없어서 size가 1까지만 반복

      // 큐 기준 0번째 인덱스부터 K-1까지는 뒤로 추가 한다. (해당 큐 맨 뒤에 값 삽입)

      for(int i = 0; i < K - 1; i++) {
        //일단 앞에 있는 요소를 삭제하여 반환값으로 나온 값을 다시 뒤에 추가하는 방식
                /*
                 예) K = 3
                 1 2 3 4 5 6
                 3 4 5 6 1 2이 방식으로 진행한다.
                */
        queue.offer(queue.poll());
      }
      //그리고 K번째가 가장 앞으로 왔으니 삭제해준다
      // poll() : 가장 앞에 있는 요소를 제거한다.
      sb.append(queue.poll()).append(", ");
    }

    //마지막 요소는 괄호가 마지막에 없으로 따로 빼준다.
    sb.append(queue.poll()).append(">"); //닫는 괄호

    System.out.println(sb);
  }
}