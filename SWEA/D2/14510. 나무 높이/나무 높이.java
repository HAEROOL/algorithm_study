import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1 ; tc < T + 1; tc++) {
			int N = Integer.parseInt(br.readLine());
			int[] trees = new int[N];
			
			int maxHeight = Integer.MIN_VALUE;
			int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			for(int i = 0 ; i < N ; i++) {
				trees[i] = input[i];
				maxHeight = Math.max(maxHeight, trees[i]);
			}
			int ans = Integer.MAX_VALUE;
			
			ans = Math.min(ans,  watering(trees, N, maxHeight));
			ans = Math.min(ans,  watering(trees, N, maxHeight + 1));
			System.out.println("#" + tc + " " + ans);
		}
	}
	
	static int watering(int[] trees, int N, int maxHeight) {
		int days = 0;
		int ones = 0, twos = 0;
		
		for(int i = 0 ; i < N ; i++) {
			ones += (maxHeight - trees[i])%2;
			twos += (maxHeight - trees[i])/2;
		}
		
		int mins = Math.min(ones, twos);
		
		ones -= mins;
		twos -= mins;
		
		days += mins * 2;
		
		if(twos == 0) {
			days += (ones - 1) * 2 + 1;
		}
		if(ones == 0) {
			days += twos + 1 + (twos - 1) / 3;
		}
		return days;
	}

}
