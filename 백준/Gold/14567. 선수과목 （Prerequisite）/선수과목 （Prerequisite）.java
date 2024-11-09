import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static List<Integer>[] map;
	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[] subs = new int[N + 1];
		int[] degrees = new int[N + 1];
		map = new ArrayList[N + 1];
		for(int i = 1 ; i < N + 1 ; i++) {
			map[i] = new ArrayList<>();
		}
		for(int i = 0 ; i < M ; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			map[from].add(to);
			degrees[to]++;
		}
		Deque<Integer> q = new ArrayDeque<>();
		int[] v = new int[N + 1];
		for(int i = 1 ; i < N + 1 ; i++) {
			if(degrees[i] == 0) {
				q.add(i);
				v[i] = 1;
			}
		}
		while(!q.isEmpty()) {
			int n = q.poll();
			for(int i : map[n]) {
				degrees[i]--;
				if(degrees[i] == 0) {
					v[i] = v[n] + 1;
					q.add(i);
				}
			}
		}
		for(int i = 1 ; i < N + 1 ; i++) {
			bw.write(v[i] + " ");
		}
		bw.close();

	}

}