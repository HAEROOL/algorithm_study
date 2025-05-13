import java.util.*;
import java.io.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static void permutation(int[] sel, boolean[] v, int idx)throws IOException {
		if(idx == sel.length) {
			for(int i : sel) {
				bw.write((i+1) + " ");
			}
			bw.write("\n");
			return;
		}
		for(int i = 0 ; i < sel.length ; i++) {
			if(!v[i]) {
				sel[idx] = i;
				v[i] = true;
				permutation(sel, v, idx + 1);
				v[i] = false;
			}
		}
		
	}
	static int[] arr;
	static int ans;
	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		
		permutation(new int[N], new boolean[N], 0);
		
		bw.close();
	}
}