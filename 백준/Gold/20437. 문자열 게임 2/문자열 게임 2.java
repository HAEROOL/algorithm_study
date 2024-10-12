import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static void main(String[] args) throws IOException {
		int T = Integer.parseInt(br.readLine());
		for(int tc = 0 ; tc < T ; tc++) {
			String ws = br.readLine();
			int K = Integer.parseInt(br.readLine());
			if(K == 1) {
				bw.write("1 1\n");
				continue;
			}
			int[] alpha = new int[26];
			for(int i = 0 ; i < ws.length() ; i++) {
				alpha[ws.charAt(i) - 'a']++;
			}
			int mn = Integer.MAX_VALUE;
			int mx = -1;
			for(int i = 0 ; i < ws.length() ; i++) {
				if(alpha[ws.charAt(i) - 'a'] < K) continue;
				int cnt = 1;
				for(int j = i + 1 ; j < ws.length() ; j++) {
					if(ws.charAt(j) == ws.charAt(i)) cnt++;
					if(cnt == K) {
						mn = Math.min(mn, j - i + 1);
						mx = Math.max(mx, j - i + 1);
						break;
					}
				}
			}
			if(mn == Integer.MAX_VALUE || mx == -1) bw.write(-1+"");
			else bw.write(mn + " " + mx);
			bw.write("\n");
			
		}
		bw.close();
	}
}