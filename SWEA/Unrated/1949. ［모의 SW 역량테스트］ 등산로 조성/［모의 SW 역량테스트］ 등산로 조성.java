import java.io.*;
import java.util.*;

public class Solution {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static int N, K, mx;
	static int[][] map;
	static boolean[][] v;
	static int[] dx = {1, 0, -1, 0};
	static int[] dy = {0, 1, 0, -1};
	static int ans = -1;
	static void dfs(int x, int y, int total, boolean iscut, int now, List<Integer> log) {
		for(int i = 0 ; i < 4 ; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if(0 <= nx && nx < N && 0 <= ny && ny < N && !v[nx][ny]) {
				if(map[nx][ny] < now) {
					v[nx][ny] = true;
					log.add(map[nx][ny]);
					dfs(nx, ny, total + 1, iscut, map[nx][ny], log);
					v[nx][ny] = false;
					log.remove(log.size() - 1);
				}
				else if(map[nx][ny] - K < now && !iscut) {
					for(int k = 1 ; k <= K ; k++) {
						if(map[nx][ny] - k < now) {
							v[nx][ny] = true;
							log.add(map[nx][ny] - k);
							dfs(nx, ny, total + 1, true, map[nx][ny] - k, log);		
							log.remove(log.size() - 1);
							v[nx][ny] = false;							
						}
					}
				}
			}
		}
//		if(ans <= total) {
//			System.out.println(log.toString());
//		}
		ans = Math.max(ans, total);
	}
	public static void main(String[] args) throws IOException {
		  int TC = Integer.parseInt(br.readLine());
		  for(int tc = 1 ; tc < TC + 1 ; tc++) {
			  StringTokenizer st = new StringTokenizer(br.readLine());
			  N = Integer.parseInt(st.nextToken());
			  K = Integer.parseInt(st.nextToken());
			  mx = -1;
			  map = new int[N][N];
			  ans = -1;
			  for(int i = 0 ; i < N ; i++) {
				  st = new StringTokenizer(br.readLine());
				  for(int j = 0 ; j < N ; j++) {
					  map[i][j] = Integer.parseInt(st.nextToken());
					  mx = Math.max(mx, map[i][j]);
				  }
			  }
			  
			  for(int i = 0 ; i < N ; i++) {
				  for(int j = 0 ; j < N ; j++) {
					  if(mx == map[i][j]) {
						  v = new boolean[N][N];
						  v[i][j] = true;
						  List<Integer> log = new ArrayList<>();
						  log.add(map[i][j]);
						  dfs(i, j, 1, false, map[i][j], log);
					  }
				  }
			  }
			  bw.write("#" + tc + " " + ans + "\n");
		  }
		  bw.close();
	}
}