import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static int N, E;
	static List<int[]>[] map;
	static int node1, node2;
	static int[] dist;
	static int INF = Integer.MAX_VALUE >> 1;
	static void dijkstra(int start) {
		dist = new int[N + 1];
		Arrays.fill(dist, INF);
		boolean[] v = new boolean[N + 1];
		dist[start] = 0;

		PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> a[1] - b[1]);
		q.add(new int[] { start, 0 });

		while (!q.isEmpty()) {
			int[] n = q.poll();
			int node = n[0];
			if(v[node])continue;
			v[node] = true;
			for (int[] next : map[node]) {
				int nextnode = next[0];
				int nextcost = next[1];
				if (dist[node] + nextcost < dist[nextnode]) {
					dist[nextnode] = dist[node] + nextcost;
					q.offer(new int[] { nextnode, dist[nextnode] });

				}
			}
		}
	}

	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		map = new List[N + 1];
		for (int i = 1; i < N + 1; i++) {
			map[i] = new ArrayList<>();
		}
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			map[from].add(new int[] { to, cost });
			map[to].add(new int[] { from, cost });
		}
		st = new StringTokenizer(br.readLine());
		node1 = Integer.parseInt(st.nextToken());
		node2 = Integer.parseInt(st.nextToken());
		dijkstra(1);
		int sto1 = dist[node1];
		int sto2 = dist[node2];
		
		dijkstra(node1);
		int n1ton2 = dist[node2];
		int n1toN = dist[N];
		
		dijkstra(node2);
		int n2toN = dist[N];
		
		int ans = Math.min(sto1 + n1ton2 +n2toN, sto2 + n1ton2 + n1toN);
		if(n1ton2 == INF) {
			bw.write(-1 + "");
		}else if(ans > INF) {
			bw.write(-1 + "");
		}else {
			bw.write(ans + "");
		}
		bw.close();
	}
}