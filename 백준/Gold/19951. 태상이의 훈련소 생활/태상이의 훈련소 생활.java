import java.util.*;
import java.io.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] grounds = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			grounds[i] = Integer.parseInt(st.nextToken());
		}
		
		int[] startp = new int[N];
		for(int i = 0 ; i < M ; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken()) - 1;
			int b = Integer.parseInt(st.nextToken());
			int h = Integer.parseInt(st.nextToken());
			startp[a] += h;
			if(b >= N) continue;
			startp[b] += -h;
		}
		int[] dp = new int[N];
//		System.out.println(Arrays.toString(grounds));
		for(int i = 0 ; i < N ; i++) {
			if(i == 0) dp[0] = startp[0];
			else dp[i] = dp[i - 1] + startp[i];
			grounds[i] = dp[i] + grounds[i];
			
		}
//		System.out.println(Arrays.toString(startp));
//		System.out.println(Arrays.toString(dp));
//		System.out.println(Arrays.toString(grounds));
		for(int e : grounds) bw.write(e + " ");
		bw.close();

	}
}