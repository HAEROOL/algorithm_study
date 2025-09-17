import java.util.*;
import java.io.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static int[] parent;
	static int find(int x) {
		if(parent[x] == x) return x;
		return parent[x] = find(parent[x]);
	}
	static void union(int x, int y) {
		x = find(x);
		y = find(y);
		
		if(x > y) {
			parent[x] = y;
		}else {
			parent[y] = x;
		}
	}
	public static void main(String[] args) throws IOException {
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		parent = new int[N + 1];
		for(int i = 0 ; i < N + 1 ; i++) {
			parent[i] = i;
		}
		for(int i = 0 ; i < N ; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0 ; j < N ; j++) {
				int to = Integer.parseInt(st.nextToken());
				if(to == 1) {
					union(i + 1, j + 1);
				}
			}
		}
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int tmp = find(Integer.parseInt(st.nextToken()));
		
		boolean isPossible = true;
		for(int i = 0 ; i < M - 1 ; i++) {
			if(find(Integer.parseInt(st.nextToken())) != tmp) {
				isPossible = false;
				break;
			}
		}
		bw.write(isPossible?"YES":"NO");
		bw.close();
	}
}