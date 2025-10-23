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
import java.util.concurrent.PriorityBlockingQueue;
public class Main{
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static int N, M;
	static ArrayList<int[]>[] map;
	
	static void prim() throws IOException {
		int start = 1;
		int[] dist = new int[N + 1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		boolean[] v = new boolean[N + 1];
		PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> a[1] - b[1]);
		q.offer(new int[] {start, 0});
		dist[start] = 0;
		while(!q.isEmpty()) {
			int[] n = q.poll();
			int node = n[0];
			if(v[node]) continue;
			v[node] = true;
			for(int[] next : map[node]) {
				int nextNode = next[0];
				int nextCost = next[1];
				if(!v[nextNode] && nextCost < dist[nextNode]) {
					dist[nextNode] = nextCost;
					q.offer(new int[] {nextNode, nextCost});
				}
			}
		}
		int total = 0;
		for(int i = 1 ; i < dist.length ; i++) {
			total += dist[i];
		}
		bw.write(total + "\n");
		bw.flush();
	}
	
	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		map = new ArrayList[N + 1];
		for(int i = 1 ; i < N + 1 ; i++) {
			map[i] = new ArrayList<>();
		}
		StringTokenizer st;
		for(int i = 0 ; i < M ; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			map[from].add(new int[] {to, cost});
			map[to].add(new int[] {from, cost});
		}
		
		prim();
	}
}