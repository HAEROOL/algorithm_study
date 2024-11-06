import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] sums = new int[N + 1];
		for(int i = 0 ; i < N ; i++) {
			sums[i + 1] = sums[i] + Integer.parseInt(br.readLine());
		}
		
		int[][] dp = new int[N + 1][M + 1];
		for(int i = 0 ; i < N + 1 ; i++) {
			for(int j = 1 ; j < M + 1 ; j++) {
				dp[i][j] = -32768 * 101;
			}
		}
		
		dp[1][1] = sums[1];
		
		for(int i = 2 ; i < N + 1 ; i++) {
			for(int j = 1 ; j < M + 1 ; j++) {
				dp[i][j] = dp[i - 1][j];
				if(j == 1) dp[i][j] = Math.max(dp[i][j], sums[i]);
				for(int k = 0 ; k < i - 1 ; k++) {
					dp[i][j] = Math.max(dp[i][j], dp[k][j - 1] + sums[i] - sums[k + 1]);
				}
			}
		}
		bw.write(dp[N][M] + "");
		bw.close();
	}

}