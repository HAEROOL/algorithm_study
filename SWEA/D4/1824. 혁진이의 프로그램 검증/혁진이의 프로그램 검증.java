import java.io.*;
import java.util.*;

public class Solution {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	static class Compiler {
		int dir, x, y, mem, dx, dy;

		Compiler() {
			dx = 0;
			dy = 1;
			x = 0;
			y = 0;
			mem = 0;
			dir = 1;
		}

		Compiler(int x, int y, int dx, int dy, int mem, int dir) {
			this.dx = dx;
			this.dy = dy;
			this.x = x;
			this.y = y;
			this.mem = mem;
			this.dir = dir;
		}

		void movedir(int dx, int dy) {
			this.dx = dx;
			this.dy = dy;
		}

		void move_() {
			if (this.mem == 0) {
				this.movedir(0, 1);
				this.dir = 1;
			} else {
				this.movedir(0, -1);
				this.dir = 3;
			}
		}

		void moveor() {
			if (this.mem == 0) {
				this.movedir(1, 0);
				this.dir = 0;
			} else {
				this.movedir(-1, 0);
				this.dir = 2;
			}
		}

		void add(int num) {
			this.mem = num;
		}

		void increase() {
			if (this.mem == 15) {
				this.mem = 0;
			} else {
				this.mem++;
			}
		}

		void decrease() {
			if (this.mem == 0) {
				this.mem = 15;
			} else {
				this.mem--;
			}
		}

		void move() {
			this.x += dx;
			this.y += dy;
			if (x >= N) {
				x = 0;
			} else if (x < 0) {
				x = N - 1;
			}
			if (y >= M) {
				y = 0;
			} else if (y < 0) {
				y = M - 1;
			}
		}
	}

	static int N, M;
	static String[][] map;
	// x, y, dir, mem
	static boolean[][][][] v;
	// 하 우 상 좌
	static int[] ddx = {1, 0, -1, 0};
	static int[] ddy = {0, 1, 0, -1};
	static boolean ans = false;

	static void dfs(Compiler c, int depth) {
//		System.out.println(c.x + " " + c.y + " " + c.mem);

		if (ans)
			return;
		if(v[c.x][c.y][c.dir][c.mem]) return;
		v[c.x][c.y][c.dir][c.mem] = true;
		String cmd = map[c.x][c.y];
		if (cmd.equals("<") || cmd.equals(">") || cmd.equals("v") || cmd.equals("^")) {
			switch (cmd) {
			case "<": {
				c.movedir(0, -1);
				c.dir = 3;
				break;
			}
			case ">": {
				c.movedir(0, 1);
				c.dir = 1;
				break;
			}
			case "^": {
				c.movedir(-1, 0);
				c.dir = 2;
				break;
			}
			case "v": {
				c.movedir(1, 0);
				c.dir = 0;
				break;
			}
			}
			Compiler newc = new Compiler(c.x, c.y, c.dx, c.dy, c.mem, c.dir);
			newc.move();
			dfs(newc, depth + 1);
		} else if (cmd.equals("_")) {
			c.move_();
			Compiler newc = new Compiler(c.x, c.y, c.dx, c.dy, c.mem, c.dir);
			newc.move();
			dfs(newc, depth + 1);
		} else if (cmd.equals("|")) {
			c.moveor();
			Compiler newc = new Compiler(c.x, c.y, c.dx, c.dy, c.mem, c.dir);
			newc.move();
			dfs(newc, depth + 1);
		} else if (cmd.equals("@")) {
			ans = true;
			return;
		} else if (cmd.equals("+")) {
			c.increase();
			Compiler newc = new Compiler(c.x, c.y, c.dx, c.dy, c.mem, c.dir);
			newc.move();
			dfs(newc, depth + 1);
		} else if (cmd.equals("-")) {
			c.decrease();
			Compiler newc = new Compiler(c.x, c.y, c.dx, c.dy, c.mem, c.dir);
			newc.move();
			dfs(newc, depth + 1);
		} else if (cmd.equals("?")) {
			int[] dxx = { 1, 0, -1, 0 };
			int[] dyy = { 0, 1, 0, -1 };
			for (int i = 0; i < 4; i++) {
				Compiler newc = new Compiler(c.x, c.y, c.dx, c.dy, c.mem, c.dir);
				newc.movedir(dxx[i], dyy[i]);
				newc.move();
				dfs(newc, depth + 1);
			}
		} else if (cmd.equals(".")) {
			Compiler newc = new Compiler(c.x, c.y, c.dx, c.dy, c.mem, c.dir);
			newc.move();
			dfs(newc, depth + 1);
		} else {
			c.add(Integer.parseInt(cmd));
			Compiler newc = new Compiler(c.x, c.y, c.dx, c.dy, c.mem, c.dir);
			newc.move();
			dfs(newc, depth + 1);
		}
	}

	public static void main(String[] args) throws IOException {
		int TC = Integer.parseInt(br.readLine());

		for (int tc = 1; tc < TC + 1; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			ans = false;
			map = new String[N][M];
			v = new boolean[N][M][4][16];
			for (int i = 0; i < N; i++) {
				String[] input = br.readLine().split("");
				for (int j = 0; j < M; j++) {
					map[i][j] = input[j];
				}
			}
			Compiler c = new Compiler();
			dfs(c, 0);
			bw.write("#" + tc + " ");
			if (ans) {
				bw.write("YES");
			} else {
				bw.write("NO");
			}
			bw.write("\n");
		}
		bw.close();
	}

}