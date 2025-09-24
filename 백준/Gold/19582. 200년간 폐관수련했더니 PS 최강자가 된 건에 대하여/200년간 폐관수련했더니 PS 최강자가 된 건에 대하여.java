import java.util.*;
import java.io.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static int N;
	static int[] prices, conditions, sums;

	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		prices = new int[N];
		conditions = new int[N];
		sums = new int[N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int condition = Integer.parseInt(st.nextToken());
			int price = Integer.parseInt(st.nextToken());
			conditions[i] = condition;
			prices[i] = price;
		}
		PriorityQueue<Long> q = new PriorityQueue<>((a, b) -> b.compareTo(a));
		long total = 0;
		boolean flag = false;
		for (int i = 0; i < N; i++) {
			long price = prices[i];
			long condition = conditions[i];

//			System.out.println(comp + " " + total);
//			System.out.println(q.size() + " " + total);
			if (total <= condition) {
				total += price;
				q.offer(price);
			} else {
				if(flag) {
					bw.write("Zzz");
					bw.close();
					return;
				}
				if(total - q.peek() <= condition && q.peek() > price) {
					total -= q.poll();
					total += price;
					q.offer(price);
				}
				flag = true;
			}
		}
//		System.out.println(comp);
		bw.write("Kkeo-eok");
		bw.close();

	}
}