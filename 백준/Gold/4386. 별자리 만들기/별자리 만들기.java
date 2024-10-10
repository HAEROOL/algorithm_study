import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOError;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static class Node{
		double x, y;
		int id;
		public Node(double x, double y, int id) {
			// TODO Auto-generated constructor stub
			this.x = x;
			this.y = y;
			this.id = id;
		}
	}
	static class Edge implements Comparable<Edge>{
		Node from, to;
		double cost;
		public Edge(Node from, Node to, double cost) {
			// TODO Auto-generated constructor stub
			this.from = from;
			this.to = to;
			this.cost = cost;
		}
		@Override
		public int compareTo(Main.Edge o) {
			return Double.compare(cost, o.cost);
		}
	}
	static int N;
	static int[] parent;
	static Node[] nodes;
	static int find(int x) {
		if(parent[x] == x) {
			return x;
		}
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
	static List<Edge> edges = new ArrayList<>();
	public static void main(String[] args) throws IOException{
		N = Integer.parseInt(br.readLine());
		nodes = new Node[N];
		parent = new int[N];
		StringTokenizer st;
		for(int i = 0 ; i < N ; i++) {
			st = new StringTokenizer(br.readLine());
			double x = Double.parseDouble(st.nextToken());
			double y = Double.parseDouble(st.nextToken());
			nodes[i] = new Node(x, y, i);
			parent[i] = i;
		}
		for(int i = 0 ; i < N - 1 ; i++) {
			for(int j = i + 1 ; j < N ; j++) {
				double x1 = nodes[i].x;
				double x2 = nodes[j].x;
				double y1 = nodes[i].y;
				double y2 = nodes[j].y;
				double cost = Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));
				edges.add(new Edge(nodes[i],nodes[j], cost));
			}
		}
		Collections.sort(edges);
		double cost = 0;
		for(Edge edge : edges) {
			int fromid = edge.from.id;
			int toid = edge.to.id;
			if(find(fromid) != find(toid)) {
				union(fromid, toid);
				cost += edge.cost;
			}
		}
		String ans = String.format("%.2f", cost);
		bw.write(ans + "");
		bw.close();
	}

}
