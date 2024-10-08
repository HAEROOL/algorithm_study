import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;


public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static int[][] map;
	static int M, N;
	static int[][] dp;
	static int[] dx = {1, 0, -1, 0};
	static int[] dy = {0, 1, 0, -1};
	static int dfs(int x, int y) {
		if(x == M - 1 && y == N - 1) {
			return 1;
		}
		if(dp[x][y] != -1) {
			return dp[x][y];
		}
		dp[x][y] = 0;
		for(int i = 0 ; i < 4 ; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if(0 <= nx && nx < M && 0 <= ny && ny < N && map[x][y] > map[nx][ny]) {
				dp[x][y] += dfs(nx, ny);
			}
		}
		return dp[x][y];
	}
	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		map = new int[M][N];
		dp = new int[M][N];		
		for(int i = 0 ; i < M ; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0 ; j < N ; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				dp[i][j] = -1;
			}
		}
		int ans = dfs(0, 0);
		System.out.println(ans);
		
		
		
	}
}