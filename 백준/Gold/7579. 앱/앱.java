import java.util.*;
import java.io.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] memories = new int[N];
		int[] costs = new int[N + 1];
		int answer = Integer.MAX_VALUE;
		int[][] dp = new int[2][10001];
		st = new StringTokenizer(br.readLine());
		for(int i = 0 ; i < N ; i++) {
			memories[i] = Integer.parseInt(st.nextToken());
			
		}
		st = new StringTokenizer(br.readLine());
		for(int i = 0 ; i < N ; i++) {
			costs[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i = 0 ; i < 10001 ; i++) {
			if(costs[0] <= i) dp[0][i] = memories[0];
		}
		for(int i = 1 ; i < N ; i++) {
			if(i % 2 == 1) {
				for(int j = 0 ; j < 10001 ; j++) {
					if(j < costs[i]) dp[1][j] = dp[0][j];
					else {
						dp[1][j] = Math.max(dp[0][j], memories[i] + dp[0][j - costs[i]]);
					}
				}
			}else {
				for(int j = 0 ; j < 10001 ; j++) {
					if(j< costs[i]) dp[0][j] = dp[1][j];
					else {
						dp[0][j] = Math.max(dp[1][j], memories[i] + dp[1][j - costs[i]]);
					}
				}
			}


		}
		for(int[] row : dp) {
//			System.out.println(Arrays.toString(row));
			for(int i = 0 ; i < row.length ; i++) {
				if(row[i] >= M) answer = Math.min(answer,i);
			}
		}
		bw.write(answer + "");
		bw.close();
	}
}