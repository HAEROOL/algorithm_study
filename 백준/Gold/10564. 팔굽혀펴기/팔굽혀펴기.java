import java.util.*;
import java.io.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


	public static void main(String[] args) throws IOException {
		int TC = Integer.parseInt(br.readLine());
		for(int tc = 0 ; tc < TC ; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int[] scores = new int[M];
			st = new StringTokenizer(br.readLine());
			for(int i = 0 ; i < M ; i++) {
				scores[i] = Integer.parseInt(st.nextToken());
			}
			
			boolean[][] dp = new boolean[501][5001];
			dp[0][0] = true;
			
			for(int i = 1 ; i < 501 ; i++) {
				if(i > N) break;
				
				for(int j = i ; j < N + 1 ; j++) {
					int bcnt = j - i;
					for(int k = 0 ; k < M ; k++) {
						int bscore = i - scores[k];
						if(bscore > -1 && dp[bscore][bcnt]) {
							dp[i][j] = true;
							break;
						}
					}
					
				}
			}
			int answer = -1;
			for(int i = 500 ; i > 0 ; i--) {
				if(dp[i][N]) {
					answer = i;
					break;
				}
			}
			bw.write(answer+"\n");
		}
		bw.close();

	}
}