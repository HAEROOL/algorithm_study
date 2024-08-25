import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		int[][] map = new int[N][M];
		for(int i = 0 ; i < N ; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0 ; j < M ; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for(int r = 0 ; r < R ; r++) {
			int x = 0;
			while(N/2 > x && M/2 > x) {
				// 상 이동
				int uptmp = map[x][x];
				for(int i = x ; i < M - x - 1 ; i++) {
					map[x][i] = map[x][i + 1];
				}
				// 좌 이동
				int lefttmp = map[N - 1 - x][x];
				for(int i = N - 1 - x ; i > x ; i--) {
					map[i][x] = map[i - 1][x];
				}
				map[x + 1][x] = uptmp;
				// 하 이동
				int downtmp = map[N - 1 - x][M - 1 - x];
				for(int i = M - 1 - x ; i > x ; i--) {
					map[N - 1 - x][i] = map[N - 1 - x][i - 1];
				}
				map[N - 1 - x][x + 1] = lefttmp;
				// 우 이동
				int righttmp = map[x][M - x - 1];
				for(int i = x ; i < N - 1 - x ; i++) {
					map[i][M - 1 - x] = map[i + 1][M - 1 - x];
				}
				map[N - 2 - x][M - 1 - x] = downtmp;
				map[x][M - 2 - x] = righttmp;
				x++;
			}
		}
		for(int[] row : map) {
			for(int i : row) {
				bw.write(i + " ");
			}
			bw.write("\n");
		}
		bw.flush();
		
		
	}
}