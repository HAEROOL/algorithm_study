import java.util.*;
import java.io.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		long[] dp = new long[N + 1];
		dp[0] = 1;
		if(N < 2 ) {
			bw.write(dp[N] + "");
			bw.close();
			return;
		}
		dp[2] = 3;
		for(int i = 4 ; i < N + 1 ; i += 2) {
			if(i % 2 == 1) continue;
			dp[i] = dp[2] * dp[i - 2];
			for(int j = i - 4 ; j > -1 ; j-=2 ) {
				dp[i] += dp[j] * 2;
			}
			
		}
		bw.write(dp[N] + "");
		bw.close();

	}
}