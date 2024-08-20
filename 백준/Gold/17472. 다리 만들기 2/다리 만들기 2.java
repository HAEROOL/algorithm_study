import java.io.*;
import java.util.*;

public class Main {
	static int N, M;
	static int[][] map;
	static int[] dx = { 1, 0, -1, 0 };
	static int[] dy = { 0, 1, 0, -1 };
	static List<int[]> bridges;
	static int ans = Integer.MAX_VALUE;
	static List<List<int[]>> islands;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int[] a = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		N = a[0];
		M = a[1];
		map = new int[N][M];

		for (int i = 0; i < N; i++) {
			int[] row = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			map[i] = row;
		}
		boolean[][] visited = new boolean[N][M];
		int n = 1;
		islands = new ArrayList<List<int[]>>();
		islands.add(new ArrayList<>());
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (!visited[i][j] && map[i][j] == 1) {
					List<int[]> l = new ArrayList<int[]>();
					Deque<int[]> q = new ArrayDeque<int[]>();
					visited[i][j] = true;
					map[i][j] = n;
					q.add(new int[] { i, j });
					l.add(new int[] { i, j });
					while (!q.isEmpty()) {
						int[] coord = q.poll();
						int x = coord[0];
						int y = coord[1];
						for (int d = 0; d < 4; d++) {
							int nx = x + dx[d];
							int ny = y + dy[d];
							if (0 <= nx && nx < N && 0 <= ny && ny < M) {
								if (!visited[nx][ny] && map[nx][ny] == 1) {
									visited[nx][ny] = true;
									map[nx][ny] = n;
									q.add(new int[] { nx, ny });
									l.add(new int[] { nx, ny });
								}
							}
						}
					}
					n++;
					islands.add(l);
				}
			}
		}
		bridges = new ArrayList<int[]>();
		int[][] distMap = new int[islands.size()][islands.size()];
		for (int i = 1; i < islands.size(); i++) {
			List<int[]> island = islands.get(i);
			for (int[] coord : island) {
				int x = coord[0];
				int y = coord[1];
				for (int d = 0; d < 4; d++) {
					int dist = 0;
					while (true) {
						int nx = x + dx[d];
						int ny = y + dy[d];
						dist++;
						if (0 <= nx && nx < N && 0 <= ny && ny < M) {
							if (map[nx][ny] == i)
								break;
							if (map[nx][ny] != 0) {
								if (dist == 2)
									break;
								dist--;
								int from = i;
								int to = map[nx][ny];
								if (distMap[from][to] == 0) {
									distMap[from][to] = dist;
									distMap[to][from] = dist;
								} else {
									distMap[from][to] = Math.min(distMap[from][to], dist);
									distMap[to][from] = Math.min(distMap[from][to], dist);
								}
								break;
							}
							x = nx;
							y = ny;
						} else {
							break;
						}
					}
					x = coord[0];
					y = coord[1];
				}
			}
		}
		for (int i = 0; i < distMap.length; i++) {
			for (int j = i + 1; j < distMap.length; j++) {
				if (distMap[i][j] != 0) {
					bridges.add(new int[] { i, j, distMap[i][j] });
				}
			}
		}
		comb(0, 0, new int[islands.size() - 2], bridges.size());
		System.out.println(ans == Integer.MAX_VALUE ? -1 : ans);
	}

	static void comb(int idx, int k, int[] sel, int c) {
		if (k > c) {
			return;
		}
		if (idx == sel.length) {
//			System.out.println(Arrays.toString(sel));
			int st = -1;
			int[][] newMap = new int[islands.size()][islands.size()];
			int total = 0;
			boolean[] v = new boolean[islands.size()];
			for (int j : sel) {
				int[] bridge = bridges.get(j);
				int from = bridge[0];
				int to = bridge[1];
				int cost = bridge[2];
				if (st == -1) {
					st = from;
				}
				total += cost;
				newMap[from][to] = cost;
				newMap[to][from] = cost;
			}
			dfs(newMap, v, st);
			boolean isconnect = true;;
			for (int j = 1; j < v.length; j++) {
				if (!v[j]) {
					isconnect = false;
					break;
				}
			}
			if(isconnect) {
				ans = Math.min(ans, total);
				
			}
			return;
		}
		
		sel[idx] = k;
		comb(idx + 1, k + 1, sel, c);
		comb(idx, k + 1, sel, c);
	}

	static void dfs(int[][] map, boolean[] v, int st) {
		v[st] = true;
		for (int i = 0; i < map[st].length; i++) {
			if (map[st][i] != 0 && !v[i]) {
				dfs(map, v, i);
			}
		}
	}
}