import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException{
        int N = Integer.parseInt(br.readLine());
        int[] nums = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < N ; i++) {
        	nums[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(nums);
        int start = 0;
        int end = N - 1;
        int s = nums[start], e = nums[N - 1];
        while(start < end) {
        	int mid = Math.abs(nums[start] + nums[end]);
        	if(mid < Math.abs(s + e)) {
        		s = nums[start];
        		e = nums[end];
        		if(Math.abs(nums[start]) > Math.abs(nums[end])) {
        			start++;
        		}else if(Math.abs(nums[start]) < Math.abs(nums[end])){
        			end--;        			
        		}else {
        			break;
        		}
        	}else {
        		if(Math.abs(nums[start]) > Math.abs(nums[end])) {
        			start++;
        		}else {
        			end--;        			
        		}
        	}
        }
        if(s <= e) {
        	bw.write(s + " " + e);        	
        }else {
        	bw.write(e + " " + s);        	
        }
        bw.close();
    }

}