import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static int N, M, K, X;
	static List<int[]>[] map;

	static List<Integer> dijkstra() {
		PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> {
			return a[1] - b[1];
		});
		int[] dist = new int[N + 1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		boolean[] v = new boolean[N + 1];

		q.add(new int[] { X, 0 });
		dist[X] = 0;

		while (!q.isEmpty()) {
			int[] n = q.poll();
			int node = n[0];
			int cost = n[1];
			if (v[node])
				continue;
			v[node] = true;
			for (int[] next : map[node]) {
				int nextnode = next[0];
				int nextcost = next[1];
				if (dist[nextnode] > dist[node] + nextcost) {
					q.add(new int[] { nextnode, dist[node] + nextcost });
					dist[nextnode] = dist[node] + nextcost;
				}
			}
		}
		List<Integer> ans = new ArrayList<>();
		for (int i = 1; i < N + 1; i++) {
			if (dist[i] == K) {
				ans.add(i);
			}
		}
		return ans;
	}

	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		map = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) {
			map[i] = new ArrayList<>();
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			map[from].add(new int[] { to, 1 });
		}
		List<Integer> ans = dijkstra();
		Collections.sort(ans);
		if (ans.size() == 0) {
			bw.write(-1 + "\n");
		} else {
			for (int e : ans) {
				bw.write(e + "\n");
			}
		}
		bw.close();

	}

}