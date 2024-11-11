import java.io.*;
import java.util.*;

public class Solution {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static int N, M, C;
	static int[][] map;
	static void subset(boolean[] sel, int idx, int total, int[] arr, int flag) {
		if(total > C) return;
		if(idx == sel.length) {
			int t = 0;
			for(int i = 0 ; i < sel.length ; i++) {
				if(sel[i]) {
					t += arr[i] * arr[i];
				}
			}
			if(flag == 0) {
				asub = Math.max(asub, t);				
			}else {
				bsub = Math.max(bsub, t);
			}
			return;
		}
		
		sel[idx] = true;
		subset(sel, idx + 1, total + arr[idx], arr, flag);
		sel[idx] = false;
		subset(sel, idx + 1, total, arr, flag);
	}
	static int asub = 0;
	static int bsub = 0;
	static int ans = 0;
	public static void main(String[] args) throws IOException {
		int TC = Integer.parseInt(br.readLine());
		for (int tc = 1; tc < TC + 1; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			map = new int[N][N];
			ans = 0;
			for(int i = 0; i < N ; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0 ; j < N ; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			for(int i = 0 ; i < N ; i++) {
				asub = 0;
				//A subset 최댓값 구하
				for(int j = 0 ; j < N - M + 1 ; j++) {
					int[] arr = new int[M];
					for(int k = 0 ; k < M ; k++) {
						arr[k] = map[i][j + k];
					}
					subset(new boolean[M], 0, 0, arr, 0);
				}
				for(int b = i + 1 ; b < N ; b++) {
					for(int j = 0 ; j < N - M + 1 ; j++) {
						bsub = 0;
						int[] arr = new int[M];
						for(int k = 0 ; k < M ; k++) {
							arr[k] = map[b][j + k];
						}
						subset(new boolean[M], 0, 0, arr, 1);
						ans = Math.max(ans, asub + bsub);
					}					
				}
			}
			bw.write("#" + tc + " " + ans + "\n");
		}
		bw.close();
	}
}