import java.io.*;
import java.util.*;

public class Main {
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int N, M, start, end;
	static List<int[]>[] map;
	static int dijkstra() {
		int[] dist = new int[N + 1];
		boolean[] v = new boolean[N + 1];
		PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> {
			return b[1] - a[1];
		});
		
		q.add(new int[] {start, Integer.MAX_VALUE});
		dist[start] = Integer.MAX_VALUE;
		while(!q.isEmpty()) {
			int[] n = q.poll();
			int node = n[0];
			int limit = n[1];
			if(v[node]) continue;
			v[node] = true;
			if(node == end) return limit;
			for(int[] next : map[node]) {
				int nextNode = next[0];
				int nextLimit = next[1];
				if(dist[nextNode] < Math.min(nextLimit, dist[node])) {
					dist[nextNode] =  Math.min(nextLimit, dist[node]);
					q.add(new int[] {nextNode, dist[nextNode]});
				}
			}
		}
		
		return dist[end];
		
	}
	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new ArrayList[N + 1];
		for(int i = 0 ; i < N + 1 ; i++) {
			map[i] = new ArrayList<>();
		}
		for(int i = 0 ; i < M ; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int limit = Integer.parseInt(st.nextToken());
			map[from].add(new int[] {to, limit});
			map[to].add(new int[] {from, limit});
		}
		
		st = new StringTokenizer(br.readLine());
		start = Integer.parseInt(st.nextToken());
		end=  Integer.parseInt(st.nextToken());
		
		int ans = dijkstra();
		bw.write(ans+"");
		bw.close();
	}

}