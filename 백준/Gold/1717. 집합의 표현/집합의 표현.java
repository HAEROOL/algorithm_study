import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOError;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static int N, M;
	static int[] parent;
	static void makeSet() {
		parent = new int[N + 1];
		for(int i = 0 ; i < N + 1 ; i++) {
			parent[i] = i;
		}
	}
	static int find(int x) {
		if(parent[x] == x) {
			return x;
		}
		return parent[x] = find(parent[x]);
	}
	static void union(int a, int b) {
		a = find(a);
		b = find(b);
		if(a <= b) {
			parent[b] = a;
		}else {
			parent[a] = b;
		}
	}
	public static void main(String[] args) throws IOException{
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		makeSet();
		for(int i = 0 ; i < M ; i++) {
			st = new StringTokenizer(br.readLine());
			int cmd = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			if(cmd == 1) {
				if(find(a) == find(b)) {
					bw.write("YES\n");
				}else {
					bw.write("NO\n");
				}
			}else {
				union(a, b);
			}
		}
		bw.close();
	}

}
