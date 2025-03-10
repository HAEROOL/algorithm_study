import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int G, P;
    static int[] parents;
    static int find(int x){
        if(parents[x] == x) return x;
        return parents[x] = find(parents[x]);
    }

    static void union(int x, int y){
        x = find(x);
        y = find(y);
        if(x <= y){
            parents[y] = x;
        }else{
            parents[x] = y;
        }
    }
    public static void main(String[] args) throws IOException {
        // 게이트 G개
        // P개 비행기 순서대로 도착, 1번부터 G번까지 도킹하기
        G = Integer.parseInt(br.readLine());
        P = Integer.parseInt(br.readLine());
        parents = new int[G + 1];
        for(int i = 0 ; i < G + 1 ; i++){
            parents[i] = i;
        }
        int count = 0;
        for(int i = 0 ; i < P ; i++){
            int p = Integer.parseInt(br.readLine());
            int pp = find(p);
            if(pp != 0){
                union(pp, pp - 1);
                count++;
            }else{
                break;
            }
//            System.out.println(Arrays.toString(parents));
        }
        bw.write(count+"");
        bw.close();



    }
}
