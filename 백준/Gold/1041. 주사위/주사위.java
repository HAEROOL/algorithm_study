import java.util.*;
import java.io.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());
		long N = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int[] nums = new int[6];
		for(int i = 0 ; i < 6 ; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		long ans = 0;
		if(N == 1) {
			long sum = 0, mx = 0;
			for(int v : nums) {
				sum += v;
				mx = Math.max(mx, v);
			}
			ans = sum - mx;
		}else {
			long x = Math.min(nums[0], nums[5]);
			long y = Math.min(nums[1], nums[4]);
			long z = Math.min(nums[2], nums[3]);
			
			long three = x + y + z;
			long mxThree = Math.max(x, Math.max(y, z));
			long two = three - mxThree;
			long one = Math.min(x, Math.min(y, z));
			
			long cnt3 = 4;
			long cnt2 = 8 * N  - 12;
            long cnt1 = (N - 2) * (5 * N - 6); 

            ans = three * cnt3 + two * cnt2 + one * cnt1;
		}
		bw.write(ans + "");
		bw.close();

	}
}