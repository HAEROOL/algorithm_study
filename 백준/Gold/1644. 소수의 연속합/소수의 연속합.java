import java.util.*;
import java.io.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static boolean[] isPrime;
	static void checkPrime(int n) {
		for(int i = 2 ; i <= Math.sqrt(n) ; i++) {
			if(isPrime[i]) {
				int j = 2;
				while(i * j <= n) {
					isPrime[i * j] = false;
					j++;
				}
			}
		}
	}
	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		isPrime = new boolean[N + 1];
		Arrays.fill(isPrime, true);
		isPrime[0] = false;
		isPrime[1] = false;
		checkPrime(N);
		if(N == 1) {
			System.out.println(0);
			return;
		}else if(N == 2) {
			System.out.println(1);
			return;
		}else {
			int left = 0;
			int right = 0;
//			for(int i = 0 ; i < N + 1 ; i++) {
//				System.out.println(i + ": " + isPrime[i]);
//			}
			List<Integer> primes = new ArrayList<>();
			int answer = 0;
			for(int i = 1 ; i < isPrime.length ; i++) {
				if(isPrime[i]) primes.add(i);
			}
//			System.out.println(primes);
			int total = primes.get(0);
			while(left <= right && left < primes.size() && right < primes.size()) {
//				System.out.println(total + " " + left + " " + right);
				
				if(total >= N) {
					if(total == N) answer++;
					total -= primes.get(left);
					left++;
					if(left == primes.size()) break;
				}else if(total < N) {
					right++;
					if(right == primes.size()) break;
					total += primes.get(right);
				}
			}
			bw.write(answer + "");
			bw.close();
		}
	}
}