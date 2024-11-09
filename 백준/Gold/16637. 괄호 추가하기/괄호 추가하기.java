import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static int cal(int a, int b, String op) {
//		System.out.println(a + op + b);
		int res = -1;
		if(op.equals("+")) {
			res = a + b;
		}else if(op.equals("-")) {
			res = a - b;
		}else if(op.equals("*")) {
			res = a * b;
		}
		return res;
	}
	static void backtracking(int idx, int total) {
		if(idx == N - 1) {
			ans = Math.max(total, ans);
			return;
		}
//		System.out.println(total);
		backtracking(idx + 2, cal(total, Integer.parseInt(input[idx + 2]), input[idx + 1]));
		if(idx + 4 < N) {
			int a = Integer.parseInt(input[idx + 2]);
			String op = input[idx + 3];
			int b = Integer.parseInt(input[idx + 4]);
			int res = cal(a, b, op);
//			System.out.println(res);
			backtracking(idx + 4, cal(total, res, input[idx + 1]));
		}
	}
	static int ans, N;
	static String[] input;
	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(br.readLine());
		ans = Integer.MIN_VALUE;
		input = br.readLine().split("");
		backtracking(0, Integer.parseInt(input[0]));
		System.out.println(ans);
		bw.close();

	}

}