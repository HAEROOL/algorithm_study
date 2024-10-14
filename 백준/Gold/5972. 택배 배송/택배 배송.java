import java.io.*;
import java.util.*;
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static int N, M;
	static List<int[]>[] map;
	static int dijkstra() {
		int[] dist = new int[N + 1];
		boolean[] v = new boolean[N + 1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		
		PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> a[1] - b[1]);
		q.add(new int[] {1, 0});
		dist[1] = 0;
		while(!q.isEmpty()) {
			int[] n = q.poll();
			int node = n[0];
			if(v[node]) continue;
			v[node] = true;
			for(int[] next : map[node]) {
				int nextnode = next[0];
				int nextcost = next[1];
				if(dist[nextnode] > dist[node] + nextcost) {
					dist[nextnode] = dist[node] + nextcost;
					q.add(new int[] {nextnode, dist[nextnode]});
				}
			}
		}
		return dist[N];
	}
	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new ArrayList[N + 1];
		for(int i = 1 ; i < N + 1 ; i++) {
			map[i] = new ArrayList<>();
		}
		for(int i = 0 ; i < M ; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int cost =  Integer.parseInt(st.nextToken());
			map[from].add(new int[] {to, cost});
			map[to].add(new int[]{from, cost});
		}
		
		int ans = dijkstra();
		bw.write(ans + "");
		bw.close();
	}
}