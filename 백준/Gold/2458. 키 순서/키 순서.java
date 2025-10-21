import java.util.*;
import java.io.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		
		int M = Integer.parseInt(st.nextToken());
		
		int[][] f = new int[N + 1][N + 1];
		
		
		for(int i = 0 ; i < M ; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			f[a][b] = 1;
		}
		
		for(int k = 1 ; k < N + 1 ; k++) {
			for(int j = 1 ; j < N + 1 ; j++) {
				for(int i = 1 ; i < N  + 1 ; i++) {
					if(f[i][k] == 1 && f[k][j] == 1) {
						f[i][j] = 1;
					}
				}
			}
		}
//		for(int[] row : f) {
//			System.out.println(Arrays.toString(row));
//		}
		int answer = 0;
		for(int i = 1 ; i < N + 1 ; i++) {
			int cnt = 0;
			for(int j = 1 ; j < N + 1 ; j++) {
				if(i == j) continue;
				if(f[j][i] == 1) cnt++;
			}
			for(int j = 1 ; j < N + 1 ; j++) {
				if(i == j) continue;
				if(f[i][j] == 1) cnt++;
			}
			if(cnt == N - 1) answer++;
		}
		bw.write(answer +"");
		bw.close();
	}
}