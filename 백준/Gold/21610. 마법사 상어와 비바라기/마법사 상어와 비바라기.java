import java.util.*;
import java.io.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static int[] dx = {0, -1, -1, -1, 0, 1, 1, 1};
	static int[] dy = {-1, -1, 0, 1, 1, 1, 0, -1};
	static int[][] copyMap(int[][] map){
		int[][]tmp = new int[map.length][map.length];
		for(int i = 0 ; i < map.length ; i++) {
			for(int j = 0 ; j < map.length ; j++) {
				tmp[i][j] = map[i][j];
			}
		}
		return tmp;
	}
	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N, M;
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int[][] map = new int[N + 1][N + 1];
		for(int i = 1 ; i < N + 1 ; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 1 ; j < N + 1 ; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		List<int[]> clouds = new ArrayList<>();
		clouds.add(new int[] {N, 1});
		clouds.add(new int[] {N, 2});
		clouds.add(new int[] {N - 1, 1});
		clouds.add(new int[] {N - 1, 2});
		for(int m = 0 ; m < M ; m++) {
			st = new StringTokenizer(br.readLine());
			int d, s;
			d = Integer.parseInt(st.nextToken()) - 1;
			s = Integer.parseInt(st.nextToken());
			int[][] tmpMap = copyMap(map);
			boolean[][] v = new boolean[N + 1][N + 1];
			List<int[]> candis = new ArrayList<>();
			// 1단계, 2단계, 3단
			for(int[] cloud : clouds) {
				int cx = cloud[0];
				int cy = cloud[1];
				for(int i = 0 ; i < s ; i++) {
					cx += dx[d];
					if(cx <= 0) cx = N;
					else if(cx > N) cx = 1;
					cy += dy[d];
					if(cy <= 0) cy = N;
					else if(cy > N) cy = 1;
				}
				tmpMap[cx][cy]++;
				candis.add(new int[] {cx, cy});
				v[cx][cy] = true;
			}
//			System.out.println(1);
//			for(int[] row : tmpMap) {
//				System.out.println(Arrays.toString(row));
//			}
//			System.out.println();
			
			// 4단계
			int[] cdx = {-1, -1, 1, 1};
			int[] cdy = {-1, 1, 1, -1};
			for(int[] c : candis) {
				int cx = c[0];
				int cy = c[1];
				int cnt = 0;
				for(int i = 0 ; i < 4 ; i++) {
					int ncx = cx  + cdx[i];
					int ncy = cy + cdy[i];
					if(1 <= ncx && ncx <= N && 1 <= ncy && ncy <= N && tmpMap[ncx][ncy] > 0) {
						cnt++;
					}
				}
				tmpMap[cx][cy] += cnt;
			}
//			System.out.println(2);
//			for(int[] row : tmpMap) {
//				System.out.println(Arrays.toString(row));
//			}
//			System.out.println();
			
			// 5단계
			clouds = new ArrayList<>();
			for(int i = 1 ; i < N + 1 ; i++) {
				for(int j = 1 ; j < N + 1 ; j++) {
					if(tmpMap[i][j] >= 2 && !v[i][j]) {
						tmpMap[i][j] -= 2;
						clouds.add(new int[] {i, j});
					}
				}
			}
			
//			System.out.println(3);
//			for(int[] row : tmpMap) {
//				System.out.println(Arrays.toString(row));
//			}
//			System.out.println();
			map = tmpMap;
		}
		int ans = 0;
		for(int[] row : map) {
			for(int e : row) {
				ans += e;
			}
		}
		bw.write(ans + "");
		bw.close();
	}
}