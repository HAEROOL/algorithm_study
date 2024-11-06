import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args) throws IOException {
		int TC = Integer.parseInt(br.readLine());
		for(int tc = 1 ; tc <= TC ; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			int[] degrees = new int[N + 1];
			int[] times = new int[N + 1];
			List<Integer>[] map = new ArrayList[N + 1];
			for(int i = 1 ; i < N + 1 ; i++) {
				map[i] = new ArrayList<>();
			}
			st = new StringTokenizer(br.readLine());
			for(int i = 1 ; i < N + 1 ; i++) {
				times[i] = Integer.parseInt(st.nextToken());
			}
			
			for(int i = 0 ; i < K ; i++) {
				st = new StringTokenizer(br.readLine());
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				map[from].add(to);
				degrees[to]++;
			}
			int target = Integer.parseInt(br.readLine());
			Deque<Integer> q = new ArrayDeque<>();
			int[] dptimes = new int[N + 1];
			boolean[] v = new boolean[N + 1];
			for(int i = 1 ; i < N + 1 ; i++) {
				if(degrees[i] == 0) {
					q.add(i);
					dptimes[i] = times[i];
					v[i] = true;
				}
			}
			while(!q.isEmpty()) {
				int n = q.poll();
				for(int next : map[n]) {
					degrees[next]--;
					dptimes[next] = Math.max(dptimes[next], times[next] + dptimes[n]);
					if(degrees[next] == 0) {
						q.add(next);
					}
				}
			}
//			System.out.println(Arrays.toString(dptimes));
			bw.write(dptimes[target] + "\n");
			
		}
		
		bw.close();
	}

}