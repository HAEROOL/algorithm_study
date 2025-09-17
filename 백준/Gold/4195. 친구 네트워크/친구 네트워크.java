import java.util.*;
import java.io.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static Map<String, Integer> dict;
	static int[] parent, level;
	static int find(int x) {
		if(parent[x] == x) return x;
		return parent[x] = find(parent[x]);
	}
	static int union(int x, int y) {
		x = find(x);
		y = find(y);
		
		if(x < y) {
			parent[y] = x;
			level[x] += level[y];
			return level[x];
		}else if(x > y){
			parent[x] = y;
			level[y] += level[x];
		}
		return level[y];
	}
	public static void main(String[] args) throws IOException {
		int TC = Integer.parseInt(br.readLine());
		for(int tc = 0 ; tc < TC ; tc++) {
			int F = Integer.parseInt(br.readLine());
			int id = 0;
			parent = new int[F * 2];
			level = new int[F * 2];
			for(int i = 0 ; i < F * 2 ; i++) {
				parent[i] = i;
				level[i] = 1;
			}
			dict = new HashMap<>();
			for(int i = 0 ; i < F ; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				String a = st.nextToken();
				String b = st.nextToken();
				if(!dict.containsKey(a)) {
					dict.put(a, id++);
				}
				if(!dict.containsKey(b)) {
					dict.put(b, id++);
				}
				
				
				bw.write( union(dict.get(a), dict.get(b))+ "\n");
			}
		}
		bw.close();
	}
}