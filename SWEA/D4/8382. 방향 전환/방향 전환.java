import java.io.*;
import java.util.*;

public class Solution {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static int[] dy = { 1, -1, 0, 0 };
	static int[] dx = { 0, 0, 1, -1 };
	static int x1, x2, y1, y2;
	static int ans;
	static boolean[][][] v;
	static void bfs(int sx, int sy, int d) {
		v = new boolean[202][202][2];
		Deque<int[]> q = new ArrayDeque<>();
		q.add(new int[] {sx, sy, d, 0});
		v[sy][sx][d] = true;
		while(!q.isEmpty()) {
				int[] coord = q.poll();
				int x = coord[0];
				int y = coord[1];
				int dir = coord[2];
				int cnt = coord[3];
				if(x == x2 && y == y2) {
					ans = Math.min(ans, cnt);
					return;
				}
				if(dir == 1) {
					for(int i = 2 ; i < 4 ; i++) {
						int nx = x + dx[i];
						int ny = y + dy[i];
						if(0 <= nx && nx < 202 && 0 <= ny && ny < 202) {
							if(!v[ny][nx][dir]) {
								v[ny][nx][dir] = true;
								q.add(new int[] {nx, ny, 0, cnt + 1});
							}
						}
					}
				}else {
					for(int i = 0 ; i < 2 ; i++) {
						int nx = x + dx[i];
						int ny = y + dy[i];
						if(0 <= nx && nx < 202 && 0 <= ny && ny < 202) {
							if(!v[ny][nx][dir]) {
								v[ny][nx][dir] = true;
								q.add(new int[] {nx, ny, 1, cnt + 1});
							}
						}
					}
				}
		}
	}
	public static void main(String[] args) throws IOException {
		int TC = Integer.parseInt(br.readLine());
		for (int tc = 1; tc < TC + 1; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			ans = Integer.MAX_VALUE;
			x1 = Integer.parseInt(st.nextToken()) + 100;
			y1 = Integer.parseInt(st.nextToken()) + 100;
			x2 = Integer.parseInt(st.nextToken()) + 100;
			y2 = Integer.parseInt(st.nextToken()) + 100;
			bfs(x1, y1, 0);
			bfs(x1, y1, 1);
			bw.write("#" + tc + " " + ans + "\n");
		}
		bw.close();
	}
}