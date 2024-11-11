import java.io.*;
import java.util.*;

public class Solution {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static int[] ans = null;
	static boolean check(int[] arr) {
		boolean[] v = new boolean[N];
		for(int i = 0 ; i < N - 1 ; i++) {
			if(arr[i] == arr[i + 1]) continue;
			// 1.내 다음이 1 작은 경
			if(arr[i] - arr[i + 1] == 1) {
				// i + 1 포함 앞으로 X칸 안되면 
				if(i + X >= N) return false;
				for(int j = 1 ; j < X ; j++) {
					if(arr[i + 1 + j] == arr[i + 1]) {
						if(v[i + 1 + j]) return false;
						v[i + 1 + j] = true;
					}else {
						return false;
					}
				}
			}
			// 2.내 다음이 1 클 경우
			else if(arr[i] - arr[i + 1] == -1) {
				// i포함 뒤로 X칸 안되면 
				if(i + 1 - X < 0) return false;
				// i포함 뒤로 X칸같아야 한다.
				for(int j = 0 ; j < X ; j++) {
					if(arr[i - j] != arr[i]) return false;
					if(v[i - j]) return false;
				}
			}else {
				return false;
			}

		}
		return true;
	}
	static int N, X;
	public static void main(String[] args) throws IOException {
		int TC = Integer.parseInt(br.readLine());
		for (int tc = 1; tc < TC + 1; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			X = Integer.parseInt(st.nextToken());
			int[][] map = new int[N][N];
			for(int i = 0 ; i < N ; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0 ; j < N ; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			int cnt = 0;
			for(int i = 0 ; i < N ; i++) {
				if(check(map[i])) {
					cnt++;
				}
			}
			for(int j = 0 ; j < N ; j++) {
				int[] arr = new int[N];
				for(int i = 0 ; i < N ; i++) {
					arr[i] = map[i][j];
				}
				if(check(arr)) {
					cnt++;
				}
			}
			bw.write("#" + tc + " " + cnt + "\n");
			
		}
		bw.close();
	}
}