import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int N, M;
    static int[] lecs;
    static int ans = Integer.MAX_VALUE;
    static void search(int mx){
        int start = mx;
        int end = 0;
        for(int l : lecs) end += l;

        while(start <= end){
//            System.out.println(start + "/" + end);
            int mid = (start + end) / 2;
            int sum = 0;
            int cnt = 1;
            for(int i = 0 ; i < N ; i++){
                sum += lecs[i];
                if(sum > mid){
                    sum = lecs[i];
                    cnt++;
                    if(cnt > M) break;
                }
            }
            // 3개 안에 분리가 안된다 -> 제한 크기를 늘려야됨
            if(cnt > M){
                start = mid + 1;
            // 3개 안에 분리가 된다 -> 제한 크기를 줄여도 됨

            }else{
                ans = Math.min(ans, mid);
                end = mid - 1;
            }
        }
        System.out.println(ans);
    }
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        lecs = new int[N];
        st = new StringTokenizer(br.readLine());
        int mx = -1;
        for(int i = 0 ; i < N ; i++){
            lecs[i] = Integer.parseInt(st.nextToken());
            mx = Math.max(mx, lecs[i]);
        }

        search(mx);

    }
}
