import java.io.*;
import java.util.*;

public class Main {
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int N, M, K;
	static long[] arr;

	static class SegmentTree {
		int treeH;
		long[] tree;

		public SegmentTree(int arrSize) {
			int h = (int) Math.ceil(Math.log(arrSize) / Math.log(2));
			this.treeH = (int) Math.pow(2, h + 1);
			tree = new long[treeH];
		}

		public long init(long[] arr, int node, int start, int end) {
			if (start == end) {
				return tree[node] = arr[start];
			}
			return tree[node] = (init(arr, node * 2, start, (start + end) / 2)
					* init(arr, node * 2 + 1, (start + end) / 2 + 1, end)) % 1000000007;
		}

		public long update(int node, int start, int end, int idx, int num) {
			if (idx < start || idx > end)
				return tree[node];
			if (start == end) {
				return tree[node] = num;
			}
			int mid = (start + end) / 2;
			return tree[node] = (update(node * 2, start, mid, idx, num) * update(node * 2 + 1, mid + 1, end, idx, num))
					% 1000000007;
		}

		public long mul(int node, int start, int end, int left, int right) {
			if (left > end || right < start) {
				return 1;
			}
			if (left <= start && end <= right) {
				return tree[node];
			}

			int mid = (start + end) / 2;
			return (mul(node * 2, start, mid, left, right) * mul(node * 2 + 1, mid + 1, end, left, right)) % 1000000007;
		}
	}

	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		arr = new long[N + 1];
		for (int i = 0; i < N; i++) {
			long n = Long.parseLong(br.readLine());
			arr[i + 1] = n;
		}
		SegmentTree stree = new SegmentTree(N);
		stree.init(arr, 1, 1, N);
//		System.out.println(Arrays.toString(stree.minTree));
		for (int i = 0; i < M + K; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			if(a == 1) {
				stree.update(1, 1, N, b, c);
			}else {
				bw.write(stree.mul(1, 1, N, b, c) + "\n");
			}
		}

		bw.close();
	}

}