import java.util.*;
import java.io.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		char[] strs = br.readLine().toCharArray();
		int ans = 0;
		int left = 0;
		int right = 0;
		int cnt = 0;
		int[] freq = new int[26];
		while(right < strs.length) {
			int idx = strs[right] - 'a';
			right++;
			if(freq[idx]++ == 0) {
				cnt++;
			}
			while(cnt > N) {
				int iidx = strs[left] - 'a';
				left++;
				freq[iidx]--;
				if(freq[iidx] == 0) {
					cnt--;
				}
			}
//			for(int i = left ; i < right ; i++) {
//				System.out.print(strs[i]);
//			}
//			System.out.println();
			ans = Math.max(ans, right - left);
		}
		bw.write(ans + "");
		bw.close();

	}
}