import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static int N, C;
	static int[] house;
	static void search() throws IOException {
		int start = 1;
		int ans = -1;
		int end = house[N - 1] - house[0];
		while(start <= end) {
			int mid = (start + end) / 2;
			int cnt = 1;
			int curr = house[0];
			for(int i = 1 ; i < N ; i++) {
				if(house[i] >= curr + mid) {
					cnt++;
					curr = house[i];
				}
			}
			if(cnt < C) {
				end = mid - 1;
			}else {
				start = mid + 1;
				ans = mid;
			}
		}
		bw.write(ans + "");
	}
	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		house = new int[N];
		for(int i = 0 ; i < N ; i++) {
			house[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(house);
		search();
		bw.close();

	}
}