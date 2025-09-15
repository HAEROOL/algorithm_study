import java.util.*;
import java.io.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static int[] dx = {1, 0, -1, 0, -1, -1, 1, 1};
	static int[] dy = {0, 1, 0, -1, -1, 1, -1, 1};
	static int[][] board;
	static int N, M;
	static int bfs(int sx, int sy) {
		boolean[][] v = new boolean[N][M];
		Deque<int[]> q = new ArrayDeque<>();
		q.offer(new int[] {sx, sy, 0});
		v[sx][sy] = true;
		int res = Integer.MAX_VALUE;
		while(!q.isEmpty()) {
			int[] coord = q.poll();
			int x = coord[0];
			int y = coord[1];
			
			if(board[x][y] == 1) {
				res = Math.min(res, coord[2]);
			}
			
			for(int i = 0 ; i < 8 ; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				if(0 <= nx && nx < N && 0 <= ny && ny < M && !v[nx][ny]) {
					q.offer(new int[] {nx, ny, coord[2] + 1});
					v[nx][ny] = true;
				}
			}
		}
		return res;
	}
	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int answer = 0;
		board = new int[N][M];
		
		for(int i = 0 ; i < N ; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0 ; j < M ; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for(int i = 0 ; i < N ; i ++) {
			for(int j = 0 ; j < M ; j++) {
				if(board[i][j] == 0) {
					answer = Math.max(answer, bfs(i, j));
				}
			}
		}
		bw.write(answer + "");
		bw.close();
	}
}