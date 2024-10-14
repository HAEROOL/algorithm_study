import java.io.*;
import java.util.*;
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static int N, M, ans = Integer.MAX_VALUE;
	static int[][] map;
	static int[][] visited;
	static int[] dx = {1, 0, -1, 0};
	static int[] dy = {0, 1, 0, -1};
	static void bfs(int x, int y) {
		PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> {
			return a[2] - b[2];
		});
		q.add(new int[] {x, y, 0});
		while(!q.isEmpty()) {
			int[] n = q.poll();
			int nodex = n[0];
			int nodey = n[1];
			if(nodex == N - 1 && nodey == M - 1) {
				visited[nodex][nodey] = n[2];
				return;
			}
			if(visited[nodex][nodey] != -1) continue;
			visited[nodex][nodey] = n[2];
			for(int i = 0 ; i < 4 ; i++) {
				int nx = nodex + dx[i];
				int ny = nodey + dy[i];
				if(0 <= nx && nx < N && 0 <= ny && ny < M) {
					if(map[nx][ny] == 1) {
						q.offer(new int[] {nx, ny, n[2] + 1});
					}else {
						q.offer(new int[] {nx, ny, n[2]});
					}
				}
			}
		}
	}
	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		visited = new int[N][M];
		for(int i = 0 ; i < N ; i++) {
			String[] input = br.readLine().split("");
			for(int j = 0 ; j < M ; j++) {
				map[i][j] = Integer.parseInt(input[j]);
				visited[i][j] = -1;
			}
		}
		bfs(0, 0);
		bw.write(visited[N - 1][M - 1]+"");
		bw.close();
	}
}