import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static int N = 5;
	static int[][] board = new int[N][N];

	public static void main(String[] args) throws IOException {
		StringTokenizer st;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int time = 0;

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				int line = 0;
				time++;
				int t = Integer.parseInt(st.nextToken());
				int bx = -1, by = -1;
				for (int x = 0; x < N; x++) {
					for (int y = 0; y < N; y++) {
						if (board[x][y] == t) {
							board[x][y] = 0;
							bx = x;
							by = y;
							break;
						}
					}
					if (bx != -1)
						break;
				}
				if (bx == -1)
					continue;
				
				for(int x = 0 ; x < N ; x++) {
					int cnt = 0;
					for(int y = 0 ; y < N ; y++) {
						if(board[x][y] == 0) cnt++;
					}
					if(cnt >= 5) line++;
				}
				for(int y = 0 ; y < N ; y++) {
					int cnt = 0;
					for(int x = 0 ; x < N ; x++) {
						if(board[x][y] == 0) cnt++;
					}
					if(cnt >= 5) line++;
				}
				int cnt = 0;
				for(int x = 0 ; x < N ; x++) {
					if(board[x][x] == 0) cnt++;
				}
				if(cnt >= 5) line++;
				cnt = 0;
				for(int x = 4 ; x > -1 ; x--) {
					if(board[N - x - 1][x] == 0) cnt++;
				}
				if(cnt >= 5) line++;
				if (line >= 3) {
					System.out.println(time);
					return;
				}
			}
		}

	}
}