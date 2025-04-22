import java.util.*;
import java.io.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		long counter = 0;
		long ans = 0;
		String[] strs = br.readLine().split("");
//		System.out.println(Arrays.toString(strs));
		for(int i = 0 ; i < N ; i ++) {
			String s = strs[i];
			if(s.equals("2")) {
				counter++;
			}else {
				if(counter == 0) continue;
				for(int j = 1 ; j <= counter ; j++) {
					ans += j * (counter - j + 1);
				}
				counter = 0;
			}
		}
		if(counter != 0) {
			for(int j = 1 ; j <= counter ; j++) {
				ans += j * (counter - j + 1);
			}
		}
		bw.write(ans + "");
		bw.close();

	}
}