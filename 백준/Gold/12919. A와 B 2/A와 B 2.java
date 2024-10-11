import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOError;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	static String T;
	static int ans = 0;
	static void dfs(String s, String t) throws IOException {
//		System.out.println(str + " " + a + " " + b);
		if(ans == 1) return;
		if(s.length() >= t.length()) {
//			System.out.println(str + " " + T);
			if(t.equals(s)) {
				ans = 1;
			}
			return;
		}
		if(t.charAt(0) == 'B') {
			String substring = t.substring(1);
			StringBuilder sb = new StringBuilder(substring);
			String str = sb.reverse().toString();
			dfs(s, str);
		}
		if(t.charAt(t.length() - 1) == 'A') {
			dfs(s, t.substring(0, t.length() - 1));
		}
		
	}
	public static void main(String[] args) throws IOException {
		String S = br.readLine();
		T = br.readLine();
		String[] strs = S.split("");
		String[] tgts = T.split("");
		
		dfs(S, T);						
		bw.write(ans + "");
		
		
		bw.close();
	}
}
