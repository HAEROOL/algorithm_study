import java.io.*;
import java.util.*;

public class Solution {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static int[][] map;
	static void copyBoard(int[][] tmp) {
		for(int i = 0 ; i < map.length ; i++) {
			for(int j = 0 ; j < map[i].length ; j++) {
				tmp[i][j] = map[i][j];
			}
		}
	}
	static class Cell {
		int id, val, dir, r, c, mxval;
		public Cell(int id, int r, int c, int val, int dir) {
			this.id = id;
			this.val = val;
			this.dir = dir;
			this.r = r;
			this.c = c;
			this.mxval = val;
		}
		
		void move(int[][] board){
			// 해당 방향으로 이동
			// 이동한자리가 끝자리면 val / 2
			// 이동한 자리에 다른 놈 있으면 합치기
			int nr = r + dx[dir];
			int nc = c + dy[dir];
			if(0 <= nr && nr < N && 0 <= nc && nc < N) {
				if(nr == 0 || nr == N - 1 || nc == 0 || nc == N - 1) {
					val /= 2;
					if(val == 0) {
						cells[this.id] = null;
						return;
					}
				}
				r = nr;
				c = nc;
			}else {
				if(dir == 1) dir = 2;
				else if(dir == 2) dir = 1;
				else if(dir == 3) dir = 4;
				else if(dir == 4) dir = 3;
				r += dx[dir];
				c += dy[dir];
			}
			
			if(board[r][c] != 0) {
				if (cells[board[r][c]].mxval > this.val) {
					cells[board[r][c]].val += this.val;
					cells[this.id] = null;
				}else {
					this.val += cells[board[r][c]].val;
					cells[board[r][c]] = null;
					board[r][c] = this.id;
				}
			}else {
				board[r][c] = this.id;
			}
		}
		
	}
	static int[] dx = {0, -1, 1, 0, 0};
	static int[] dy = {0, 0, 0, -1, 1};
	static int N, M, K;
	static Cell[] cells;
	public static void main(String[] args) throws IOException {
		int TC = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= TC; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			map = new int[N][N];
			cells = new Cell[K + 1];
			for(int i = 1 ; i < K + 1 ; i++) {
				st = new StringTokenizer(br.readLine());
				int r = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				int val = Integer.parseInt(st.nextToken());
				int dir = Integer.parseInt(st.nextToken());
				cells[i] = new Cell(i, r, c, val, dir);
				map[r][c] = i;
			}
			for(int t = 0 ; t < M ; t++) {
				int[][] tmpmap = new int[N][N];
				for(Cell cell : cells) {
					if(cell == null) continue;
					cell.move(tmpmap);
				}
				for(Cell cell : cells) {
					if(cell == null) continue;
					cell.mxval = cell.val;
				}
				map = tmpmap;
			}
			int total = 0;
			for(Cell cell : cells) {
				if(cell == null) continue;
				total += cell.val;
			}
			bw.write("#" + tc + " " + total + "\n");
			
		}
		
		bw.close();
	}

}
