import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static int ans = Integer.MAX_VALUE;
	static int[] paper = {0, 5, 5, 5, 5, 5};
	static int[][] map;
	static void backtracking(int x, int y, int cnt) {
//		System.out.println(cnt);
		if(x >= 9 && y > 9) {
//			System.out.println(cnt);
			ans = Math.min(ans, cnt);
			return;
		}
		if(ans <= cnt) {
			return;
		}
		if(y > 9) {
			backtracking(x + 1, 0, cnt);
			return;
		}
		if(map[x][y] == 1) {
			for(int i = 5 ; i > 0 ; i--) {
//				System.out.println(check(x, y, i));
				if(paper[i] > 0 && check(x, y, i)) {
					marking(x, y, i, 0);
					paper[i]--;
					backtracking(x, y + 1, cnt + 1);
					marking(x, y, i, 1);
					paper[i]++;					
				}
			}
		}else {
			backtracking(x, y + 1, cnt);
		}
	}
	static boolean check(int x, int y, int size) {
	    for(int i = x ; i <  x + size ; i++){
	        for(int j = y ; j < y + size ; j++){
	          if(i < 0 || i >= 10 || j < 0 || j>= 10) return false;
	          if(map[i][j] != 1) return false;
	        }
	      }
	      return true;
	}
	static void marking(int x, int y, int k, int state) {
		for(int i = x ; i < x + k ; i++) {
			for(int j = y ; j < y + k ; j++) {
				map[i][j] = state;
			}
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st;
		map = new int[10][10];

		for (int i = 0; i < 10; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 10; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		backtracking(0, 0, 0);
		ans = ans == Integer.MAX_VALUE?-1:ans;
		bw.write(ans + "");
		bw.close();
	}
}