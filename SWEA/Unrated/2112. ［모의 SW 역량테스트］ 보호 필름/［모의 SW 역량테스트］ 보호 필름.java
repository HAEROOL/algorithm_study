import java.io.*;
import java.util.*;

public class Solution {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static int D, W, K, ans;
	static int[][] rfilms;
	static int[][] films;
	static void combination(int mx, int idx, int[] sel, int k, int[] fill) {
		if(ans < Integer.MAX_VALUE) return;
		if(sel.length == idx) {
			films = new int[D][W];
			copyFilm(films);
			if(cal(sel, fill) == W || cal(sel, fill) == W) {
				ans = sel.length;
			}
			return;
		}
		if(k >= mx) {
			return;
		}
		combination(mx, idx, sel, k + 1, fill);
		sel[idx] = k;
		fill[idx] = 0;
		combination(mx, idx + 1, sel, k + 1, fill);
		fill[idx] = 1;
		combination(mx, idx + 1, sel, k + 1, fill);
	}
	static int cal(int[] sel, int[] fill) {
		for(int i = 0 ; i < sel.length ; i++) {
			int s = sel[i];
			for(int j = 0 ; j < W ; j++) {
				films[s][j] = fill[i];
			}			
		}
//		if(sel.length == 2 && sel[0] == 2 && sel[1] == 5 && fill[0] == 0 && fill[1] == 1) {
//			for(int[] row: films) {
//				System.out.println(Arrays.toString(row));
//			}
//		}
		int cnt = 0;
		for(int j = 0 ; j < W ; j++) {
			for(int i = 0; i <= D - K ; i++) {
				int base = films[i][j];
				boolean isPass = true;
				for(int k = i + 1 ; k < i + K ; k++) {
					if(films[k][j] != base) {
						isPass = false;
						break;
					}
				}
				if(isPass) {
					cnt++;						
					break;
				}
			}
			if(cnt != j + 1) {
				return 0;
			}
		}
//		System.out.println(cnt + " " + Arrays.toString(sel));
		return cnt;
	}
	static void copyFilm(int[][] tmp) {
		for(int i = 0 ; i < D ; i++) {
			for(int j = 0 ; j < W ; j++) {
				tmp[i][j] = rfilms[i][j];
			}
		}
	}
	public static void main(String[] args) throws IOException {
		  int TC = Integer.parseInt(br.readLine());
		  for(int tc = 1 ; tc < TC + 1 ; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			D = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			ans = Integer.MAX_VALUE;
			rfilms = new int[D][W];
			for(int i = 0 ; i < D ; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0 ; j < W ; j++) {
					rfilms[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			films = new int[D][W];
			copyFilm(films);
			int cnt = 0;
			for(int j = 0 ; j < W ; j++) {
				for(int i = 0; i <= D - K ; i++) {
					int base = films[i][j];
					boolean isPass = true;
					for(int k = i + 1 ; k < i + K ; k++) {
						if(films[k][j] != base) {
							isPass = false;
							break;
						}
					}
					if(isPass) {
						cnt++;						
						break;
					}
				}
			}
//			System.out.println(cnt);
			if(cnt == W) ans = 0;
			if(ans != Integer.MAX_VALUE) {
				bw.write("#" + tc + " " + ans + "\n");
				continue;
			}
			for(int c = 1 ; c <= D ; c++) {
//				System.out.println(ans);
				if(ans != Integer.MAX_VALUE) {
					bw.write("#" + tc + " " + ans + "\n");
					break;
				}
				combination(D, 0, new int[c], 0, new int[c]);
			}
		  }
		  bw.close();
	}
}