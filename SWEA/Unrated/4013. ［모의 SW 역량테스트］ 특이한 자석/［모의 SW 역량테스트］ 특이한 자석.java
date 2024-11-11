import java.io.*;
import java.util.*;

public class Solution {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static List<Integer>[] gears;
	static void rotate(int n, int dir) {
		v[n] = true;
		if(n < 3 && gears[n].get(2) != gears[n + 1].get(6) && !v[n + 1]) {
			rotate(n + 1, dir * -1);
		}
		if(n > 0 && gears[n].get(6) != gears[n - 1].get(2) && !v[n - 1]) {
			rotate(n - 1, dir * -1);
		}
		if(dir == 1) {
			gears[n].add(0, gears[n].remove(7));
		}else {
			gears[n].add(7, gears[n].remove(0));
		}
	}
	static boolean[] v;
	public static void main(String[] args) throws IOException {
		int TC = Integer.parseInt(br.readLine());
		for (int tc = 1; tc < TC + 1; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int K = Integer.parseInt(st.nextToken());
			gears = new ArrayList[4];
			for(int i = 0 ; i < 4 ; i++) {
				st = new StringTokenizer(br.readLine());
				gears[i] = new ArrayList<>();
				for(int j = 0 ; j < 8 ; j++) {
					gears[i].add(Integer.parseInt(st.nextToken()));
				}
			}
			for(int i = 0 ; i < K ; i++) {
				st = new StringTokenizer(br.readLine());
				v = new boolean[4];
				int target = Integer.parseInt(st.nextToken());
				int dir = Integer.parseInt(st.nextToken());
				rotate(target - 1, dir);
			}
			int ans = 0;
			for(int i = 0 ; i < 4 ; i++) {
				if(gears[i].get(0) == 1) {
					ans += Math.pow(2, i);
				}
			}
			bw.write("#" + tc + " " + ans + "\n");
		}
		bw.close();
	}
}