import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static List<Integer>[] map;
	static int N;
	static boolean[] v;
	static int parent[];
	static void dfs(int node) {
		for(int next : map[node]) {
			if(!v[next]) {
				v[next] = true;
				parent[next] = node;
				dfs(next);
				v[next] = false;
			}
		}
	}
	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(br.readLine());
		map = new ArrayList[N + 1];
		v = new boolean[N + 1];
		parent = new int[N + 1];
		for (int i = 1; i < N + 1; i++) {
			map[i] = new ArrayList<>();
		}
		for (int i = 1; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			map[from].add(to);
			map[to].add(from);
		}
		v[1] = true;
		dfs(1);
		for(int a : parent) {
			if(a == 0) continue;
			System.out.println(a);
		}

	}
}