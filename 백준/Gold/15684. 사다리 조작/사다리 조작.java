import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static int[][] rladders;

	static boolean check(int[][] ladders) {
		for (int i = 1; i < N + 1; i++) {
			int x = 0;
			int y = i;
			while (x != H + 1) {
				if (ladders[x][y] != 0) {
					y = ladders[x][y];
				}
				x++;
			}
			if (y != i)
				return false;
		}
		return true;
	}

	static void dfs(int depth, int[][] ladders, int x) {
		if (depth > 3 || depth >= ans) {
			return;
		}
		if (check(ladders)) {
			ans = Math.min(depth, ans);
			return;
		}
		for (int i = x; i < H + 1; i++) {
			for (int j = 1; j < N; j++) {
				if (ladders[i][j] == 0 && ladders[i][j + 1] == 0) {
					ladders[i][j] = j + 1;
					ladders[i][j + 1] = j;
					dfs(depth + 1, ladders, i );
					ladders[i][j] = 0;
					ladders[i][j + 1] = 0;
				}
			}
		}
	}

	static int N, M, H, ans;

	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		ans = Integer.MAX_VALUE;
		rladders = new int[H + 1][N + 1];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			rladders[a][b] = b + 1;
			rladders[a][b + 1] = b;
		}
		dfs(0, rladders, 1);
		if(ans > 3) ans = -1;
		bw.write(ans + "");
		bw.close();
	}

}