import java.util.*;
import java.io.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static void main(String[] args) throws IOException {
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		int[][] map = new int[n + 1][n + 1];
		int MAX_VAL = Integer.MAX_VALUE >> 1;
		for(int i = 1 ; i < n + 1 ; i++) {
			for(int j = 1 ; j < n + 1 ; j++) {
				if(i == j) continue;
				map[i][j] = MAX_VAL;
			}
		}
		StringTokenizer st;
		for(int i = 0 ; i < m ; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			
			map[from][to] = Math.min(cost, map[from][to]);
//			map[to][from] = Math.min(cost, map[to][from]);
		}
		for(int k = 1 ; k < n + 1 ; k++) {
			for(int i = 1 ; i < n + 1 ; i++) {
				for(int j = 1 ; j < n + 1 ; j++) {
					if(map[i][j] > map[i][k] + map[k][j]) map[i][j] =  map[i][k] + map[k][j];
				}
			}
		}
		for(int i = 1 ; i < n + 1 ; i ++) {
			for(int j = 1 ; j < n + 1 ; j++) {
				bw.write(map[i][j] == MAX_VAL?0+" " : map[i][j] +  " ");
			}
			bw.write("\n");
		}
		bw.close();
	}
}