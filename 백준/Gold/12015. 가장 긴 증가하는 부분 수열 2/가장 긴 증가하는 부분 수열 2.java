import java.util.*;
import java.io.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static int lis = 0;
	static int[] dp;
	static int binSearch(int target, int start, int end, int size) {
		int res = 0;
		while(start <= end) {
			int mid = (start + end) / 2;
			if(dp[mid] >= target) {
				res = mid;
				end = mid - 1;
			}else {
				start = mid + 1;
			}
		}
		if(start == size) {
			return -1;
		}
		return res;
	}
	public static void main(String[] args) throws IOException {
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] nums = new int[N];
		dp = new int[N];
		for(int i = 0 ; i < N ; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		for(int i = 0 ; i < N ; i++) {
			int pos = binSearch(nums[i], 0, lis, lis + 1);
			if(pos == -1) {
				dp[lis++] = nums[i];
			}else {
				dp[pos] = nums[i];
			}
		}
		bw.write(lis+"");
		
		bw.close();
	}
}