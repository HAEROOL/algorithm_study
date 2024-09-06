import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static int total;
	static int[][] pipeD = {
			{0, 1, 2, 3},
			{0, 2},
			{1, 3},
			{1, 2},
			{0, 1},
			{0, 3},
			{2, 3}
	};

	static int[] dx = {1, 0, -1, 0};
	static int[] dy = {0, 1, 0, -1};
	static int N, M, R, C, L;
	static int[][] map;
	
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
	
	static void bfs() {
		Deque<int[]> q = new ArrayDeque<>();
		boolean[][] visited = new boolean[N][M];
		q.offer(new int[] {R, C});
		visited[R][C] = true;
		total = 1;
		int time = 1;
		while(!q.isEmpty()) {
			int size = q.size();
			if(time == L) return;
			for(int s = 0 ; s < size ; s++) {
				int[] coord = q.poll();
				int x = coord[0];
				int y = coord[1];
				int pipe = map[x][y] - 1;
				for(int i = 0 ; i < pipeD[pipe].length ; i++) {
					int nx = x + dx[pipeD[pipe][i]];
					int ny = y + dy[pipeD[pipe][i]];
					if(0 <= nx && nx < N && 0 <= ny && ny < M) {
						if(!visited[nx][ny] && map[nx][ny] != 0 && check(nx, ny, x, y)) {
							q.offer(new int[] {nx, ny});
							visited[nx][ny] = true;
							total += 1;
						}
					}
				}
			}
			time++;
		}
	}
	
	public static void main(String[] args) throws IOException {
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc < T + 1; tc++) {
			total = 0;
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
			bfs();
			bw.write("#" + tc + " " + total + "\n");
		}
		bw.close();
	}
}
