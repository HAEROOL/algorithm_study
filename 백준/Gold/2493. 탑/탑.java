import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static void main(String[] args) throws IOException {
		int N = Integer.parseInt(br.readLine());
		int[] nums = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0 ; i < N ; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		Deque<Integer> stack = new ArrayDeque<>();
		int[] ans = new int[N];
		for(int i = N - 1 ; i > -1 ; i--) {
			if(stack.isEmpty()) stack.push(i + 1);
			else {
				int tmp = stack.peek();
				if(nums[tmp - 1] < nums[i]) {
					while(!stack.isEmpty() && nums[stack.peek() - 1] < nums[i]) {
						ans[stack.pop() - 1] = i + 1;
					}
					stack.push(i + 1);
				}
				else {
					stack.push(i + 1);
				}
			}
		}
		for(int i = 0 ; i < N ; i++) {
			bw.write(ans[i] + " ");
		}
		bw.close();
	}
}