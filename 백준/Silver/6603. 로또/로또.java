import java.util.*;
import java.io.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static void combination(int[] sel, int pos, int idx)throws IOException {
		if(pos == sel.length) {
			for(int i : sel) {
				bw.write(arr[i] + " ");
			}
			bw.write("\n");
			return;
		}
		if(idx >= arr.length) return;
		sel[pos] = idx;
		combination(sel, pos + 1, idx + 1);
		combination(sel, pos, idx + 1);
		
	}
	static int[] arr;
	static int ans;
	public static void main(String[] args) throws IOException {
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			ans = 0;
			int K = Integer.parseInt(st.nextToken());
			if(K == 0) break;
			
			arr = new int[K];
			for(int i = 0 ; i < K ; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			combination(new int[6], 0, 0);
			bw.write("\n");
		}
		bw.close();
		

	}
}