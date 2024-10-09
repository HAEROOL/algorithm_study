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
	static int INF = Integer.MAX_VALUE >> 1;
	static int dijkstra(int start, int end) {
		int[] dist = new int[N + 1];
		Arrays.fill(dist, INF);
		dist[start] = 0;
		boolean[] v = new boolean[N + 1];
		PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> a[1] - b[1]);
		q.offer(new int[] {start, 0});
		while(!q.isEmpty()) {
			int[] n = q.poll();
			int node = n[0];
			if(v[node])continue;
			v[node] = false;
			for(int[] next : map[node]) {
				int nextnode = next[0];
				int nextcost = next[1];
				if(dist[nextnode] > dist[node] + nextcost) {
					dist[nextnode] = dist[node] + nextcost;
					q.offer(new int[] {nextnode, dist[nextnode]});
				}
			}
		}
		return dist[end];
	}
	static int N, M, X;
	static List<int[]>[] map;
	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		
		map = new ArrayList[N + 1];
		for(int i = 1 ; i < N + 1 ; i++) {
			map[i] = new ArrayList<>();
		}
		for(int i = 0 ; i < M ; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			map[from].add(new int[] {to, cost});
		}
		int path = -1;
		for(int i = 1 ; i < N + 1 ; i++) {
			int go = dijkstra(i, X);
			int back = dijkstra(X, i);
			path = Math.max(path, go + back);
		}
		System.out.println(path);
	}
}