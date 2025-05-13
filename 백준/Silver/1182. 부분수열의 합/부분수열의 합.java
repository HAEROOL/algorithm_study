import java.util.*;
import java.io.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	static void dfs(long total, int idx, int cnt) {
		if(idx == N) {
			if(total == S && cnt != 0) {
				ans++;
			}
			return;
		}
		
		dfs(total + arr[idx], idx + 1, cnt + 1);
		dfs(total, idx + 1, cnt);
	}

	static int[] arr;
	static int N, S;
	static int ans;
	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		arr = new int[N];
		ans = 0;
		st = new StringTokenizer(br.readLine());
		for(int i = 0 ; i < N ; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		dfs(0, 0, 0);
		
		bw.write(ans+"");
		bw.close();
	}
}