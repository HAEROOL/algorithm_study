import java.util.*;
import java.io.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static int N;
	static List<int[]>[] map;
	static int[] dijkstra(int S) {
		int[] dist = new int[N + 1];
		boolean[] v = new boolean[N + 1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		
		PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> a[1] - b[1]);
		
		q.offer(new int[] {S, 0});
		dist[S] = 0;
		
		while(!q.isEmpty()) {
			int[] now = q.poll();
			int nowc = now[0];
			
			if(v[nowc]) continue;
			v[nowc] = true;
			
			for(int[] next : map[nowc]) {
				int nextc = next[0];
				int nextTime = next[1];
				if(dist[nextc] > nextTime + dist[nowc]) {
					dist[nextc] = nextTime + dist[nowc];
					q.offer(new int[] {nextc, dist[nextc]});
				}
			}
		}
		int total = 0;
		int time = 0;
		for(int i = 1 ; i < dist.length ; i++) {
			if(dist[i] != Integer.MAX_VALUE) {
				total++;
				time = Math.max(time, dist[i]);
			}
		}
//		System.out.println(Arrays.toString(dist));
		return new int[] {total, time};
	}
	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());
		int TC = Integer.parseInt(st.nextToken());
		for(int tc = 0 ; tc < TC ; tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			int D = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());
			map = new ArrayList[N + 1];
			for(int i = 1 ; i < N + 1 ; i++) {
				map[i] = new ArrayList<>();
			}
			for(int i = 0 ; i < D ; i++) {
				st = new StringTokenizer(br.readLine());
				int to = Integer.parseInt(st.nextToken());
				int from = Integer.parseInt(st.nextToken());
				int cost = Integer.parseInt(st.nextToken());
				map[from].add(new int[] {to, cost});
				
			}
			int[] res = dijkstra(C);
			bw.write(res[0]+" " + res[1] + "\n");
		}
		bw.close();
	}
}