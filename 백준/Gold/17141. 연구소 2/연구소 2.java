import java.util.*;
import java.io.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static void combination(int idx, int k, int[] sel) {
		if(idx == sel.length) {
//			System.out.println(Arrays.toString(sel));
			cal(sel);
			return;
		}
		if(k == viruses.size()) return;
		
		combination(idx, k + 1, sel);
		sel[idx] = k;
		combination(idx + 1, k + 1, sel);
	}
	static void cal(int[] sel) {
		int[][] copyMap = new int[N][N];
		for(int i = 0 ; i < N ; i++) {
			for(int j = 0 ; j < N ; j++) {
				copyMap[i][j] = map[i][j];
			}
		}
		boolean[][] v = new boolean[N][N];
		Deque<int[]> q = new ArrayDeque<>();
		for(int idx : sel) {
			int[] coord = viruses.get(idx);
			copyMap[coord[0]][coord[1]] = 2;
			v[coord[0]][coord[1]] = true;
			q.offer(new int[] {coord[0], coord[1]});
		}
		int time = 0;
		while(!q.isEmpty()) {
			int size = q.size();
			for(int j = 0 ; j < size ; j++) {
				int[] coord = q.poll();
				int x = coord[0];
				int y = coord[1];
				for(int i = 0 ; i < 4 ; i++) {
					int nx = x + dx[i];
					int ny = y + dy[i];
					if(0 <= nx && nx < N && 0 <= ny && ny < N) {
						if(!v[nx][ny] && copyMap[nx][ny] == 0) {
							q.offer(new int[] {nx, ny});
							v[nx][ny] = true;
						}
					}
				}
			}
			time++;
		}
		for(int i = 0 ; i < N ; i++) {
			for(int j = 0 ; j < N ; j++) {
				if(map[i][j] == 0 && !v[i][j]) {
					time = -1;
					break;
				}
			}
			if(time == -1) break;
		}
		if(time != -1) answer = Math.min(time - 1, answer);
	}
	static int N, M;
	static int[][] map;
	static int[] dx = {1, 0, -1, 0};
	static int[] dy = {0, 1, 0, -1};
	static int answer = Integer.MAX_VALUE;
	static List<int[]> viruses = new ArrayList<>();
	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][N];
		
		for(int i = 0 ; i < N ; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0 ; j < N ; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 2) {
					viruses.add(new int[] {i, j});
					map[i][j] = 0;
				}
			}
		}
		
		combination(0, 0, new int[M]);
		bw.write(answer == Integer.MAX_VALUE? "-1" : (answer + ""));
		bw.close();
		
		
	}
}