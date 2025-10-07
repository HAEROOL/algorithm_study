import java.util.*;
import java.io.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());
		int F = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		int G = Integer.parseInt(st.nextToken());
		int U = Integer.parseInt(st.nextToken());
		int D = Integer.parseInt(st.nextToken());
		boolean[] v = new boolean[F + 1];
		Deque<int[]> q = new ArrayDeque<int[]>();
		
		q.offer(new int[] {S, 0});
		v[S] = true;
		int answer = -1;
		while(!q.isEmpty()) {
			int[] f = q.poll();
			int floor = f[0];
			int cnt = f[1];
			
			if(floor == G) {
				answer = cnt;
				break;
			}
			
			int uf = floor + U;
			int df = floor - D;
			
			if(uf <= F && !v[uf]) {
//				System.out.println(uf);
				q.offer(new int[] {uf, cnt + 1});
				v[uf] = true;
			}
			if(df > 0 && !v[df]) {
				q.offer(new int[] {df, cnt + 1});
				v[df] = true;
			}
			
			
		}
		if(answer == -1) {
			bw.write("use the stairs");			
		}else {
			bw.write(answer + "");
		}
		bw.close();
		
		
	}
}