import java.util.*;
import java.io.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static List<int[]>[] map;
	static int N, M;
	public static int dijkstra(int from, int to) {
		int[] dist = new int[N + 1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		boolean[] v = new boolean[N + 1];
		
		PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) ->{
			return a[1] - b[1];
		});
		dist[from] = 0;
		pq.offer(new int[] {from, 0});
		
		while(!pq.isEmpty()) {
			int[] now = pq.poll();
			
			int nowNode = now[0];
			
			if(v[nowNode]) continue;
			v[nowNode] = true;
			
			for(int[] next : map[nowNode]) {
				int nextNode = next[0];
				int nextCost = next[1];
				if(dist[nextNode] > dist[nowNode] + nextCost) {
					dist[nextNode] = dist[nowNode] + nextCost;
					pq.offer(new int[] {nextNode, dist[nextNode]});
				}
			}
		}
		return dist[to];
		
	}
	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		map = new ArrayList[N + 1];
		for(int i = 0 ; i < N + 1 ; i++) {
			map[i] = new ArrayList<int[]>();
		}
		for(int i = 0 ; i < M ; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			map[from].add(new int[] {to, cost});
		}
		st = new StringTokenizer(br.readLine());
		int from = Integer.parseInt(st.nextToken());
		int to = Integer.parseInt(st.nextToken());
		bw.write(dijkstra(from, to) + "");
		bw.close();
	}
}