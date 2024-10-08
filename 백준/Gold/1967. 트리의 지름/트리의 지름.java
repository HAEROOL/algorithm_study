import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;


public class Main {
  static int ans = Integer.MIN_VALUE;
  static List<int[]>[] map;
  static boolean[] visited;

  static void dfs(int to, boolean[] visited, int total){
    visited[to] = true;
    ans = Math.max(total, ans);
    for(int i = 0 ; i < map[to].size() ; i++){
      int node = map[to].get(i)[0];
      int cost = map[to].get(i)[1];
      if(!visited[node]){
        dfs(node, visited, total + cost);
      }
    }
  }
  public static void main(String[] args) throws IOException {
    // TODO Auto-generated method stub
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st;
    int N = Integer.parseInt(br.readLine());
    map = new ArrayList[N];
    for(int i = 0 ; i < N ; i++){
      map[i] = new ArrayList<>();
    }
    visited = new boolean[N];
    for(int i = 0 ; i < N - 1 ; i ++){
      st = new StringTokenizer(br.readLine());
      int node1=Integer.parseInt(st.nextToken()) - 1;
      int node2=Integer.parseInt(st.nextToken()) - 1;
      int cost=Integer.parseInt(st.nextToken());
      map[node1].add(new int[] {node2,cost});
      map[node2].add(new int[] {node1,cost});
    }

    for(int i = 0 ; i < N ; i++){
      Arrays.fill(visited, false);
      dfs(i, visited, 0);
    }

    bw.write(ans + "");
    bw.flush();
    bw.close();
  }

}