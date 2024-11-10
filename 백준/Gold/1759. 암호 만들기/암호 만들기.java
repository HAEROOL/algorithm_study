import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static int L, C;
	static List<String> strs;

	static void dfs(int idx, String code, int js, int ms) {
		if (code.length() == L && ms >= 1 && js >= 2) {
			System.out.println(code);
			return;
		}
		for (int i = idx; i < C; i++) {
			if (모음.contains(strs.get(i))) {
				dfs(i + 1, code + strs.get(i), js, ms + 1);
			}else {
				dfs(i + 1, code + strs.get(i), js + 1, ms);
			}
		}

	}

	static Set<String> 모음 = new HashSet<>(Arrays.asList("a", "e", "i", "o", "u"));

	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());
		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		strs = new ArrayList<>();

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < C; i++) {
			String t = st.nextToken();
			if(!strs.contains(t)) {
				strs.add(t);
			}
		}
		Collections.sort(strs);
		C = strs.size();
		dfs(0, "", 0, 0);
	}

}