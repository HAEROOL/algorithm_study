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
import java.util.concurrent.PriorityBlockingQueue;

public class Solution {
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	static int N;
	static Cell[] cells;
	static class Cell {
		int x, y, size, d, idx, mxSize;

		public Cell(int x, int y, int size, int d, int idx) {
			// TODO Auto-generated constructor stub
			this.x = x;
			this.y = y;
			this.size = size;
			this.mxSize = size;
			this.d = d;
			this.idx = idx;
		}

		int[] move() {
			x += dx[this.d];
			y += dy[this.d];
			if (x == 0 || x == N - 1 || y == 0 || y == N - 1) {
				this.size /= 2;
				if(this.size == 0) {
					cells[idx] = null;
					return null;
				}
				if (this.d == 1) {
					this.d = 0;
				} else if (this.d == 0) {
					this.d = 1;
				} else if (this.d == 2) {
					this.d = 3;
				} else if (this.d == 3) {
					this.d = 2;
				}
			}
			return new int[] { x, y };
		}
		void update(Cell[][] board) {
			int[] coord = move();
			if(coord == null) return;
			if(board[coord[0]][coord[1]] != null) {
				if(this.mxSize < board[coord[0]][coord[1]].mxSize) {
					board[coord[0]][coord[1]].size += this.size;
					cells[this.idx] = null;
				}else{
					this.size += board[coord[0]][coord[1]].size;
					cells[board[coord[0]][coord[1]].idx] = null;
					board[coord[0]][coord[1]] = this;
				}
			}else {
				board[coord[0]][coord[1]] = this;
			}
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc < T + 1; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			cells = new Cell[K];
			Cell[][] map = new Cell[N][N];
			for(int i = 0 ; i < K ; i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				int size = Integer.parseInt(st.nextToken());
				int dir = Integer.parseInt(st.nextToken()) - 1;
				cells[i] = new Cell(x, y, size, dir, i);
				map[x][y] = new Cell(x, y, size, dir, i);
			}
			for(int time = 0 ; time < M ; time++) {
				Cell[][] tmp = new Cell[N][N];
				for(Cell cell : cells) {
					if(cell == null) continue;
					cell.update(tmp);
				}
				map = tmp;
				for(Cell[] row : tmp) {
					for(Cell c : row) {
						if(c == null) continue;
						c.mxSize = c.size;
					}
				}
				for(Cell c : cells) {
					if(c == null) continue;
					c.mxSize = c.size;
				}
			}
			int total = 0 ;
			for(Cell c : cells) {
				if(c == null) continue;
				total += c.size;
			}
			bw.write("#" + tc + " " + total + "\n");
		}
		bw.flush();
	}
}
