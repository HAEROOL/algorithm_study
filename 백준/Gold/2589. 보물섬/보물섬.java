import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	static int N, M; 
	static String[][] map;
	static int[] dx = {1, 0, -1, 0};
	static int[] dy = {0, 1, 0, -1};
	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new String[N][M];
		for(int i = 0 ; i < N ; i++) {
			String[] input = br.readLine().split("");
			for(int j = 0 ; j < M ; j++) {
				map[i][j] = input[j];
			}
		}
		int ans = 0;
		for(int i = 0 ; i < N ; i++) {
			for(int j = 0 ; j < M ; j++) {
				if(map[i][j].equals("L")) {
					int[][] v = new int[N][M];
					Deque<int[]> q = new ArrayDeque<>();
					q.add(new int[] {i, j});
					v[i][j] = 1;
					while(!q.isEmpty()) {
						int[] coord = q.poll();
						int x = coord[0];
						int y = coord[1];
						for(int d = 0 ; d < 4 ; d++) {
							int nx = x + dx[d];
							int ny = y + dy[d];
							if(0 <= nx && nx < N && 0 <= ny && ny < M && v[nx][ny] == 0 && map[nx][ny].equals("L")) {
								q.add(new int[] {nx, ny});
								v[nx][ny] = v[x][y] + 1;
//								System.out.println(x + " " + y);
							}
						}
					}
					for(int[] row : v) {
//						System.out.println(Arrays.toString(row));
						for(int e : row) {
							ans = Math.max(ans, e - 1);
						}
					}
					
				}
			}
		}
		bw.write(ans + "");
		bw.close();
	}

}
