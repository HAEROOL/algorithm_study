import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static void main(String[] args) throws IOException {
		int n = Integer.parseInt(br.readLine());
		int num = Integer.parseInt(br.readLine());
		int[][] map = new int[n + 1][n + 1];
		for(int i = 0 ; i < n + 1 ; i++) {
			for(int j = 0 ; j < n + 1 ; j++) {
				map[i][j] = Integer.MAX_VALUE;
			}
		}
		for(int i = 0 ; i < n + 1 ; i++) {
			map[i][i] = 0;
		}
		StringTokenizer st;
		for(int i = 0 ; i < num ;i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			map[from][to] = Math.min(map[from][to], cost);
		}
		
		for(int k = 1 ; k < n + 1 ; k++) {
			for(int i = 1 ; i < n + 1 ; i++) {
				for(int j = 1 ; j < n + 1 ; j++) {
					if(map[i][k] != Integer.MAX_VALUE && map[k][j] != Integer.MAX_VALUE) {
						map[i][j] = Math.min(map[i][j], map[i][k] + map[k][j]);						
					}
				}
			}
		}
		
		for(int i = 1 ; i < n + 1 ; i++) {
			for(int j = 1 ; j < n + 1 ; j++) {
				if(map[i][j] == Integer.MAX_VALUE) {
					System.out.print(0 + " ");
					continue;
				}
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}
}