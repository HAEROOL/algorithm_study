import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	public static void main(String[] args) throws IOException {
		long target = Integer.parseInt(br.readLine());
		int N = Integer.parseInt(br.readLine());
		long[] alist = new long[N];
		List<Long> adp = new ArrayList<>();
		List<Long> bdp = new ArrayList<>();
		Map<Long, Long> map = new HashMap<>();
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i < N + 1; i++) {
			alist[i - 1] = Long.parseLong(st.nextToken());
		}
		int M = Integer.parseInt(br.readLine());
		long[] blist = new long[M];
		long[] bsum = new long[M + 1];
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i < M + 1; i++) {
			blist[i - 1] = Long.parseLong(st.nextToken());
		}


		for (int start = 0; start < N; start++) {
			long res = 0;
			for (int end = start; end < N; end++) {
				res += alist[end];
				adp.add(res);
			}
		}
		Collections.sort(adp);
		for (int start = 0; start < M; start++) {
			long res = 0;
			for (int end = start; end < M; end++) {
				res += blist[end];
				bdp.add(res);
			}
		}
		Collections.sort(bdp);
//		System.out.println(bdp);
//		System.out.println(adp);
		int start = 0;
		int end = bdp.size() - 1;
		long ans = 0;
		while(start < adp.size() && end > - 1) {
			long atmp = adp.get(start), btmp = bdp.get(end);
//			System.out.println(atmp + " " + btmp);
			long sum = atmp + btmp;
			if(sum == target) {
				long acnt = 0, bcnt = 0;
				while(start < adp.size() && adp.get(start) == atmp) {
					acnt++;
					start++;
				}
				while(end > -1 && bdp.get(end) == btmp) {
					bcnt++;
					end--;
				}
//				System.out.println(acnt + " " + bcnt);
				ans += acnt * bcnt;
			}else if(sum > target) {
				end--;
			}else {
				start++;
			}
		}
		
		
		bw.write(ans + "");
		bw.close();
	}

}