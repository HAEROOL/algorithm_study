import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	static void dfs(List<int[]> li, int n) {
		if(isDone) return;
		if(n == li.size()) {
			for(int[] row : board) {
				for(int e : row) {
					System.out.print(e);
				}
				System.out.println();
			}
			isDone = true;
			return;
		}
		int x = li.get(n)[0];
		int y = li.get(n)[1];
		for(int i = 1 ; i <= 9 ; i++) {
			if(!row[x][i] && !col[y][i] && !box[x / 3][y / 3][i]) {
				board[x][y] = i;
				row[x][i] = true;
				col[y][i] = true;
				box[x/3][y/3][i] = true;
				dfs(li, n + 1);
				row[x][i] = false;
				col[y][i] = false;
				box[x/3][y/3][i] = false;
				board[x][y] = 0;
			}
		}
	}
	static boolean isDone = false;
	static boolean[][] row = new boolean[9][10];
	static boolean[][] col = new boolean[9][10];
	static boolean[][][] box = new boolean[3][3][10];
	static int[][] board = new int[9][9];
	public static void main(String[] args) throws IOException {
		List<int[]> li = new ArrayList<>();
		for(int i = 0 ; i < 9 ; i++) {
			String[] input = br.readLine().split("");
			for(int j = 0 ; j < 9 ; j++) {
				int num = Integer.parseInt(input[j]);
				board[i][j] = num;
				if(num != 0) {
					col[j][num] = true;
					row[i][num] = true;
					box[i / 3][j / 3][num] = true;
				}
				if(num == 0) {
					li.add(new int[] {i, j});
				}
			}
		}
		dfs(li, 0);
		bw.close();
	}

}