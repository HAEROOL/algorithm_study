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
		long[] minTree, maxTree;
		
		public SegmentTree(int arrSize) {
			int h = (int)Math.ceil(Math.log(arrSize)/Math.log(2));
			this.treeH = (int) Math.pow(2, h + 1);
			tree = new long[treeH];
			minTree = new long[treeH];
			maxTree = new long[treeH];
		}
		
		long init(long[] arr, int node, int start, int end) {
			if(start == end) {
	            minTree[node] = arr[start];
	            maxTree[node] = arr[start];
				return tree[node] = arr[start];
			}
			long left = init(arr, node * 2, start, (start + end) / 2);
			long right = init(arr, node * 2 + 1, (start + end) / 2 + 1, end);
			minTree[node] = Math.min(minTree[node * 2], minTree[node * 2 + 1]);
			maxTree[node] = Math.max(maxTree[node * 2], maxTree[node * 2 + 1]);
			return tree[node] = left + right;
					
		}
		
		long getMin(int node, int start, int end, int left, int right) {
			if(right < start || left > end) {
				return Long.MAX_VALUE;
			}
			if(left <= start && end <= right) {
				return minTree[node];
			}
			int mid = (start + end) / 2;
			long leftMin = getMin(node * 2, start, mid, left, right);
			long rightMin = getMin(node * 2 + 1, mid + 1, end, left, right);
			return Math.min(leftMin, rightMin);
		}
		
		long getMax(int node, int start, int end, int left, int right) {
			if(right < start || left > end) {
				return Long.MIN_VALUE;
			}
			if(left <= start && end <= right) {
				return maxTree[node];
			}
			int mid = (start + end) / 2;
			long leftMx = getMax(node * 2, start, mid, left, right);
			long rightMx = getMax(node * 2 + 1, mid + 1, end, left, right);
			return Math.max(leftMx, rightMx);
		}
		
	}

	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new long[N + 1];
		for(int i = 0 ; i < N ; i ++) {
			long n = Long.parseLong(br.readLine());
			arr[i + 1] = n;
		}
		SegmentTree stree = new SegmentTree(N);
		stree.init(arr, 1, 1, N);
//		System.out.println(Arrays.toString(stree.minTree));
		for(int i = 0 ; i < M ; i++) {
			st = new StringTokenizer(br.readLine());
			int left = Integer.parseInt(st.nextToken());
			int right  = Integer.parseInt(st.nextToken());
			long min = stree.getMin(1, 1, N, left, right);
			long max = stree.getMax(1, 1, N, left, right);
			bw.write(min + " " + max + "\n");
		}
		
		
		bw.close();
	}

}