import java.io.*;
import java.util.*;

public class Solution {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static void main(String[] args) throws IOException {
		  int TC = Integer.parseInt(br.readLine());
		  for(int tc = 1 ; tc < TC + 1 ; tc++) {
			 String N = br.readLine();
			 String[] arr = N.split("");
			 int n = Integer.parseInt(N);
			 int res = 0;
			 int t = 1;
			 for(int i = 0 ; i < arr.length ; i++) {
//				 System.out.println(arr[i]);
				 res  = res | (1 << Integer.parseInt(arr[i]));
			 }
			 while(true) {
//				 System.out.println(res);
				 if(res == (Math.pow(2, 10) - 1)){
					 break;
				 }
				 t++;
				 arr = Integer.toString(n * t).split("");
				 for(int i = 0 ; i < arr.length ; i++) {
//					 System.out.println(n * t);
					 res  = res | (1 << Integer.parseInt(arr[i]));
				 }
			 }
			 bw.write("#" + tc + " " + (n*t) + "\n");
			 
			 
		  }
		  bw.close();
	}
}