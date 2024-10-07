import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.StringTokenizer;


public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args) throws IOException {
		StringTokenizer st =  new StringTokenizer(br.readLine());
		// 트럭 수
		int n = Integer.parseInt(st.nextToken());
		// 다리 길이
		int w = Integer.parseInt(st.nextToken());
		// 최대 하중
		int L = Integer.parseInt(st.nextToken());
		int total = 0;
		int time = 0;
		int[] trucks = new int[n + 1];
		st = new StringTokenizer(br.readLine());
		for(int i = 1 ; i <= n ;i++) {
			trucks[i] = Integer.parseInt(st.nextToken());
		}
		
		int[] bridge = new int[w];
		int cnt = 0;
		int next = 1;
		while(true) {
//			System.out.println(Arrays.toString(bridge));
			if(bridge[w - 1] != 0) {
				total -= trucks[bridge[w - 1]];
				cnt++;
			}
			for(int i = w - 1 ; i > 0 ;i--) {
				bridge[i] = bridge[i - 1];
			}
			bridge[0] = 0;
			if(next <= n && total + trucks[next] <= L) {
				total += trucks[next];
				bridge[0] = next;
				next++;
			}
			time++;
			if(cnt == n) break;
		}
		System.out.println(time);
	}
}