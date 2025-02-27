import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        int ans = Integer.MAX_VALUE;

        int N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for(int i = 0 ; i < N ; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        List<int[]> h1s = new ArrayList<>();
        for(int i = 0 ; i < N; i++){
            for(int j = i + 1 ; j < N ; j++){
                h1s.add(new int[]{arr[i] + arr[j], i, j});
            }
        }
        for(int[] h1a : h1s){
            int h1 = h1a[0];
            int start = h1a[1];
            int end = h1a[2];
            int left = 0, right = N - 1;
            boolean[] v = new boolean[N];
            v[start] = true;
            v[end] = true;
            while(v[left] || left == right) left++;
            while(v[right] || left == right) right--;
            while(left < right){
                int h2 = arr[left] + arr[right];
//                System.out.println(left + " " + right);
                ans = Math.min(ans, Math.abs(h1 - h2));
                if(h2 > h1){
                    right--;
                    while(v[right]) right--;
                }else if(h2 < h1) {
                    left++;
                    while(v[left]) left++;
                }else{
                    break;
                }
            }
        }
        bw.write(ans+"");
        bw.close();
    }
}

