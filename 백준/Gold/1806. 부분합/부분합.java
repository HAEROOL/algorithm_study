import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static void main(String[] args) throws IOException{
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		int[] nums = new int[N + 1];
		int[] dp = new int[N + 1];
		st = new StringTokenizer(br.readLine());
		for(int i = 1 ; i < N + 1 ; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
			if(i == 1) {
				dp[1] = nums[1];
			}else {
				dp[i] = dp[i - 1] + nums[i];
			}
			
		}
		int start = 0;
		int end = 1;
		int ans = Integer.MAX_VALUE;
		while(start <= end) {
			if(end == N + 1) {
				if(ans == Integer.MAX_VALUE) {
					ans = 0;
				}
				break;
			}
			int sum = dp[end] - dp[start];
//			System.out.println(sum);
			if(sum >= S) {
				ans = Math.min(ans, end - start);
			}
			if(sum < S) {
				end++;
			}else {
				start++;
			}
		}
//		System.out.println(start +  " " + end);
		bw.write(ans + "");
		bw.close();
	}
}