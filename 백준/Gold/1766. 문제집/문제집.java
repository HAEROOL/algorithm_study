import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	public static void main(String[] args) throws IOException {
		  StringTokenizer st = new StringTokenizer(br.readLine());
		  int N = Integer.parseInt(st.nextToken());
		  int M = Integer.parseInt(st.nextToken());
		  
		  int[] degree = new int[N + 1];
		  List<Integer>[] map = new ArrayList[N + 1];
		  for(int i = 1 ; i < N + 1 ; i++) {
			  map[i] = new ArrayList<>();
		  }
		  for(int i = 0 ; i < M ; i++) {
			  st = new StringTokenizer(br.readLine());
			  int from = Integer.parseInt(st.nextToken());
			  int to = Integer.parseInt(st.nextToken());
			  map[from].add(to);
			  degree[to]++;
		  }
		  PriorityQueue<Integer> q = new PriorityQueue<>((a, b) -> a - b);
		  for(int i = 1 ; i < N + 1 ; i++) {
			  if(degree[i] == 0) {
				  q.add(i);
			  }
		  }
		  while(!q.isEmpty()) {
			  int n = q.poll();
			  bw.write(n + " ");
			  for(int i : map[n]) {
				  degree[i]--;
				  if(degree[i] == 0) {
					  q.add(i);
				  }
			  }
		  }
		  bw.close();
		}
}