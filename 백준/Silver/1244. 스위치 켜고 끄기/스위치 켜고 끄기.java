import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	static int[] nums;
	public static void main(String[] args) throws NumberFormatException, IOException {
		int N = Integer.parseInt(br.readLine());
		nums = new int[N + 1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 1 ; i < N + 1 ; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		int stnum = Integer.parseInt(br.readLine());
		for(int n = 0 ; n < stnum ; n++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int idx = Integer.parseInt(st.nextToken());
			if(s == 1) {
				for(int i = idx ; i < N + 1 ; i++) {
					if(i % idx == 0) {
						nums[i] = (nums[i] + 1) % 2;
					}
				}
			}else {
				int cnt = 0;
				while(true) {
					int nridx = idx + cnt + 1;
					int nlidx = idx - cnt - 1;
					if(nridx >= N + 1 ||nlidx < 1) break;
					if(nums[nridx] != nums[nlidx]) {
						break;
					}
					cnt++;
				}
				for(int i = idx - cnt ; i < idx + cnt + 1 ; i++) {
					nums[i] = (nums[i] + 1) % 2;
				}
			}
//			System.out.println(Arrays.toString(nums));
		}
		for(int i = 1 ; i < N + 1 ; i++) {
			bw.write(nums[i] + " ");
			if(i % 20 == 0) bw.write("\n");
		}
		bw.close();		
	}

}
