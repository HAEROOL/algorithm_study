import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static int V, E;
	static List<int[]>[] map;
	static int[] dijkstra(int start) {
		int[] dist = new int[V + 1];
		boolean[] v = new boolean[V + 1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		
		PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> a[1] - b[1]);
		q.add(new int[] {start, 0});
		dist[start] = 0;
		
		while(!q.isEmpty()) {
			int[] n = q.poll();
			int now = n[0];
			
			if(v[now]) continue;
			v[now] = true;
			for(int[] next : map[now]) {
				int nextnode = next[0];
				int nextcost = next[1];
				if(dist[nextnode] > dist[now] + nextcost) {
					dist[nextnode] = dist[now] + nextcost;
					q.add(new int[] {nextnode, dist[nextnode]});
				}
			}
		}
		return dist;
	}
	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		int start = Integer.parseInt(br.readLine());
		
		map = new ArrayList[V + 1];
		for(int i = 1 ; i < V + 1 ; i++) {
			map[i] = new ArrayList<>();
		}
		
		for(int i = 0 ; i < E ; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to =Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			map[from].add(new int[] {to, cost});
		}
		
		int[] res = dijkstra(start);
		for(int i = 1 ; i < V + 1 ; i++) {
			int e = res[i];
			bw.write((e==Integer.MAX_VALUE?"INF":e) +"\n");
		}
		bw.close();
	}

}
