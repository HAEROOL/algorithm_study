import java.io.*;
import java.util.*;

public class Solution {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static void subset(List<Integer> list, int idx, int total, int value) {
		if(total > C) {
			return;
		}
		if( idx >= list.size()) {
			vmx = Math.max(vmx, value);
			return;
		}
		subset(list, idx + 1, total, value);
		value = value + list.get(idx) * list.get(idx);
		total = total + list.get(idx);
		subset(list, idx + 1, total ,value);
	}
	static int N, M, C;
	static int vmx;
	public static void main(String[] args) throws IOException {
		int TC = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= TC; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			int[][] map = new int[N][N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			List<Integer> ans = new ArrayList<>();
			for (int k = 0; k < N; k++) {
				vmx = -1;
				for (int i = 0; i < N; i++) {
					List<Integer> list = new ArrayList<>();
					for (int j = i; j < i + M; j++) {
						if (j>=N) break;
						list.add(map[k][j]);
					}
//					System.out.println(list);
					subset(list, 0, 0, 0);
				}
//				System.out.println(vmx);
				ans.add(vmx);
			}
//			System.out.println(ans);
			Collections.sort(ans);
//			System.out.println(ans);

			bw.write("#" + tc + " " + (ans.get(ans.size() - 1) + ans.get(ans.size() - 2)) + "\n");
		}
		bw.close();
	}

}
