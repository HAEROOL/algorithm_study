import java.io.*;
import java.util.*;

public class Main {
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static boolean[] v, isDone;
	static int[] stus;
	static int ans;
	static void dfs(int n) {
		v[n] = true;
		int next = stus[n];
		if(!v[next]) dfs(next);
		else {
			if(!isDone[next]) {
				ans--;
				while(next != n) {
					next = stus[next];
					ans--;
				}
			}
		}
		isDone[n] = true;
	}
	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());
		int TC = Integer.parseInt(st.nextToken());
		for(int tc = 0 ; tc < TC ; tc++) {
			int N = Integer.parseInt(br.readLine());
			stus = new int[N + 1];
			ans = N;
			isDone = new boolean[N + 1];
			v = new boolean[N + 1];
			st = new StringTokenizer(br.readLine());
			for(int i = 1 ; i < N + 1 ; i++) {
				stus[i] = Integer.parseInt(st.nextToken());
			}
			for(int i = 1 ; i < N + 1 ; i++) {
				// 방문했는지
				if(v[i]) continue;
				dfs(i);
			}
			bw.write(ans + "\n");
		}
		bw.close();
	}

}