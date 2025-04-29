import java.util.*;
import java.io.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	static void permutaion(int depth, boolean[] v, int[] select) {
		if (depth == N + P + Q) {
			long total = select[0];
			long tmp = 1;
			for(int i = 1 ; i < select.length - 1 ; i += 2) {
				int op = select[i];
				long num = select[i + 1];
				if(op == 0) {
					total += num;
				}else {
					tmp *= total;
					total = num;
				}
			}
			tmp *= total;
			ans = Math.max(ans, tmp);
			return;
		}
		if(depth % 2 == 0) {
			for(int i = 0 ; i < N ; i++) {
				if(!v[i]) {
					v[i] = true;
					select[depth] = nums[i]; 
					permutaion(depth + 1, v, select);
					v[i] = false;
				}
			}
		}else {
			for(int i = 0 ; i < 2 ; i++) {
				if(ops[i] != 0) {
					ops[i]--;
					select[depth] = i;
					permutaion(depth + 1, v, select);
					ops[i]++;
				}
			}
		}

	}

	static long ans = 0;
	static int N, P, Q = 0;
	static int[] nums;
	static int[] ops;
	
	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		nums = new int[N];
		for (int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		ops = new int[2];
		P = ops[0] = Integer.parseInt(st.nextToken());
		Q = ops[1] = Integer.parseInt(st.nextToken());
		boolean[] v = new boolean[N];
		int[] select = new int[N + P + Q];
		permutaion(0, v, select);
		bw.write(ans + "");
		bw.close();

	}
}