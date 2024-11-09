import java.io.*;
import java.util.*;

public class Solution {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static int N;
	static int[][] map;
	static List<int[]> cores;
	static int[] dx = {1, 0, -1, 0};
	static int[] dy = {0, 1, 0, -1};
	static int[][] copyMap(int[][] board) {
		int[][] res = new int[N][N];
		for(int i = 0 ; i < N ; i++) {
			for(int j = 0 ; j < N ; j++) {
				res[i][j] = board[i][j];
			}
		}
		return res;
	}
	static void backtracking(int idx, int totalWire, int totalCore, int[][] board) {
//		for(int[] row : board) {
//			System.out.println(Arrays.toString(row));
//		}
//		System.out.println();
		if(idx == cores.size()) {
			if(totalCore > ansCore) {
				ansCore = totalCore;
				ansWire = totalWire;
			}else if(totalCore == ansCore && ansWire > totalWire) {
				ansWire = totalWire;
			}
			return;
		}
		if(cores.size() - idx + totalCore < ansCore) return;
		int x = cores.get(idx)[0];
		int y = cores.get(idx)[1];
		int[][] tmp = copyMap(board);
		backtracking(idx + 1, totalWire, totalCore, tmp);
		for(int i = 0 ; i < 4 ; i++) {
			int res = count(x, y, i, board);
			if(res == -1)continue;
			tmp = copyMap(board);
			for(int j = 1 ; j < res + 1 ; j++) {
				int nx = x + dx[i] * j;
				int ny = y + dy[i] * j;
				tmp[nx][ny] = 2;
			}
			backtracking(idx + 1, totalWire + res, totalCore + 1, tmp);
		}
	}
	static int ansCore = 0;
	static int ansWire = 0;
	static int count(int x, int y, int d, int[][] board) {
		int cnt = 0;
		while(true) {
			int nx = x + dx[d];
			int ny = y + dy[d];
			cnt++;
			if(0 < nx && nx < N - 1 && 0 < ny && ny < N - 1 && board[nx][ny] == 0) {
				x = nx;
				y = ny;
			}else {
//				System.out.println(nx + " " + ny );
				if((0 == nx || nx == N - 1 || 0 == ny || ny == N - 1) && board[nx][ny] == 0) {
					break;
				}else {
					cnt = -1;
					break;
				}
			}
		}
		return cnt;
	}
	public static void main(String[] args) throws IOException {
		int TC = Integer.parseInt(br.readLine());
		for (int tc = 1; tc < TC + 1; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			map = new int[N][N];
			cores = new ArrayList<>();
			ansCore = 0;
			ansWire = 0;
			for(int i = 0 ; i < N ; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0 ; j < N ; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if(map[i][j] == 1 && (i > 0 && i < N - 1) && (j > 0 && j < N - 1)) {
						cores.add(new int[] {i, j});
					}
				}
			}
			backtracking(0, 0, 0, map);
			bw.write("#" + tc + " " + ansWire + "\n");
		}
		bw.close();
	}
}