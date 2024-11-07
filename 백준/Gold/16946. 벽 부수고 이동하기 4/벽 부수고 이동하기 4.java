import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	static int bfs(int sx, int sy, int num) {
		int cnt = 1;
		Deque<int[]> q = new ArrayDeque<>();
		q.offer(new int[] {sx, sy});
		v[sx][sy] = true;
		map[sx][sy] = num * -1;
		while(!q.isEmpty()) {
			int[] coord = q.poll();
			int x = coord[0];
			int y = coord[1];
			for(int i = 0 ; i < 4 ; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				if(0 <= nx && nx < N && 0 <= ny && ny < M) {
					if(!v[nx][ny] && map[nx][ny] == 0) {
						cnt++;
						q.offer(new int[] {nx, ny});
						v[nx][ny] = true;
						map[nx][ny] = num * -1;
					}
				}
			}
		}
		return cnt;
	}
	static int N, M;
	static int[][] map;
	static int[] dx = {1, 0, -1, 0};
	static int[] dy = {0, 1, 0, -1};
	static boolean[][] v;
	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		int[][] ans = new int[N][M];
		v = new boolean[N][M];
		for(int i = 0 ; i < N ; i++) {
			String[] input = br.readLine().split("");
			for(int j = 0 ; j < M ; j++) {
				map[i][j] = Integer.parseInt(input[j]);
			}
		}
		Map<Integer, Integer> m = new HashMap<>();
		int num = 1;
		for(int i = 0 ; i < N ; i++) {
			for(int j = 0 ; j < M ; j++) {
				if(map[i][j] == 0 && !v[i][j]) {
					int cnt = bfs(i, j, num);
					m.put(num, cnt);
					num++;
				}
			}
		}
		for(int i = 0 ; i < N ; i++) {
			for(int j = 0 ; j < M ; j++) {
				if(map[i][j] == 1) {
					int total = 0;
					Set<Integer> s = new HashSet<>();
					for(int x = 0 ; x < 4; x++) {
						int nx = i + dx[x];
						int ny = j + dy[x];
						if(0 <= nx && nx < N && 0 <= ny && ny < M && map[nx][ny] < 0) {
							int n = map[nx][ny] * -1;
							s.add(n);
						}
					}
					for(int e : s) {
						total += m.get(e);
					}
					ans[i][j] = total + 1;
				}
			}
		}
//		for(int[] row : map) {
//			System.out.println(Arrays.toString(row));
//		}
//		for(int key : m.keySet()) {
//			System.out.println(key + ": " + m.get(key));
//		}
		for(int[] row : ans) {
			for(int e : row) {
				bw.write((e%10) +"");
			}
			bw.write("\n");
		}
//		bw.write(dp[N][M] + "");
		bw.close();
	}

}