import java.io.*;
import java.util.*;

public class Solution {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static List<Integer>[] gears;
	static boolean[] v;
	static void rotate(int gear, int dir) {
		v[gear] = true;
		// 오른쪽으로
		if(dir == 1) {
			int ngear = gear + 1;
			if(ngear < 4 && !v[ngear] && gears[gear].get(2) != gears[ngear].get(6)) {
				rotate(ngear, dir * -1);
			}
			ngear = gear - 1;
			if(ngear >= 0 && !v[ngear] && gears[gear].get(6) != gears[ngear].get(2)) {
				rotate(ngear, dir * -1);
			}
			gears[gear].add(0, gears[gear].remove(gears[gear].size() - 1));
		}else {
			int ngear = gear + 1;
			if(ngear < 4 && !v[ngear] && gears[gear].get(2) != gears[ngear].get(6)) {
				rotate(ngear, dir * -1);
			}
			ngear = gear - 1;
			if(ngear >= 0 && !v[ngear]&& gears[gear].get(6) != gears[ngear].get(2)) {
				rotate(ngear, dir * -1);
			}
			gears[gear].add(gears[gear].size() - 1, gears[gear].remove(0));
		}
	}
	public static void main(String[] args) throws IOException {
		  int TC = Integer.parseInt(br.readLine());
		  for(int tc = 1 ; tc < TC + 1 ; tc++) {
			  int ans = 0;
			  gears = new ArrayList[4];
			  int K = Integer.parseInt(br.readLine());
			  StringTokenizer st;
			  for(int i = 0 ; i < 4 ; i++) {
				  st = new StringTokenizer(br.readLine());
				  gears[i] = new ArrayList<>();
				  for(int j = 0 ; j < 8 ; j++) {
					  gears[i].add(Integer.parseInt(st.nextToken()));
				  }
			  }
			  for(int i = 0 ; i < K ; i++) {
				  st = new StringTokenizer(br.readLine());
				  int g = Integer.parseInt(st.nextToken()) - 1;
				  int dir = Integer.parseInt(st.nextToken());
				  v = new boolean[4];
				  rotate(g, dir);
			  }
			  for(int i = 0 ; i < 4 ; i++) {
				  if(gears[i].get(0) == 1) {
					  ans += Math.pow(2, i);
				  }
			  }
			  bw.write("#" + tc +" " + ans + "\n");
		  }
		  bw.close();
	}
}