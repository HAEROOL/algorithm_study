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
	static void search() throws IOException {
		long start = 0;
		long end = gate[(int) (N - 1)] * M;
		while(start <= end) {
			long mid = (start + end) / 2;
			long total = 0;
			for(int i = 0 ; i < N ; i++) {
				total += mid/gate[i];
				if(total > M) break;
			}
			if(total < M) {
				start = mid + 1;
			}else {
				end = mid - 1;
			}
		}
		bw.write(start +"");
	}

	static long[] gate;
	static long N, M;
	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Long.parseLong(st.nextToken());
		M = Long.parseLong(st.nextToken());
		gate = new long[(int) N];
		for(int i = 0 ; i < N ; i++) {
			gate[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(gate);
		
		search();
		bw.close();

	}
}