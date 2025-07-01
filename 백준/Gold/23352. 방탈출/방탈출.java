import java.util.*;
import java.io.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static int N, M;
	static int[][] map;
	static int[] dx = {1, 0, -1, 0};
	static int[] dy = {0, 1, 0, -1};
	static int[] bfs(int sx, int sy) {
		Deque<int[]> q = new ArrayDeque<>();
		boolean[][] v = new boolean[N][M];
		
		q.offer(new int[] {sx, sy});
		v[sx][sy] = true;
		int mx = 0;
		int lf = 0;
		while(!q.isEmpty()) {
			int size = q.size();
			lf++;
			int tmp = 0;
			for(int k = 0 ; k < size ; k++) {
				int[] coord = q.poll();
				int x = coord[0];
				int y = coord[1];
				tmp = Math.max(tmp, map[x][y]);
				for(int i = 0 ; i < 4 ; i++) {
					int nx = x + dx[i];
					int ny = y + dy[i];
					if(0 <= nx && nx < N && 0 <= ny && ny < M) {
						if(!v[nx][ny] && map[nx][ny] != 0) {
							q.offer(new int[] {nx, ny});
							v[nx][ny] = true;
						}
					}
				}
			}
			mx = tmp;
		}
//		System.out.println(map[sx][sy] + " " +  mx);
		if(lf == 1) return new int[] {lf, map[sx][sy]};
		return new int[] {lf, map[sx][sy] + mx};
	}
	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		for(int i = 0 ; i < N ; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0 ; j < M ; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int lf = -1;
		int ans = 0;
		for(int i = 0 ; i < N ; i++) {
			for(int j = 0 ; j < M ; j++) {
				if(map[i][j] == 0) continue;
				int[] res = bfs(i, j);
				if(lf < res[0]) {
					ans = res[1];
					lf = res[0];
				}else if(lf == res[0]) {
					ans = Math.max(ans, res[1]);
				}
			}
		}
		bw.write(ans+"");
		bw.close();
	}
}