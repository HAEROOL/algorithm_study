import java.io.*;
import java.util.*;

public class Main {
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static void main(String[] args) throws IOException {
		int N = Integer.parseInt(br.readLine());
		
		PriorityQueue<Integer> plus = new PriorityQueue<>(Comparator.reverseOrder());
		PriorityQueue<Integer> minus = new PriorityQueue<>();
		for(int i = 0; i < N ; i++) {
			int n = Integer.parseInt(br.readLine());
			if(n > 0) {
				plus.add(n);
			}else {
				minus.add(n);
			}
		}
		
		long total = 0;
		
		while(!minus.isEmpty()) {
			int curr = minus.poll();
			if(minus.isEmpty()) {
				total += curr;
				break;
			}
			if(minus.peek() == 0) {
				minus.poll();
			}else {
				total += curr * minus.poll();
			}
		}
		
		while(!plus.isEmpty()) {
			int curr = plus.poll();
			if(plus.isEmpty()) {
				total += curr;
				break;
			}
			if(curr == 1) total += curr;
			else if(plus.peek() == 1) {
				total += curr + plus.poll();
			}
			else {				
				total += curr * plus.poll();
			}
		}
		
		bw.write(total+"\n");
		bw.close();
	}

}