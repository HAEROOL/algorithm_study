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
	static int N, M, K;
	static int[] candies;
	static int ans = 0;
	static List<Integer>[] map;
	static boolean[] v;
	static int[] bfs(int start) {
		Deque<Integer> q = new ArrayDeque<Integer>();
		q.add(start);
		v[start] = true;
		int total = candies[start];
		int cnt = 1;
		while(!q.isEmpty()) {
			int now = q.poll();
			for(int next : map[now]) {
				if(!v[next]) {
					v[next] = true;
					q.offer(next);
					total += candies[next];
					cnt++;
				}
			}
		}
//		System.out.println(total);
		return new int[]{cnt, total};
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		candies = new int[N + 1];
		map = new ArrayList[N + 1];
		for(int i = 1 ; i < N + 1 ; i++) {
			map[i] = new ArrayList<Integer>();
		}
		st = new StringTokenizer(br.readLine());
		v = new boolean[N + 1];
		for(int i = 1 ; i < N + 1 ; i++) {
			candies[i] = Integer.parseInt(st.nextToken());
		}
		for(int i = 0 ; i < M ; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			map[from].add(to);
			map[to].add(from);
		}
		List<Integer> V = new ArrayList<Integer>();
		List<Integer> C = new ArrayList<Integer>();
		V.add(0);
		C.add(0);
		for(int i = 1 ; i < N + 1 ; i++) {
			if(!v[i]) {
				int[] res = bfs(i);
				V.add(res[0]);
				C.add(res[1]);
//				System.out.println(Arrays.toString(v));
			}
		}
//		System.out.println(vlist.toString());
//		System.out.println(clist.toString());
		int[][] dp = new int[V.size()][K + 1];
		for(int i = 0 ; i < K + 1 ; i++) {
			if(V.get(1) < i) {
				dp[1][i] = C.get(1);
			}
		}
		for(int i = 2 ; i < V.size() ; i++) {
			for(int j = 1 ; j < K + 1 ; j++) {
				if(j - V.get(i) > 0) {
					dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - V.get(i)] + C.get(i));					
				}else {
					dp[i][j] = dp[i - 1][j];
				}
			}
		}
//		for(int[] row : dp) {
//			System.out.println(Arrays.toString(row));
//		}
		ans = dp[V.size() - 1][K];
		bw.write(ans + "\n");
		bw.close();
		
	}

}
