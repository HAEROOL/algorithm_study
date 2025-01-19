import java.io.*;
import java.util.*;

public class Main {
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[][] map = new int[N + 1][N + 1];
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int meal = Integer.parseInt(st.nextToken());
			if(from > to) continue;
			map[from][to] = Math.max(meal, map[from][to]);
		}
		int[][] dp = new int[M + 1][N + 1];
		for(int i = 0 ; i < M + 1 ; i++) {
			Arrays.fill(dp[i], Integer.MIN_VALUE);
		}
		dp[1][1] = 0;
		for(int i = 1 ; i < M + 1 ; i++) {
			for(int j = 1 ; j < N + 1 ; j++) {
				for(int k = 1 ; k < j ; k++) {
					if(map[j - k][j] == 0 || dp[i - 1][j - k] == Integer.MIN_VALUE) continue;
					dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - k] + map[j - k][j]);
				}
			}
		}
		int ans = 0;
		for(int i = 0 ; i < M + 1 ; i++) {
			ans = Math.max(dp[i][N], ans);
		}
		bw.write(ans + "");
		
		bw.close();
	}

}