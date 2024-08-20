import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        // 입력 V, E, 인접리스트
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        List<int[]>[] map = new ArrayList[V + 1];
        for(int i = 0 ; i < V + 1 ; i++) {
        	map[i] = new ArrayList<int[]>();
        }
        for(int i = 0 ; i < E ; i++) {
        	st = new StringTokenizer(br.readLine());
        	int from = Integer.parseInt(st.nextToken());
        	int to = Integer.parseInt(st.nextToken());
        	int w = Integer.parseInt(st.nextToken());
        	map[from].add(new int[] {to, w});
        	map[to].add(new int[] {from, w});
        }
//        for(List<int[]> row : map) {
//        	for(int[] v : row) {
//        		System.out.print("[" + v[0] + " " + v[1] + "]");
//        	}
//        	System.out.println();
//        }
        // mst 알고리즘(프림)
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((a, b) -> a[1] - b[1]);
        int[] dist = new int[V + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        boolean[] visited = new boolean[V + 1];
        
        dist[1] = 0;
        pq.offer(new int[] {1, 0});
        int ans = 0;
        while(!pq.isEmpty()) {
        	int[] n = pq.poll();
        	int node = n[0];
        	if(visited[node]) continue;
        	visited[node] = true;
        	for(int[] nextNode : map[node]) {
        		int nextn = nextNode[0];
        		int nextw = nextNode[1];
        		if(!visited[nextn] && dist[nextn] > nextw) {
        			dist[nextn] = nextw;
        			pq.add(new int[] {nextn, nextw});
        		}
        	}
        }
        for(int i = 1 ; i < dist.length ; i++) {
        	ans += dist[i];
        }
        System.out.println(ans);
        
    }
}