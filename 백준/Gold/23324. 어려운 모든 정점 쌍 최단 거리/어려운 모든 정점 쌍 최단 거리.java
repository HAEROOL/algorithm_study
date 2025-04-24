import java.util.*;
import java.io.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static int N, M, K;
	static int[] parent;
	static int A, B;
	static long ans;
	static int find(int x) {
		if(parent[x] == x) {
			return x;
		}
		return parent[x] = find(parent[x]);
	}
	
	static void union(int x, int y) {
		x = find(x);
		y = find(y);
		if(x > y) {
			parent[x] = y;
		}else if(y > x){
			parent[y] = x;
		}else {
			ans = -1;
		}
	}
	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		parent = new int[N + 1];
		for(int i = 1 ; i < N + 1 ; i++) {
			parent[i] = i;
		}
		
		for(int i = 0 ; i < M ; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			if(i == K - 1) {
				A = Math.min(from, to);
				B = Math.max(from, to);
				continue;
			}
			union(from, to);
		}
		A = find(A);
		B = find(B);
		if(A == B) bw.write(0 +"");
		else {
			Map<Long, Long> map = new HashMap<Long, Long>();
			for(int i = 1 ; i <= N ; i++) {
				long cur = find(i);
				if(map.containsKey(cur)) {
					map.put(cur, map.get(cur) + 1);
				}else {
					map.put(cur, (long) 1);
				}
			}
			ans = 1;
			for(long key : map.keySet()) {
				ans *= map.get(key);
			}
			bw.write(ans + "");
		}

		bw.close();

	}
}