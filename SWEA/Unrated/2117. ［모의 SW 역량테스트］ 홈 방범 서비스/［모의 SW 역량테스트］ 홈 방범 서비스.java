import java.io.*;
import java.util.*;

public class Solution {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args) throws IOException {
		  int TC = Integer.parseInt(br.readLine());
		  for(int tc = 1 ; tc < TC + 1 ; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int[][] map = new int[N][N];
			List<int[]> houses = new ArrayList<>();
			for(int i = 0 ; i < N ; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0 ; j < N ; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if(map[i][j] == 1) {
						houses.add(new int[] {i, j});
					}
				}
			}
			int size = 1;
			int mxcnt = 0;
			int maxProfit = houses.size() * M;
			while(true) {
				if((size * size + (size - 1) * (size - 1)) > maxProfit){
					break;
				}
				for(int i = 0 ; i < N ; i++) {
					for(int j = 0 ; j < N ; j++) {
						int cnt = 0;
						for(int[] house : houses) {
							int hx = house[0];
							int hy = house[1];
							if(Math.abs(hx - i) + Math.abs(hy - j) < size) {
								cnt ++;
							}
						}
//						System.out.println(cnt + " " + size);
						int res = (cnt * M) - (size * size + (size - 1) * (size - 1));
						if(res >= 0) {
							mxcnt = Math.max(mxcnt, cnt);
						}
					}
				}
				size++;
			}
			bw.write("#" + tc + " " + mxcnt + "\n");
		  }
		  bw.close();
	}
}