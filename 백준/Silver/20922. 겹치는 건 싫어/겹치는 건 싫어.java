import java.util.*;
import java.io.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		Map<Integer, Integer> map = new HashMap();
		st = new StringTokenizer(br.readLine());
		int[] nums = new int[N];
		for(int i = 0 ; i < N ; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		int answer = 1;
		int left = 0;
		int right = 1;
		map.put(nums[left], 1);
		while(left <= right) {
			if(right == N) break;
//			System.out.println(left + " : " + right);
			if(!map.containsKey(nums[right]) || map.get(nums[right]) < K) {
				map.putIfAbsent(nums[right], 0);
				map.replace(nums[right], map.get(nums[right]) + 1);
				right++;
				answer = Math.max(answer, right - left);
			}else {
				while(map.get(nums[right]) >= K) {
					map.replace(nums[left], map.get(nums[left]) - 1);
					left++;
				}
			}
		}
		
		bw.write(answer + "");
		bw.close();

	}
}