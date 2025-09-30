import java.util.*;
import java.io.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());
		int K = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		int[] arr = new int[K];
		for(int i = 0 ; i < K ; i++) {
			st = new StringTokenizer(br.readLine());
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		long start = 0;
		long end = Long.MAX_VALUE;
		long answer = 0;
		while(start <= end) {
			long mid = (start + end) / 2;
//			System.out.println(mid);
			int cnt = 0;
			for(int i : arr) {
				cnt += i / mid;
			}
//			System.out.println(cnt);
			if(cnt >= N) {
				start = mid + 1;
				answer = mid;
			}else {
				end = mid - 1;
			}
		}
		bw.write(answer + "");
		bw.close();

	}
}