import java.util.*;
import java.io.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		String[][] map = new String[N][N];
		String[][] rgmap = new String[N][N];
		int[] dx = {1, 0, -1, 0};
		int[] dy = {0, 1, 0, -1};
		for(int i = 0 ; i < N ; i++) {
			String[] tmp = br.readLine().split("");
			for(int j = 0 ; j < N ; j++) {
				map[i][j] = tmp[j];
				rgmap[i][j] = tmp[j];
				if(rgmap[i][j].equals("G")) rgmap[i][j] = "R";
			}
		}
		boolean[][] v = new boolean[N][N];
		int rgbcnt = 0;
		int rgcnt = 0;
		for(int i = 0 ; i < N ; i++) {
			for(int j = 0 ; j < N ; j++) {
				if(!v[i][j]) {
					rgbcnt++;
					String base = map[i][j];
					Deque<int[]> q = new ArrayDeque<>();
					q.offer(new int[] {i, j});
					v[i][i] = true;
					while(!q.isEmpty()) {
						int[] coord = q.poll();
						for(int k = 0 ; k < 4 ; k++) {
							int nx = coord[0] + dx[k];
							int ny = coord[1] + dy[k];
							if(0 <= nx && nx < N && 0 <= ny && ny < N) {
								if(!v[nx][ny] && map[nx][ny].equals(base)) {
									q.offer(new int[] {nx, ny});
									v[nx][ny] = true;
								}
							}
						}
					}
				}
			}
		}
		v = new boolean[N][N];
		for(int i = 0 ; i < N ; i++) {
			for(int j = 0 ; j < N ; j++) {
				if(!v[i][j]) {
					rgcnt++;
					String base = rgmap[i][j];
					Deque<int[]> q = new ArrayDeque<>();
					q.offer(new int[] {i, j});
					v[i][i] = true;
					while(!q.isEmpty()) {
						int[] coord = q.poll();
						for(int k = 0 ; k < 4 ; k++) {
							int nx = coord[0] + dx[k];
							int ny = coord[1] + dy[k];
							if(0 <= nx && nx < N && 0 <= ny && ny < N) {
								if(!v[nx][ny] && rgmap[nx][ny].equals(base)) {
									q.offer(new int[] {nx, ny});
									v[nx][ny] = true;
								}
							}
						}
					}
				}
			}
		}
//		for(String[] row : map) {
//			System.out.println(Arrays.toString(row));
//		}
//		System.out.println();
//		for(String[] row : rgmap) {
//			System.out.println(Arrays.toString(row));
//		}
		bw.write(rgbcnt + " " + rgcnt);
		bw.close();
		
		
	}
}