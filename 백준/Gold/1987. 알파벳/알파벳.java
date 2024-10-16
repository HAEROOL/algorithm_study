import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static int N, M;
	static String[][] map;
	static boolean[] v = new boolean[26];
	static boolean visited[][];
	static int[] dx = { 1, 0, -1, 0 };
	static int[] dy = { 0, 1, 0, -1 };
	static int ans = -1;

	static void dfs(int x, int y, int depth) {
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if (0 <= nx && nx < N && 0 <= ny && ny < M && !visited[nx][ny] && !v[map[nx][ny].charAt(0) - 'A']) {
				visited[nx][ny] = true;
				v[map[nx][ny].charAt(0) - 'A'] = true;
				dfs(nx, ny, depth + 1);
				visited[nx][ny] = false;
				v[map[nx][ny].charAt(0) - 'A'] = false;
			}
		}
		ans = Math.max(ans, depth);
	}

	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new String[N][M];
		visited = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			String[] input = br.readLine().split("");
			for (int j = 0; j < M; j++) {
				map[i][j] = input[j];
			}
		}
		visited[0][0] = true;
		v[map[0][0].charAt(0) - 'A'] = true;
		dfs(0, 0, 1);
		bw.write(ans+"");
		bw.close();
	}
}