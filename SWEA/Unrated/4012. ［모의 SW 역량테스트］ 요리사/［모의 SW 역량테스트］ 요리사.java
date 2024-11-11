import java.io.*;
import java.util.*;

public class Solution {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static void comb(boolean[] sel, int idx, int cnt) {
		if(idx == N) {
			if(cnt == N / 2) {
				List<Integer> a = new ArrayList<>();
				List<Integer> b = new ArrayList<>();
				for(int i = 0 ; i < N ; i++) {
					if(sel[i]) a.add(i);
					else b.add(i);
				}
				int atotal = 0;
				for(int i = 0 ; i < a.size() ; i++) {
					for(int j = i + 1 ; j < a.size() ; j++) {
						int x = a.get(i);
						int y = a.get(j);
						atotal += map[x][y];
						atotal += map[y][x];
					}
				}
				int btotal = 0;
				for(int i = 0 ; i < b.size() ; i++) {
					for(int j = i + 1 ; j < b.size() ; j++) {
						int x = b.get(i);
						int y = b.get(j);
						btotal += map[x][y];
						btotal += map[y][x];
					}
				}
				ans = Math.min(ans, Math.abs(atotal - btotal));
			}
			return;
		}
		
		sel[idx] = true;
		comb(sel, idx + 1, cnt + 1);
		sel[idx] = false;
		comb(sel, idx + 1, cnt);
	}
	static int N;
	static int[][] map;
	static int ans;
	public static void main(String[] args) throws IOException {
		int TC = Integer.parseInt(br.readLine());
		for (int tc = 1; tc < TC + 1; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			map = new int[N][N];
			ans = Integer.MAX_VALUE;
			for(int i = 0 ; i < N ; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0 ; j < N ; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
//			for(int[] row : map)System.out.println(Arrays.toString(row));
			comb(new boolean[N], 0, 0);
			bw.write("#" + tc + " " + ans + "\n");
		}
		bw.close();
	}
}