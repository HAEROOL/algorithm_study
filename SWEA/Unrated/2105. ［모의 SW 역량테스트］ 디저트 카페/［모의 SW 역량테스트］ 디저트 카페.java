import java.io.*;
import java.util.*;

public class Solution {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	public static void dfs(int x, int y, int sx, int sy, Set<Integer> dset, boolean[][] v, int prev) {
//		System.out.println(dset.size() + " " + x + " " + y);
		for (int i = prev; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if (0 <= nx && nx < N && 0 <= ny && ny < N) {
//				if(nx == 0 && ny == 2) {
//					System.out.println(dset.size());
////					System.out.println(Arrays.toString(cmds));
//					for(boolean[] row : v) {
//						System.out.println(Arrays.toString(row));
//					}
//					System.out.println();
//				}
				if (sx == nx && sy == ny && dset.size() > 3) {
					ans = Math.max(dset.size(), ans);
					return;
				}
				if (!dset.contains(map[nx][ny]) && !v[nx][ny]) {
					v[nx][ny] = true;
					dset.add(map[nx][ny]);

					dfs(nx, ny, sx, sy, dset, v, i);
					
					v[nx][ny] = false;
					dset.remove(map[nx][ny]);
				}
			}
		}
	}

	static int ans;
	// 좌하 / 우하 / 좌상 / 우상
	// 좌하 == 우상 & 우하 == 좌
	static int[] dx = { 1, 1, -1, -1 };
	static int[] dy = { -1, 1, 1, -1 };
	static int N;
	static int[][] map;

	public static void main(String[] args) throws IOException {
		int TC = Integer.parseInt(br.readLine());
		for (int tc = 1; tc < TC + 1; tc++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			ans = -1;
			StringTokenizer st;
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					Set<Integer> dset = new HashSet<>();
					dset.add(map[i][j]);
					boolean[][] v = new boolean[N][N];
					v[i][j] = true;
					dfs(i, j, i, j, dset, v, 0);
				}
			}
			bw.write("#" + tc + " " + ans + "\n");
		}
		bw.close();
	}
}