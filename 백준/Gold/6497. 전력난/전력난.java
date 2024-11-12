import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static List<int[]>[] map;
	static class Edge{
		int from, to, cost;
		Edge(int from, int to, int cost){
			this.from = from;
			this.to = to;
			this.cost = cost;
		}
	}
	
	static int find(int x) {
		if(parent[x] == x) return x;
		return parent[x] = find(parent[x]);
	}
	static void union(int x, int y) {
		x = find(x);
		y = find(y);
		if(x <= y) {
			parent[y] = x;
		}else {
			parent[x] = y;
		}
	}
	static int[] parent;
	static List<Edge> edges;
	public static void main(String[] args) throws IOException {
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			if(N == 0 && M == 0) break;
			map = new ArrayList[N];
			edges = new ArrayList<>();
			parent = new int[N];
			for(int i = 0 ; i < N ; i++) {
				map[i] = new ArrayList<>();
				parent[i] = i;
			}
			int mx = 0;
			for(int i = 0 ; i < M ; i++) {
				st = new StringTokenizer(br.readLine());
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				int cost = Integer.parseInt(st.nextToken());
				map[from].add(new int[] {to, cost});
				map[to].add(new int[] {from, cost});
				edges.add(new Edge(from, to, cost));
				mx += cost;
			}
			Collections.sort(edges, (a, b) -> a.cost - b.cost);
			
			int total = 0;
			for(Edge e : edges) {
				int from = e.from;
				int to = e.to;
				if(find(from) != find(to)) {
					union(from, to);
					total += e.cost;
				}
			}
			int ans = mx - total;
			bw.write(ans + "\n");
		}
		bw.close();
	}

}