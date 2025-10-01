import java.util.*;
import java.io.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static List<int[]>[] map;
	static int V, E;
	static int[] dijkstra(int start) {
		boolean[] v = new boolean[V + 1];
		int[] dist = new int[V + 1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		
		PriorityQueue<int[]> q = new PriorityQueue<int[]>((a, b) -> {
			return a[1] - b[1];
		});
		dist[start] = 0;
		q.offer(new int[] {start, 0});
		
		while(!q.isEmpty()) {
			int[] n = q.poll();
			int node = n[0];
			if(v[node]) continue;
			v[node] = true;
			for(int[] next : map[node]) {
				int nextNode = next[0];
				int nextCost = next[1];
				if(dist[nextNode] > dist[node] + nextCost) {
					dist[nextNode] = dist[node] + nextCost;
					q.offer(new int[] {nextNode, dist[nextNode]});
				}
			}
		}
		return dist;
	}
	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		
		int start = Integer.parseInt(br.readLine());
		map = new List[V + 1];
		for(int i = 0 ; i < V + 1 ; i++) {
			map[i] = new ArrayList<int[]>();
		}
		
		for(int i = 0 ; i < E ; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			
			map[from].add(new int[]{to, cost});
		}
		int[] answer = dijkstra(start);
		for(int i = 1 ; i < V + 1 ; i++) {
			bw.write((answer[i] == Integer.MAX_VALUE?"INF":answer[i]) + "\n");
		}
		bw.close();
	}
}