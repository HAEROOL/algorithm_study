import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int[][] mapv;
    static int[][] map;
    static int N;
    public static void main(String[] args) throws IOException{
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];

        mapv = new int[N][N];

        StringTokenizer st;
        for(int i = 0 ; i < N ; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0 ; j < N ; j++){
                mapv[i][j] = i + 1;
            }
        }

        for(int[] row : mapv){
            for(int e : row){
                bw.write(e + " ");
            }
            bw.write("\n");
        }
        bw.close();
    }
}
