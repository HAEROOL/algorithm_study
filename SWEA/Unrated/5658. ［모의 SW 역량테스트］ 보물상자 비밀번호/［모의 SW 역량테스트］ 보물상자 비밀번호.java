import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int TC = Integer.parseInt(br.readLine());
		for(int tc = 1 ; tc < TC + 1 ;tc++) {
			// 입력
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			List<String> q = new ArrayList<String>();
			String[] input = br.readLine().split("");
			for(int i = 0 ; i < N ; i++) {
				q.add(input[i]);
			}
			
			Set<Long> s = new HashSet<Long>();
			// 숫자 구하기
			for(int k = 0 ; k < N / 4 ; k++) {
				for(int i = 0 ; i < 4 ; i++) {
					String num[] = new String[N / 4];
					for(int j = 0; j < N / 4 ; j++) {
						num[j] = q.get(i*N/4 + j);
					}
					// 숫자 변
//					System.out.println(Arrays.toString(num));
					long hexNum = getHex(num);
					s.add(hexNum);
				}
				q.add(0, q.remove(q.size() - 1));
			}
			List<Long> result = new ArrayList<Long>(s);
			Collections.sort(result, (x, y) -> Long.compare(y, x));
//			System.out.println(result.toString());
			bw.write("#"+ tc + " " + result.get(K - 1) + "\n");
			bw.flush();
		 	
		}
	}
	static long getHex(String[] num) {
		long res = 0;
		for(int i = num.length - 1 ; i > -1; i--) {
			res += Long.parseLong(num[num.length - i - 1], 16) * Math.pow(16, i);
		}
		return res;
	}

}
