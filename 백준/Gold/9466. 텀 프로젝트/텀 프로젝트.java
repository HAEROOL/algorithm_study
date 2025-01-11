import java.io.*;
import java.util.*;

public class Main {
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int[] degrees;
	static int[] stus;
	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());
		int TC = Integer.parseInt(st.nextToken());
		for(int tc = 0 ; tc < TC ; tc++) {
			int N = Integer.parseInt(br.readLine());
			degrees = new int[N + 1];
			stus = new int[N + 1];
			st = new StringTokenizer(br.readLine());
			for(int i = 1 ; i < N + 1 ; i++) {
				int n = Integer.parseInt(st.nextToken());
				stus[i] = n;
				degrees[n]++;
			}
			Deque<Integer> q = new ArrayDeque();
			for(int i = 1 ; i < N + 1 ; i++) {
				// 방문했는지
				if(degrees[i] == 0) {
					q.add(i);
				}
			}
			while(!q.isEmpty()) {
				int n = q.poll();
				int next = stus[n];
				degrees[next]--;
				if(degrees[next] == 0) {
					q.add(next);
				}
			}
			int ans = N;
			for(int s : degrees) {
				if(s != 0) ans--;
			}
			bw.write(ans + "\n");
		}
		bw.close();
	}

}