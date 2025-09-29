import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        int[] dp = new int[n + 1];
        dp[1] = arr[0];
        
        for (int x = 1; x <= n; x++) {
            for (int y = 1; y <= x; y++) {
                dp[x] = Math.max(dp[x], dp[x - y] + arr[y - 1]);
            }
        }
        
        System.out.println(dp[n]);
    }
}