import java.util.*;
import java.io.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static int N, M;
	static int[][] board;
	static int[] dx = new int[] {1, 0};
	static int[] dy = new int[] {0, 1};
	static boolean[][] v;
	static long ans = 0;
	static Map<String, HashSet<String>> bridge = new HashMap<String, HashSet<String>>();
	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		board = new int[M + 1][N + 1];
		v = new boolean[M + 1][N + 1];
		int K = Integer.parseInt(br.readLine());
		for(int i = 0 ; i < K ; i++) {
			st = new StringTokenizer(br.readLine());
			String a = st.nextToken();
			String b = st.nextToken();
			String c = st.nextToken();
			String d = st.nextToken();
			String from = b + " " + a;
			String to = d + " " + c;
			if(!bridge.containsKey(from)) {
				bridge.put(from, new HashSet<String>());
			}
			bridge.get(from).add(to);
			if(!bridge.containsKey(to)) {
				bridge.put(to, new HashSet<String>());
			}
			bridge.get(to).add(from);
		}
		long[][] dp = new long[M + 1][N + 1];
		for(int i = 1 ; i < M + 1 ; i++) {
			if(bridge.containsKey(i + " " + 0) && bridge.get(i + " " + 0).contains((i - 1) + " " + 0)) break;
			if(bridge.containsKey((i - 1) + " " + 0) && bridge.get((i - 1) + " " + 0).contains(i + " " + 0)) break;
			dp[i][0] = 1;
		}
		for(int i = 1 ; i < N + 1 ; i++) {
			if(bridge.containsKey(0 + " " + i) && bridge.get(0 + " " + i).contains(0 + " " + (i - 1))) break;
			if(bridge.containsKey(0 + " " + (i - 1)) && bridge.get(0 + " " + (i - 1)).contains(0 + " " + i)) break;
			dp[0][i] = 1;
		}

		for(int i = 1 ; i <= M ; i++) {
			for(int j = 1 ; j <= N ; j++) {
				long a = dp[i - 1][j];
				long b = dp[i][j - 1];
				if(bridge.containsKey((i - 1) + " " + j) && bridge.get((i - 1) + " " + j).contains((i + " " + (j)))) {
					a = 0;
				}
				if(bridge.containsKey(i  + " " + j) && bridge.get(i + " " + j).contains((i - 1) + " " + j)) {
					a = 0;
				}
				if(bridge.containsKey(i + " " + (j - 1)) && bridge.get(i + " " + (j - 1)).contains((i + " " + (j)))) {
					b = 0;
				}
				if(bridge.containsKey(i  + " " + j) && bridge.get(i  + " " + j).contains(i + " " + (j - 1))) {
					b = 0;
				}
				dp[i][j] = a + b;
			}
		}
//		for(long[] row : dp) {
//			System.out.println(Arrays.toString(row));
//		}
		bw.write(dp[M][N] + "");
		bw.close();

	}
}