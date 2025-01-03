import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException{
        int N = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine());
        long start = 1;
        long end = K;
        long ans = 0;
        while(start <= end) {
            long mid = (start + end) / 2;
            long cnt = 0;
            for(int i = 1 ; i <= N ; i++) {
            	cnt += Math.min(mid / i, N);
            }
            
            if(K <= cnt) {
            	ans = mid;
            	end = mid -1;
            }else {
            	start = mid + 1;
            }
        }
        bw.write(ans + "");
        bw.close();
    }

}