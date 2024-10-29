import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		long min = Long.MAX_VALUE;
		int r1 = 0, r2 = 0, r3 = 0;
		out : for(int i = 0; i < n - 2 ; i++) {
			int start = i + 1;
			int end = n - 1;
			
			while(start < end) {
				long sum = (long)arr[i]+ arr[start] +arr[end];
				if(min > Math.abs(sum)) {
					min = Math.abs(sum);
					r1 = i;
					r2 = start;
					r3 = end;
				}
				if(sum==0) {
					r1 = i;
					r2 = start;
					r3 = end;
					break out;
				}else if(sum > 0){
					end--;
				}else {
					start++;
				}
				
			}
		}
		System.out.println(arr[r1]+" " + arr[r2] + " " + arr[r3]);
	}
}