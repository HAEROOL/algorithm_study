import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static void main(String[] args) throws IOException{
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[][] vals = new int[N][2];
		for(int i = 0 ; i < N ; i++) {
			st = new StringTokenizer(br.readLine());
			int m = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			vals[i] = new int[] {m, v};
		}
		int[] knapsack = new int[K];
		for(int i = 0 ; i < K ; i++) {
			knapsack[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(vals, (a, b) -> {
			if(a[0] == b[0]) {
				return b[1] - a[1];
			}
			return a[0] - b[0];
		});
		Arrays.sort(knapsack);
		
		PriorityQueue<Integer> q = new PriorityQueue<>(Comparator.reverseOrder());
		long ans = 0;

		
		int idx = 0;
		for(int i = 0; i < K ; i++) {
			while(idx < N && vals[idx][0] <= knapsack[i]) {
				q.offer(vals[idx][1]);
				idx++;
			}
			
			if(!q.isEmpty()) {
				ans += q.poll();
			}
		}
		
		
		bw.write(ans + "");
		bw.close();
	}
}