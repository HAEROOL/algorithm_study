import java.io.*;
import java.util.*;

public class Solution {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static void main(String[] args) throws IOException {
		int TC = Integer.parseInt(br.readLine());
		for(int tc = 1 ; tc <= TC ; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			List<String> q = new ArrayList<String>(Arrays.asList(br.readLine().split("")));
			Set<String> set = new HashSet<>();
			for(int r = 0 ; r < N / 4 ; r++) {
				for(int i = 0 ; i < N ; i += N / 4) {
					String tmp = "";
					for(int s = i ; s <i +  N / 4 ; s++) {
						tmp += q.get(s);
					}
					set.add(tmp);
				}
				q.add(0, q.remove(N - 1));
			}
			List<Integer> list = new ArrayList<>();
			for(String s : set) {
				list.add(Integer.parseInt(s, 16));
			}
			Collections.sort(list, (a, b) -> b - a);
			bw.write("#" + tc + " " + list.get(K - 1) + "\n");
		}
		bw.close();
	}

}
