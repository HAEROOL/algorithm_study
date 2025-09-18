import java.util.*;
import java.io.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static List<Integer>[] enemy;
	static int[] friendList;
	static int ffind(int x) {
		if(friendList[x] == x) {
			return x;
		}
		return friendList[x] = ffind(friendList[x]);
	}
	static void funion(int x, int y) {
		x = ffind(x);
		y = ffind(y);
		if(x > y) {
			friendList[x] = y;
		}else {
			friendList[y] = x;
		}
	}
	public static void main(String[] args) throws IOException {
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		StringTokenizer st;
		enemy = new ArrayList[n+1];
		friendList = new int[n + 1];
		for(int i = 0 ; i < n + 1 ; i++) {
			friendList[i] = i;
			enemy[i] = new ArrayList<Integer>();
		}
		for(int i = 0 ; i < m ; i++) {
			st = new StringTokenizer(br.readLine());
			String r = st.nextToken();
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			if(r.equals("E")) {
				enemy[b].add(a);
				enemy[a].add(b);				
			}else {
				funion(a,b);
			}
		}
//		for(int i = 1 ; i < n + 1 ; i++) {
//			System.out.println(enemy[i]);
//		}
		for(int i = 1 ; i < n + 1 ; i++) {
			if(enemy[i].size() > 1) {
				for(int j = 0 ; j < enemy[i].size() - 1 ; j++) {
//					System.out.println();
//					System.out.println(Arrays.toString(friendList));
					funion(enemy[i].get(j), enemy[i].get(j + 1));
				}
			}
		}
		Set<Integer> set = new HashSet<Integer>();
		for(int a : friendList) {
			set.add(ffind(a));
		}
		bw.write(set.size() - 1 +  "");
		bw.close();
	}
}