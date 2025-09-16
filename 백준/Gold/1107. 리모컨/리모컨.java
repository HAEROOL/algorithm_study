import java.util.*;
import java.io.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static void main(String[] args) throws IOException {
		int N = Integer.parseInt(br.readLine()); 
		int M = Integer.parseInt(br.readLine());
		
		boolean[] broke = new boolean[10];
		if(M > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i = 0 ; i < M ; i++) {
				broke[Integer.parseInt(st.nextToken())] = true;
			}
		}
		
		
		
		int res = Math.abs(N - 100);
		for(int i = 0 ; i <= 999999 ; i++) {
			String num = i + "";
			boolean isBreak = false;
			
			for(int j = 0 ; j < num.length(); j++) {
				if(broke[num.charAt(j) - '0']) {
					isBreak = true;
					break;
				}
			}
			
			if(!isBreak) {
				int min = Math.abs(N - i) + num.length();
				res = Math.min(min, res);
			}
		}
		bw.write(res + "");
		bw.close();
	}
}