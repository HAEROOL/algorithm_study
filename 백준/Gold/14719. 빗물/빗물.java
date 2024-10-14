import java.io.*;
import java.util.*;
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());
		int H = Integer.parseInt(st.nextToken());
		int W = Integer.parseInt(st.nextToken());
	
		int[] heights = new int[W];
		st = new StringTokenizer(br.readLine());
		for(int i = 0 ; i < W ; i++) {
			heights[i] = Integer.parseInt(st.nextToken());
		}
		int total = 0;
		for(int i = 1 ; i < W - 1 ; i++) {
			int leftmx = -1;
			int rightmx = -1;
			for(int j = i - 1 ; j > -1 ; j--) {
				if(heights[j] > heights[i] && leftmx < heights[j]) {
					leftmx = heights[j];
				}
			}
			for(int j = i + 1 ; j < W ; j++) {
				if(heights[j] > heights[i] && rightmx < heights[j]) {
					rightmx = heights[j];
				}
			}
			if(leftmx == -1 || rightmx == -1) continue;
//			System.out.println(leftmx + " " + rightmx + " " + i + " " + (Math.min(leftmx, rightmx) - heights[i]));
			total += Math.min(leftmx, rightmx) - heights[i];
		}
		bw.write(total + "");
		bw.close();
	}
}