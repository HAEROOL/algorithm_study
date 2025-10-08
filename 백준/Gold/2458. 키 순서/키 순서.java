import java.util.*;
import java.io.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] map = new int[N + 1][N + 1];
		for(int i = 0 ; i < N + 1 ; i++) {
			for(int j = 0 ; j < N + 1 ; j++) {
				map[i][j] = Integer.MAX_VALUE >> 1;
				if(i == j) map[i][j] = 0;
			}
		}
		for(int i = 0 ; i < M ; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			map[from][to] = 1;
		}
		
		for(int k = 1 ; k < N + 1 ; k++) {
			for(int i = 1 ; i < N + 1 ; i++) {
				for(int j = 1 ; j < N + 1 ; j++) {
					if(map[i][j] > map[i][k] + map[k][j]) {
						map[i][j] = 1;
					}
				}
			}
		}
		int answer = 0;
		for(int i = 1 ; i < N + 1 ; i++) {
			int cnt = 0;
			for(int j = 1 ; j < N + 1 ; j++) {
				if(map[i][j] == 1 || map[j][i] == 1) {
					cnt++;
				}
			}
			if(cnt == N - 1) answer++;
		}
		bw.write(answer+"");
		bw.close();
	}
}