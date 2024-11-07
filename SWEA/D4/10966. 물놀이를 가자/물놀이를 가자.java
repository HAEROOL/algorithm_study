import java.io.*;
import java.util.*;

public class Solution {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static int[] dy = { 1, -1, 0, 0 };
	static int[] dx = { 0, 0, 1, -1 };

	static int bfs(Deque<int[]> q) {
		int[][] v = new int[N][M];
		for(int[] coord : q) {
			int x = coord[0];
			int y = coord[1];
			v[x][y] = 1;
		}
		while(!q.isEmpty()) {
			int[] coord = q.poll();
			int x = coord[0];
			int y = coord[1];
			for(int i = 0 ; i < 4 ; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				if(0 <= nx && nx < N && 0 <= ny && ny < M) {
					if(v[nx][ny] == 0 && map[nx][ny].equals("L")) {
						v[nx][ny] = v[x][y] + 1;
						q.offer(new int[] {nx, ny});
					}
				}
			}
		}
		int total = 0;
		for(int[] row : v) {
			for(int e : row) {
				total += e-1;
			}
		}
		return total;
	}

	static int N, M;
	static String[][] map;
	public static void main(String[] args) throws IOException {
		int TC = Integer.parseInt(br.readLine());
		for (int tc = 1; tc < TC + 1; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			map = new String[N][M];
			Deque<int[]> q = new ArrayDeque<>();
			for (int i = 0; i < N; i++) {
				String[] input = br.readLine().split("");
				for (int j = 0; j < M; j++) {
					map[i][j] = input[j];
					if (map[i][j].equals("W")) {
						q.add(new int[] { i, j });
					}
				}
			}
			int ans = bfs(q);

			bw.write("#" + tc + " " + ans + "\n");
		}
		bw.close();
	}
}