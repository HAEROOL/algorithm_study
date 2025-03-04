import java.io.*;
import java.util.*;

public class Main {
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int N;
	static int[][] map;
	static int[][] memo;
	static int INF = Integer.MAX_VALUE >> 1;
	static int dp(int x, int bit) {
		if(bit == (1 << N) - 1) {
			return map[x][0] != 0 ? map[x][0] : INF; 
		}
		if(memo[x][bit] != -1) return memo[x][bit];
		memo[x][bit] = INF;
		for(int i = 0 ; i < N ; i++) {
			if(map[x][i] != 0 && ((bit & (1 <<i)) == 0)) {
				memo[x][bit] = Math.min(memo[x][bit], dp(i, bit | (1 << i)) + map[x][i]);
			}
		}
		return memo[x][bit];
	}
	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		memo = new int[N][1 << N];
		for(int i = 0 ; i < N ; i++) {
			Arrays.fill(memo[i], -1);
			st = new StringTokenizer(br.readLine());
			for(int j = 0 ; j < N ; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		dp(0, 1);
		bw.write(memo[0][1] + "");
		
		bw.close();
	}

}