import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	static int[][] map = new int[10][10];
	static boolean checkMarking(int x, int y, int r) {
		if(x + r > 10 || y + r > 10) return false;
		for(int i = x ; i < x + r ; i++) {
			for(int j = y ; j < y + r ; j++) {
				if(map[i][j] == 0) return false;
			}
		}
		return true;
	}
	static void marking(int x, int y, int r, int f) {
		for(int i = x ; i < x + r ; i++) {
			for(int j = y ; j < y + r ; j++) {
				map[i][j] = f;
			}
		}
	}
	static void backtracking(int x, int y, int[] paper, int cnt) {
		if(x >= 9 && y > 9) {
			ans = Math.min(cnt, ans);
			return;
		}
//		for(int[] row:map) {
//			System.out.println(Arrays.toString(row));
//		}
//		System.out.println(x + " " + y);
//		System.out.println(Arrays.toString(paper));
		if(ans <= cnt) return;
		
		if(y > 9) {
			backtracking(x + 1, 0, paper, cnt);
			return;
		}
		if(map[x][y] == 1) {
			for(int i = 5 ; i > 0 ; i--) {
//				System.out.println(checkMarking(x, y, i));
				if(paper[i] > 0 && checkMarking(x, y, i)) {
					marking(x, y, i, 0);
					paper[i]--;
					backtracking(x, y + 1, paper, cnt + 1);
					marking(x, y, i, 1);
					paper[i]++;
				}
			}
		}else {
			backtracking(x, y + 1, paper, cnt);
		}
	}
	static int ans = Integer.MAX_VALUE;
	public static void main(String[] args) throws IOException {
		StringTokenizer st;
		for(int i = 0 ; i < 10 ; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0 ; j < 10 ; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		backtracking(0, 0, new int[] {0, 5, 5, 5, 5, 5}, 0);
		System.out.println(ans==Integer.MAX_VALUE?-1:ans);
	}

}