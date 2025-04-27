import java.util.*;
import java.io.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		String[] strs = br.readLine().split("");
		int ans = 0;
		int left = 0;
		int right = 0;
		Set<String> set = new HashSet<String>();
		while(right < strs.length) {
			String str = strs[right];
//			System.out.println(left);
			if(set.contains(str)) {
				right++;
			}else {
				if(set.size() < N) {
					set.add(str);
					right++;
				}else {
					Set<String> s = new HashSet<String>();
					left = right;
					s.add(str);
					while(true) {
						left--;
						String lstr = strs[left];
						if(!s.contains(lstr) && s.size() == N) break;
						s.add(lstr);
					}
					left++;
					set = s;
				}
			}
//			for(int i = left ; i < right ; i++) {
//				System.out.print(strs[i]);
//			}
//			System.out.println(set.toString());
			ans = Math.max(ans, right - left);
		}
		bw.write(ans + "");
		bw.close();

	}
}