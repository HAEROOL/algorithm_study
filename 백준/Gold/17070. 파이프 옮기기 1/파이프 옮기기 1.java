import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int[][] map;
	static int N;
	static boolean[][] visited;
	static int ans = 0;
	static void dfs(int sx, int sy, int state, List<Integer> log) {
		if(state == 1 && (map[sx - 1][sy] != 0 || map[sx][sy - 1] != 0)) {
			return;
		}
		if (sx == N - 1 && sy == N - 1) {
			ans++;
//			System.out.println(log.toString());
			return;
		}
		// 가로일때
		if (state == 0) {
			int[] dx = {0, 1};
			int[] dy = {1, 1};
			for(int i = 0 ; i < 2 ; i++) {
				int nx = sx + dx[i];
				int ny = sy + dy[i];
				if(0 <= nx && nx < N && 0 <= ny && ny < N) {
					if(!visited[nx][ny] && map[nx][ny] == 0) {
						visited[nx][ny] = true;
						log.add(i);
						dfs(nx, ny, i, log);
						visited[nx][ny] = false;
						log.remove(0);
					}
				}
			}
		}
		// 대각선 일때
		else if (state == 1) {
			int[] dx = {0, 1, 1};
			int[] dy = {1, 1, 0};
			for(int i = 0 ; i < 3 ; i++) {
				int nx = sx + dx[i];
				int ny = sy + dy[i];
				if(0 <= nx && nx < N && 0 <= ny && ny < N) {
					if(!visited[nx][ny] && map[nx][ny] == 0) {
						log.add(i);
						dfs(nx, ny, i, log);
						visited[nx][ny] = false;
						log.remove(0);
					}
				}
			}
		}
		// 세로일때
		else if (state == 2) {
			int[] dx = {1, 1};
			int[] dy = {1, 0};
			for(int i = 1 ; i < 3 ; i++) {
				int nx = sx + dx[i - 1];
				int ny = sy + dy[i - 1];
				if(0 <= nx && nx < N && 0 <= ny && ny < N) {
					if(!visited[nx][ny] && map[nx][ny] == 0) {
						log.add(i);
						dfs(nx, ny, i, log);
						visited[nx][ny] = false;
						log.remove(0);
					}
				}
			}
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		visited = new boolean[N][N];
		StringTokenizer st;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		dfs(0, 1, 0, new ArrayList<Integer>());
		bw.write(ans + "");
		bw.close();
	}
}