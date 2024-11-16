import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		PriorityQueue<int[]> q = new PriorityQueue<int[]>((a, b) -> {
			if(a[0] == b[0]) {
				return a[1]- b[1];
			}
			return a[0]-b[0];
		});
		for(int i = 0 ; i < N ; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			q.add(new int[] {x, y});
		}
		
		while(!q.isEmpty()) {
			int[] coord = q.poll();
			bw.write(coord[0] + " " + coord[1] + "\n");
		}
		bw.close();
	}

}