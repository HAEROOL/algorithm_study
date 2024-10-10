import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static int N, M;
	static int[] tree;
	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		tree = new int[N];
		for(int i = 0 ; i < N ; i++) {
			tree[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(tree);
		
		int start = 1;
		int end = tree[N - 1];
		int ans = -1;
//		System.out.println(start + " " + end);
		while(start <= end) {
			int mid = (start + end) / 2;
			long total = 0;
			for(int i = 0 ; i < N ; i++) {
				if(tree[i] - mid > 0) {
					total += tree[i] - mid;
				}
			}
			if(total >= M) {
				start = mid + 1;
				ans = mid;
			}else {
				end = mid - 1;
			}
		}
		bw.write(end + "");
		bw.close();
	}
}