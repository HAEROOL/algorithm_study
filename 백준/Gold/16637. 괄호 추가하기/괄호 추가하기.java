import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static List<Integer> nums = new ArrayList<Integer>();
	static List<String> ops = new ArrayList<String>();
	static void run(int idx, int total) {
		if(idx >= ops.size()) {
			ans = Math.max(ans, total);
			return;
		}
		run(idx + 1, cal(ops.get(idx), total, nums.get(idx + 1)));
		if(idx + 1 < ops.size()) {
			int tmp = cal(ops.get(idx + 1), nums.get(idx + 1), nums.get(idx + 2));
			int res = cal(ops.get(idx), total, tmp);
			run(idx + 2, res);
		}
		
	}
	static int cal(String op, int a, int b) {
		if(op.equals("*")) {
			return a * b;
		}
		if(op.equals("+")) {
			return a + b;
		}
		if(op.equals("-")) {
			return a - b;
		}
		return 1;	
	}
	static int ans = Integer.MIN_VALUE;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		String[] input = br.readLine().split("");
		for(int i = 0 ; i < N ; i++) {
			if(i % 2 == 0) {
				nums.add(Integer.parseInt(input[i]));
			}else {
				ops.add(input[i]);
			}
		}
		run(0, nums.get(0));
		bw.write(ans + "");
		bw.flush();
	}
}