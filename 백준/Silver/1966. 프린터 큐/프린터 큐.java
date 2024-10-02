import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static int ans = 0;
	static class Node implements Comparable<Node>{
		int val;
		int p;
		public Node(int val, int p ) {
			// TODO Auto-generated constructor stub
			this.val = val;
			this.p = p;
		}
		@Override
		public int compareTo(Main.Node o) {
			if(o.p != this.p) {
				return Integer.compare(o.p, this.p);				
			}
			return Integer.compare(this.val, o.val);
		}
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		int t = Integer.parseInt(br.readLine());
		for(int tc = 1 ; tc < t + 1 ; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int mx = 0;
			Deque<Node> q = new ArrayDeque<Main.Node>();
			st = new StringTokenizer(br.readLine());
			for(int i = 0 ; i < N; i++) {
				int node = Integer.parseInt(st.nextToken());
				mx = Math.max(mx, node);
				q.add(new Node(i, node));
			}
			int time = 0;
			while(!q.isEmpty()) {
				Node node = q.poll();
				if(node.p < mx) {
					q.add(node);
				}else {
					time++;
					mx = 0;
					for(Node v : q) {
						mx = Math.max(mx, v.p);
					}
					if(node.val == M) {
						bw.write(time + "\n");
						break;
					}
				}
			}
		}
		bw.close();		
	}

}
