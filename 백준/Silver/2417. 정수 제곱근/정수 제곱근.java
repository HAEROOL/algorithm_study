import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        long n = Long.parseLong(st.nextToken());
        
        long start = 0;
        long end = n;
        long answer = 0;
        
        while(start <= end) {
            long mid = (start + end) / 2;
            
            if(Math.pow(mid, 2) >= n) {
                answer = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        
        bw.write(answer + "");
        bw.close();
    }
}