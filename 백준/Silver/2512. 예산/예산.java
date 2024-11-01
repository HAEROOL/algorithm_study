import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static int N, M;
	static int[] nums;
	static int search() {
		int start = 0;
		int end = nums[N - 1];
		int ans = 0;
		while(start <= end) {
			int mid = (start + end) / 2;
			long total = 0;
			for(int i = 0 ; i < N ; i++) {
				if(nums[i] <= mid) {
					total += nums[i];
				}else {
					total += mid;
				}
			}
			if(total <= M) {
				start = mid + 1;
				ans = mid;
			}else {
				end = mid - 1;
			}
		}
		return ans;
	}
	public static void main(String[] args) throws IOException{
		N = Integer.parseInt(br.readLine());
		nums = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0 ; i < N ; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(nums);
		M = Integer.parseInt(br.readLine());
		int ans = search();
		bw.write(ans + "");
		bw.close();
	}
}