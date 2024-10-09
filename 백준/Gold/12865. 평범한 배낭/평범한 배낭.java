import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[] weight = new int[N + 1];
		int[] value = new int[N + 1];
		for(int i = 1 ; i < N + 1 ; i++) {
			st = new StringTokenizer(br.readLine());
			int w = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			weight[i] = w;
			value[i] = v;
		}
		int[] dp = new int[K + 1];
		for(int i = 1 ; i < N + 1 ; i++) {
			for(int j = K ; j > 0 ; j--) {
				if(j - weight[i] >= 0) {
					dp[j] = Math.max(dp[j], dp[j - weight[i]] + value[i]);					
				}
			}			
		}
		System.out.println(dp[K]);
	}
}