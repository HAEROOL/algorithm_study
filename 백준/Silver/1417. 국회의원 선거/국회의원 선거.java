import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOError;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static void main(String[] args) throws IOException{
		int N = Integer.parseInt(br.readLine());
		int[] nums = new int[N];
		for(int i = 0 ; i < N ; i++) {
			nums[i] = Integer.parseInt(br.readLine());
		}

		int cnt = 0;
		while(true) {
//			System.out.println(Arrays.toString(nums));
			int mxx = 0;
			for(int i = 0 ; i < N ; i++) {
				if(nums[mxx] <= nums[i] ) {
					mxx = i;
				}
			}
			if(mxx == 0) break;
			nums[mxx]--;
			nums[0]++;
			cnt++;
		}
		System.out.println(cnt);
	}

}
