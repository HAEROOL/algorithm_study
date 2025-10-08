import java.util.*;
import java.io.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static int V;
	static List<int[]>[] map;
	static int[] dijkstra(int s) {
		int[] dist = new int[V + 1];
		boolean[]v = new boolean[V + 1];
		
		Arrays.fill(dist, Integer.MAX_VALUE);
		
		PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> a[1] - b[1]);
		
		q.offer(new int[] {s, 0});
		dist[s] = 0;
		
		while(!q.isEmpty()) {
			int[] now = q.poll();
			int nowNode = now[0];
			if(v[nowNode]) continue;
			v[nowNode] = true;
			for(int[] next : map[nowNode]) {
				int nextNode = next[0];
				int nextCost = next[1];
				if(dist[nextNode] > nextCost + dist[nowNode]) {
					dist[nextNode] = nextCost + dist[nowNode];
					q.offer(new int[] {nextNode, dist[nextNode]});
				}
			}
		}
		return dist;
	}
	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		
		int S = Integer.parseInt(br.readLine());
		map = new ArrayList[V + 1];
		for(int i = 0 ; i < V + 1 ; i++) {
			map[i] = new ArrayList<int[]>();
		}
		
		for(int i = 0 ; i < E ; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			
			map[from].add(new int[] {to, cost});
		}
		
		int[] res = dijkstra(S);
		for(int i = 1 ; i < res.length ; i++) {
			bw.write(res[i] == Integer.MAX_VALUE?"INF\n":(res[i] + "\n"));
		}
		bw.close();
		
		
	}
}