import java.util.*;
import java.io.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int ans = 0;
		int[] dp = new int[11];
		
		dp[1] = 0;
		dp[2] = 1;
		dp[3] = 3;
		
		for(int i = 4 ; i < 11 ; i ++) {
			if(i % 2 == 0) {
				dp[i] = (i / 2)*(i / 2) + dp[(i / 2)] * 2;
			}else {
				dp[i] = (i / 2)*((i / 2) + 1) + dp[(i / 2)] + dp[(i / 2) + 1];
			}
		}
		bw.write(dp[n] + "");
		bw.close();
	}
}