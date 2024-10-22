import java.io.*;
import java.util.*;

public class Solution {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static void dfs(int n, int total) {
		if(n == 13) {
			ans = Math.min(total, ans);
			return;
		}
		// 1일 이용권
		dfs(n + 1, total + plan[n] * cost[0]);
		// 1달 이용권
		dfs(n + 1, total + cost[1]);
		// 3달 이용권
		if(n < 11) {
			dfs(n + 3, total + cost[2]);			
		}
		
	}
	static int ans;
	static int[] cost;
	static int[] plan;
	public static void main(String[] args) throws IOException {
		  int TC = Integer.parseInt(br.readLine());
		  for(int tc = 1 ; tc < TC + 1 ; tc++) {
			  StringTokenizer st = new StringTokenizer(br.readLine());
			  cost = new int[4];
			  plan = new int[13];
			  for(int i = 0 ; i < 4 ; i++) {
				  cost[i] = Integer.parseInt(st.nextToken());
			  }
			  st = new StringTokenizer(br.readLine());
			  for(int i = 1 ; i < 13 ; i++) {
				  plan[i] = Integer.parseInt(st.nextToken());
			  }
			  ans = cost[3];
			  dfs(1, 0);
			  bw.write("#" + tc + " " + ans + "\n");
		  }
		  bw.close();
	}
}