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
	static int[][] map;
	static int N;
	static boolean[][] visited;
	static int[] dx = {1, 0, -1, 0};
	static int[] dy = {0, 1, 0, -1};
	static int ans = 0;
	static int[][] dp;
	static int dfs(int x, int y) {
		if(dp[x][y] != -1) return dp[x][y];
		dp[x][y] = 0;
		int cnt = 0;
		for(int i = 0 ; i < 4 ; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if(0 <= nx && nx < N && 0 <= ny && ny < N && map[x][y] < map[nx][ny]) {
				dp[x][y] = Math.max(dp[x][y], dfs(nx, ny) + 1);
				cnt++;
			}
		}
		if(cnt == 0) {
			dp[x][y] = 1;
			return dp[x][y];
		}
		return dp[x][y];
	}
	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		visited = new boolean[N][N];
		dp = new int[N][N];
		StringTokenizer st;
		for(int i = 0 ; i < N ; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0 ; j < N ; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		dp = new int[N][N];
		for(int i = 0 ; i < N ; i++) {
			for(int j = 0 ; j < N ; j++) {
				dp[i][j] = -1;
			}
		}
		for(int i = 0 ; i < N ; i++) {
			for(int j = 0 ; j < N ; j++) {
				dfs(i, j);
				ans = Math.max(dp[i][j], ans);
			}
		}
//		for(int[] row : dp) {
//			System.out.println(Arrays.toString(row));
//		}
		bw.write(ans + "");
		bw.close();
	}
}
