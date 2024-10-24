import java.io.*;
import java.util.*;

public class Solution {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static int N, M, R, C, L;
	static int[][] map;
	static int[] dx = {1, 0, -1, 0};
	static int[] dy = {0, 1, 0, -1};
	static int[][] pipeD = {
			{0, 1, 2, 3},
			{0, 2},
			{1, 3},
			{1, 2},
			{0, 1},
			{0, 3},
			{2, 3}
	};
	static boolean check(int nx, int ny, int x, int y) {
		int pipe = map[nx][ny] - 1;
		for(int i = 0 ; i < pipeD[pipe].length ; i++) {
			int nnx = nx + dx[pipeD[pipe][i]];
			int nny = ny + dy[pipeD[pipe][i]];
			if(0 <= nnx && nnx < N && 0 <= nny && nny < M) {
				if(nnx == x && nny == y) {
					return true;
				}
			}
		}
		return false;
	}
	static int bfs(int sx, int sy) {
		Deque<int[]> q = new ArrayDeque<>();
		q.add(new int[] {sx, sy});
		boolean[][] v = new boolean[N][M];
		v[sx][sy] = true;
		int time = 1;
		int cnt = 1;
		while(!q.isEmpty()) {
			if(time == L) break;
			int size = q.size();
			for(int s = 0 ; s < size ; s++) {
				int[] coord = q.poll();
				int x = coord[0];
				int y = coord[1];
				int pipe = map[x][y] - 1;
				for(int i = 0 ; i < pipeD[pipe].length ; i++) {
					int nx = x + dx[pipeD[pipe][i]];
					int ny = y + dy[pipeD[pipe][i]];
					if(0 <= nx && nx < N && 0 <= ny && ny < M && !v[nx][ny] && map[nx][ny] != 0) {
						if(check(nx, ny, x, y)) {
							cnt++;
							q.offer(new int[] {nx, ny});
							v[nx][ny] = true;
						}
					}
				}				
			}
			time++;
		}
		return cnt;
	}
	
	public static void main(String[] args) throws IOException {
		int TC = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= TC; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());
			map = new int[N][M];
			for(int i = 0 ; i < N ; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0 ; j < M ; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			int ans = bfs(R, C);
			bw.write("#" + tc + " " + ans + "\n");
		}
		bw.close();
	}

}
