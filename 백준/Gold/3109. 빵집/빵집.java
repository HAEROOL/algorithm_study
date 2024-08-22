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
	static int[] dx = {-1, 0, 1};
	static int[] dy = {1, 1, 1};
	static String[][] map;
	static int cnt = 0;
	static boolean[][] visited;
	static int R, C;
	static boolean dfs(int x, int y) {
		if(y == C - 1) {
			cnt++;
			visited[x][y] = true;
			return true;
		}
		for(int i = 0 ; i < 3 ; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if(0 <= nx && nx < R && 0 <= ny && ny < C && !visited[nx][ny] && map[nx][ny].equals(".")) {
				if(dfs(nx, ny)) {
					visited[nx][ny] = true;
					return true;
				}else {
					map[nx][ny] = "x";
				}
			}
		}
		return false;
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		// 입력 및 초기화
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new String[R][C];
		visited = new boolean[R][C];
		for(int i = 0 ; i < R ; i++) {
			String[] arr = br.readLine().split("");
			for(int j = 0 ; j < C ; j++) {
				map[i][j] = arr[j];
			}
		}
		
		for(int i = 0 ; i < R ; i++) {
			dfs(i, 0);
		}
		bw.write(cnt + "");
		bw.flush();
		br.close();
		bw.close();
		
		
	}
}