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

import java.io.*;
import java.util.*;

public class Main {
	static int N, L, R;
	static int[][] map;
	static boolean[][] visited;
	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {1, 0, -1, 0};
	static void bfs(int sx, int sy, int[][] newmap) {
		Deque<int[]> q = new ArrayDeque<int[]>();
		List<int[]> l = new ArrayList<int[]>();
		int[] n = {sx, sy};
		q.offer(n);
		l.add(n);
		visited[sx][sy] = true;
		int totalP = map[sx][sy];
		int cntry = 1;
		while(!q.isEmpty()){
			int[] coord = q.poll();
			int x = coord[0];
			int y = coord[1];
			for(int i = 0 ; i < 4 ; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i]; 
				if(0 <= nx && nx < N && 0 <= ny && ny < N && !visited[nx][ny]) {
					int tmp = Math.abs(map[x][y] - map[nx][ny]);
					if(L <= tmp && tmp <= R) {
						int[] next = {nx, ny};
						q.offer(next);
						l.add(next);
						visited[nx][ny] = true;
						totalP += map[nx][ny];
						cntry++;
					}
				}
			}
		}
		int res = totalP / cntry;
		for(int[] coord : l) {
			int x = coord[0];
			int y = coord[1];
			newmap[x][y] = res;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		// 입력 및 초기화
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		int ans = 0;
		map = new int[N][N];
		for(int i = 0; i < N ; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0 ; j < N ; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		//연합 구하기
		while(true) {
			ans++;
			visited = new boolean[N][N];
			int[][] newmap = new int[N][N];
			int cnt = 0;
			for(int i = 0 ; i < N ; i++) {
				for(int j = 0 ; j < N ; j++) {
					if(!visited[i][j]) {
						cnt++;
						bfs(i, j, newmap);
					}
				}
			}
			if(cnt == N * N) break;
			for(int i = 0 ; i < newmap.length ; i++) {
				map[i] = newmap[i].clone();
			}
		}
		
		
		bw.write(ans - 1 +"");
		bw.flush();
		bw.close();
		br.close();		
	}
}