import java.util.*;
import java.io.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static void main(String[] args) throws IOException {
		long answer = 0;
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[][] jewels = new int[N][2];
		int[] bags = new int[K];
		
		for(int i = 0 ; i < N ; i++) {
			st = new StringTokenizer(br.readLine());
			int m = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			jewels[i] = new int[] {m, v};
		}
		for(int i = 0 ; i < K ; i++) {
			st = new StringTokenizer(br.readLine());
			bags[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(jewels, (a, b) -> {
			if(b[0] == a[0]) {
				return b[1] - a[1];
			}
			return a[0] - b[0];
		});
		Arrays.sort(bags);
		
		PriorityQueue<Integer> q = new PriorityQueue<>((a, b) -> b - a);
		int j = 0;
		for(int i = 0 ; i < K ; i++) {
			int bag = bags[i];
			while(j < N && bag >= jewels[j][0]) {
				q.offer(jewels[j++][1]);
			}
			if(!q.isEmpty()) {
				answer += q.poll();
			}
		}
		bw.write(answer + "");
		bw.close();
	}
}