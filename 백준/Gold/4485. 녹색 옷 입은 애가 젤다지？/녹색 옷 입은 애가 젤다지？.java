import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static int dijkstra() {
		int[][] dist = new int[N][N];
		boolean[][] v = new boolean[N][N];
		
		for(int i = 0 ; i < N ; i++) {
			Arrays.fill(dist[i], Integer.MAX_VALUE);
		}
		
		PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> {
			return a[2] - b[2];
		});
		q.add(new int[] {0, 0, map[0][0]});
		dist[0][0] = map[0][0];
		
		while(!q.isEmpty()) {
			int[] n = q.poll();
			int x = n[0];
			int y = n[1];
			int cost = n[2];
			if(v[x][y])continue;
			v[x][y] = true;
			for(int i = 0 ; i < 4 ; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				if(0 <= nx && nx < N && 0 <= ny && ny < N) {
					if(dist[nx][ny] > dist[x][y] + map[nx][ny]) {
						dist[nx][ny] = dist[x][y] + map[nx][ny];
						q.add(new int[] {nx, ny, dist[nx][ny]});
					}
				}
			}
		}
		return dist[N-1][N-1];
	}
	static int[] dx = {1, 0, -1, 0};
	static int[] dy = {0, 1, 0, -1};
	static int N;
	static int[][] map;
	public static void main(String[] args) throws IOException {
		int cnt = 1;
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			if(N == 0) break;
			map = new int[N][N];
			for(int i = 0 ; i < N ; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0 ; j < N ; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			int ans = dijkstra();
			bw.write("Problem " + cnt + ": " + ans + "\n");
			cnt++;
		}
		bw.close();
	}

}