import java.io.*;
import java.util.*;

public class Solution {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static int[] dy = { 1, -1, 0, 0 };
	static int[] dx = { 0, 0, 1, -1 };
	static int x1, x2, y1, y2;
	static int ans;
	static boolean[][] v;
	static void bfs(int x, int y, boolean dir) {
		int cnt = 0;
		while(true) {
			if(x == x2 && y == y2) {
				break;
			}
			if(dir) {
				if(x > x2) {
					x--;
				}else {
					x++;
				}
				dir = false;
			}else {
				if(y > y2) {
					y--;
				}else {
					y++;
				}
				dir = true;
			}
			cnt++;
		}
		ans = Math.min(ans, cnt);
	}
	public static void main(String[] args) throws IOException {
		int TC = Integer.parseInt(br.readLine());
		for (int tc = 1; tc < TC + 1; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			ans = Integer.MAX_VALUE;
			x1 = Integer.parseInt(st.nextToken()) + 100;
			y1 = Integer.parseInt(st.nextToken()) + 100;
			x2 = Integer.parseInt(st.nextToken()) + 100;
			y2 = Integer.parseInt(st.nextToken()) + 100;
			bfs(x1, y1, true);
			bfs(x1, y1, false);
			bw.write("#" + tc + " " + ans + "\n");
		}
		bw.close();
	}
}