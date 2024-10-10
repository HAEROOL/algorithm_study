import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static int[][] map;
	static int X, N;
	static boolean check(int[] arr) {
		int idx = 1;
		boolean[] v = new boolean[arr.length];
		// 높아지는 경우
		while(true) {
			if(idx == N) break;
			// 오른쪽이 왼쪽보다 큰 경우
			if(Math.abs(arr[idx] - arr[idx - 1]) > 1) return false;
			if(arr[idx] + 1 == arr[idx - 1]) {
				int base = arr[idx];
				if(idx + X > N) return false;
				for(int i = idx ; i < idx + X ; i++) {
					
					if(arr[i] != base) return false;
					v[i] = true;
				}
				idx += X - 1;
			}else if(arr[idx] - 1 == arr[idx - 1]) {
				int base = arr[idx - 1];
				if(idx - X < 0) return false;
				for(int i = idx - 1 ; i > idx - X - 1 ; i--) {
					if(v[i]) return false;
					if(arr[i] != base) return false;
					v[i] = true;
				}
				idx++;
			}else {
				idx++;
			}
		}
		return true;
	}
	static int[] reverse(int[] arr) {
		int[] res = new int[arr.length];
		for(int i = 0 ; i < arr.length ; i++) {
			res[i] = arr[arr.length - 1 - i];
		}
		return res;
	}
	public static void main(String[] args) throws IOException {
		int TC = Integer.parseInt(br.readLine());
		for (int tc = 1; tc < TC + 1; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			X = Integer.parseInt(st.nextToken());
			int[][] map = new int[N][N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			int cnt = 0;
			for(int i = 0 ; i < N ; i++) {
				int[] rev = reverse(map[i]);
				if(check(map[i]) && check(rev)) {
//					System.out.println(Arrays.toString(map[i]) + " " + cnt);
					cnt++;
				}
			}
			for(int i = 0 ; i < N ; i++) {
				int[] arr = new int[N];
				for(int j = 0 ; j < N ; j++) {
					arr[j] = map[j][i];
				}
				if(check(arr) && check(reverse(arr))) {
//					System.out.println(Arrays.toString(map[i]) + " " + cnt);
					cnt++;
				}
			}
			bw.write("#" + tc + " " + cnt + "\n");
		}
		bw.close();
	}

}
