import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int N, M;
    static int[] parent;
    static int find(int x){
        if(parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }
    static boolean union(int x, int y){
        x = find(x);
        y = find(y);
        if(x == y) return false;
        if(x > y) parent[x] = y;
        if(x < y) parent[y] = x;
        return true;
    }
    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        List<Integer>[] parties = new ArrayList[M];
        parent = new int[N + 1];
        for(int i = 0 ; i < N + 1 ; i++){
            parent[i] = i;
        }
        st = new StringTokenizer(br.readLine());
        int k = Integer.parseInt(st.nextToken());
        for(int i = 0 ; i < k ; i++){
            int x = Integer.parseInt(st.nextToken());
            parent[x] = 0;
        }
        for(int i = 0 ; i < M ; i++){
            st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int[] arr = new int[p];
            parties[i] = new ArrayList<>();
            for(int j = 0 ; j < p ; j++){
                arr[j] = Integer.parseInt(st.nextToken());
                parties[i].add(arr[j]);
            }
            for(int j = 0 ; j < p ; j++) {
                for(int a = j + 1 ; a < p ; a++){
                    union(arr[j], arr[a]);
                }
            }
        }
        for(int i = 0 ; i < M ; i++) {
            for(int j = 0 ; j < parties[i].size() ; j++){
                for(int z = j + 1 ; z < parties[i].size() ; z++) {
                    union(parties[i].get(j),parties[i].get(z));
                }
            }
        }
        int ans = 0;
        for(List<Integer> party : parties){
            boolean isCount = true;
            for(int i : party){
                if(parent[i] == 0){
                    isCount = false;
                    break;
                }
            }
            if(isCount) ans++;
        }

        bw.write(ans+"");
        bw.close();
    }
}

