import java.io.*;
import java.util.*;

public class Solution {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static void combination(boolean[] sel, int k, int depth) {
		if(k == N/2) {
			cal(sel);
			return;
		}
		if(depth > N) return;
		sel[depth] = true;
		combination(sel, k + 1, depth + 1);
		sel[depth] = false;
		combination(sel, k, depth + 1);
		
	}
	static void cal(boolean[] sel) {
		List<Integer> lista = new ArrayList<>();
		List<Integer> listb = new ArrayList<>();
		for(int i = 1 ; i < N + 1 ; i++) {
			if(sel[i]) lista.add(i);
			else listb.add(i);
		}
		int totala = 0;
		int totalb = 0;
//		System.out.println(lista);
//		System.out.println(listb);
//		System.out.println();
		for(int i = 0 ; i < lista.size() ; i++) {
			for(int j = i + 1 ; j < lista.size() ; j++) {
				int ai = lista.get(i), aj = lista.get(j);
				int bi = listb.get(i), bj = listb.get(j);
				int suma = map[ai][aj] + map[aj][ai];
				int sumb = map[bi][bj] + map[bj][bi];
				totala += suma;
				totalb += sumb;
			}
		}
//		System.out.println(totala + " " + totalb);
		ans = Math.min(ans, Math.abs(totala - totalb));
	}
	static int ans;
	static int N;
	static int[][] map;
	public static void main(String[] args) throws IOException {
		  int TC = Integer.parseInt(br.readLine());
		  for(int tc = 1 ; tc < TC + 1 ; tc++) {
			  StringTokenizer st = new StringTokenizer(br.readLine());
			  N = Integer.parseInt(st.nextToken());
			  ans = Integer.MAX_VALUE;
			  map = new int[N + 1][N + 1];
			  for(int i = 1 ; i < N + 1 ; i++) {
				  st = new StringTokenizer(br.readLine());
				  for(int j = 1 ; j < N + 1 ; j++) {
					  map[i][j] = Integer.parseInt(st.nextToken());
				  }
			  }
			  combination(new boolean[N + 1], 0, 1);
			  bw.write("#" + tc +" " + ans + "\n");
		  }
		  bw.close();
	}
}