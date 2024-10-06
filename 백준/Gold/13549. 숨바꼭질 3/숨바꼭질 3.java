import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static void bfs(int s, int e) {
		Deque<int[]> q = new ArrayDeque<>();
		boolean[] v = new boolean[100001];
		q.add(new int[] {s, 0});
		int ans = Integer.MAX_VALUE;
		while(!q.isEmpty()) {
			int[] n = q.poll();
			int nx = n[0];
			int time = n[1];
			v[nx] = true;
			if(nx == e) {
				ans = Math.min(time, ans);
			}
			if(nx * 2 <= 100000 && !v[nx*2]) {
				q.add(new int[] {nx * 2, time});
			}
			if(nx - 1 >= 0 && !v[nx - 1]) {
				q.add(new int[] {nx - 1, time + 1});
			}
			if(nx + 1 <= 100000 && !v[nx + 1]) {
				q.add(new int[] {nx + 1, time + 1});
			}
		}
		System.out.println(ans);
	}
	
	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());
		int sx = Integer.parseInt(st.nextToken());
		int ex = Integer.parseInt(st.nextToken());
		bfs(sx, ex);
	}
}