import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int N, M;
    static int[] lecs;
    
    static int binarySearch(int maxLecture, long sumLectures){
        int start = maxLecture;
        int end = (int) sumLectures;
        int answer = end;
        
        while(start <= end){
            int mid = start + (end - start) / 2;
            int count = 1;
            int currentSum = 0;
            
            for(int i = 0; i < N; i++){
                if(currentSum + lecs[i] > mid){
                    count++;
                    currentSum = lecs[i];
                }
                else{
                    currentSum += lecs[i];
                }
            }
            
            if(count > M){
                start = mid + 1;
            }
            else{
                answer = Math.min(answer, mid);
                end = mid - 1;
            }
        }
        
        return answer;
    }
    
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        lecs = new int[N];
        st = new StringTokenizer(br.readLine());
        int maxLecture = 0;
        long sumLectures = 0;
        for(int i = 0; i < N; i++){
            lecs[i] = Integer.parseInt(st.nextToken());
            if(lecs[i] > maxLecture){
                maxLecture = lecs[i];
            }
            sumLectures += lecs[i];
        }

        int ans = binarySearch(maxLecture, sumLectures);
        bw.write(ans + "\n");
        bw.flush();
        bw.close();
    }
}
