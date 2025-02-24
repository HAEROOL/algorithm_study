import java.io.*;
import java.util.StringTokenizer;

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
        if(x > y){
            parent[x] = y;
        }else{
            parent[y] = x;
        }
        return true;
    }
    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        parent = new int[N];
        for(int i = 0 ; i < N ; i++){
            parent[i] = i;
        }
        int ans = 0;
        for(int i = 0 ; i < M ; i++){
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            if(!union(from, to)){
                ans = i + 1;
                break;
            };
        }
        bw.write(ans +"");
        bw.close();

    }
}

