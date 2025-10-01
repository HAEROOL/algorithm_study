import java.util.*;
import java.io.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		int[] arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i = 0 ; i < N ; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		
		int start = 1;
		int end = arr[N - 1];
		int answer = 0;
		while(start <= end) {
			int mid = (start + end) / 2;
			int total = 0;
			for(int i : arr) {
				total +=  i / mid;
			}
			
			if(total < M) {
				end = mid - 1;
			}else {
				answer = mid;
				start = mid + 1;
			}
		}
		bw.write(answer + "");
		bw.close();

	}
}