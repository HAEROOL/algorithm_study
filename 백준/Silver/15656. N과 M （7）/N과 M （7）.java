import java.util.*;
import java.io.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	static void permutation(int[] sel, int idx) throws IOException {
		if (idx == sel.length) {
			for (int i : sel) {
				bw.write(arr[i] + " ");
			}
			bw.write("\n");
			return;
		}
		for (int i = 0; i < N; i++) {
			sel[idx] = i;
			permutation(sel, idx + 1);
		}

	}

	static int[] arr;
	static int ans;
	static int N, M;
	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		permutation(new int[M], 0);

		bw.close();
	}
}