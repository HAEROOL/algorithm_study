import java.io.*;
import java.util.*;

public class Solution {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static int N, X, M;
	static int[][] logs;
	static void backtracking(int[] hams, int hidx) {
		if(ans != null) return;
		if(hidx == 0) {
			int[] dp = new int[N + 1];
			for(int i = 1 ; i < N + 1 ; i++) {
				dp[i] = hams[i] + dp[i - 1];
			}
			for(int[] log : logs) {
				int i = log[0];
				int r = log[1];
				int t = log[2];
				if(dp[r] - dp[i - 1] != t) {
					return;
				}
			}
			ans = Arrays.copyOf(hams, N + 1);
			return;
		}
		for(int y = X ; y > -1 ; y--) {
			hams[hidx] = y;
			backtracking(hams, hidx - 1);
		}
		
		
	}
	static int[] ans = null;
	public static void main(String[] args) throws IOException {
		int TC = Integer.parseInt(br.readLine());
		for (int tc = 1; tc < TC + 1; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			X = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			logs = new int[M][3];
			ans = null;
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				logs[i] = new int[] { Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()),
						Integer.parseInt(st.nextToken()) };
			}
			backtracking(new int[N + 1], N);
//			System.out.println(Arrays.toString(ans));
			bw.write("#" + tc + " ");
			if(ans == null) {
				bw.write(-1 + "\n");
			}else {
				for(int i = 1 ; i < N + 1 ; i++) {
					bw.write(ans[i] + " ");
				}				
				bw.write("\n");
			}
		}
		bw.close();
	}
}