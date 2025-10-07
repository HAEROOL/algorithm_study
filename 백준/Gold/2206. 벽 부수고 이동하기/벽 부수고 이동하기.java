import java.util.*;
import java.io.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static int[] dx = {1, 0, -1, 0};
	static int[] dy = {0, 1, 0, -1};
	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] map = new int[N + 1][M + 1];
		for(int i = 1 ; i < N + 1 ; i++) {
			String[] tmp = br.readLine().split("");
			for(int j = 1 ; j < M + 1 ; j++) {
				map[i][j] = Integer.parseInt(tmp[j - 1]);
			}
		}
		boolean[][][] v = new boolean[N + 1][M + 1][2];
		
		Deque<int[]> q = new ArrayDeque<>();
		q.offer(new int[] {1, 1, 0, 1});
		v[1][1][0] = true;
		int answer = -1;
		while(!q.isEmpty()) {
			int[] coord = q.poll();
			int x = coord[0];
			int y = coord[1];
			if(x == N && y == M) {
				answer = coord[3];
				break;
			}
			
			for(int i = 0 ; i < 4 ; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				if(0 < nx && nx <= N && 0 < ny && ny <= M) {
					if(map[nx][ny] == 0 && !v[nx][ny][coord[2]]) {
						v[nx][ny][coord[2]] = true;
						q.offer(new int[] {nx, ny, coord[2], coord[3] + 1});
					}else if(map[nx][ny] == 1) {
						if(coord[2] == 0) {
							v[nx][ny][1] = true;
							q.offer(new int[] {nx, ny, 1, coord[3] + 1});
						}
					}
				}
			}
			
		}
		bw.write(answer + "");
		bw.close();
		
		
	}
}