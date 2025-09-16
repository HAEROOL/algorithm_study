import java.util.*;
import java.io.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static void main(String[] args) throws IOException {
		int N = Integer.parseInt(br.readLine());
		int[] dp = new int[N + 1];
		int[] nums = new int[N + 1];
		for(int i = 1 ; i < N + 1 ; i ++) {
			nums[i] = Integer.parseInt(br.readLine());
		}
		dp[1] = nums[1];
		if(N == 1) {
			bw.write(dp[1]+"");
			bw.close();
			return;
		}
		dp[2] = dp[1] + nums[2];
		if(N == 2) {
			bw.write(dp[2]+"");
			bw.close();
			return;
		}
		if(N >= 3) {
			for(int i = 3 ; i < N + 1 ; i++) {
				dp[i] = Math.max(nums[i] + dp[i - 2],nums[i] + nums[i - 1] + dp[i - 3]);
			}
			bw.write(dp[N]+"");
		}
//		System.out.println(Arrays.toString(dp));
		bw.close();
	}
}