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

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static int N;
	static List<Integer>[] map;
	static int[] people;
	static int ans = Integer.MAX_VALUE;
	static boolean bfs(boolean[] arr, boolean area) {
		Deque<Integer> q = new ArrayDeque<Integer>();
		int st = -1;
		boolean[] visited = new boolean[N + 1];
		for(int i = 0 ; i < arr.length ; i++) {
			if(arr[i] == area) {
				st = i + 1;
				break;
			}
		}
		q.offer(st);
		visited[st] = true;
		while(!q.isEmpty()){
			int n = q.poll();
			for(int i = 0 ; i < map[n].size() ; i++) {
				int node = map[n].get(i);
				if(!visited[node] && arr[node - 1] == area) {
					visited[node] = true;
					q.offer(node);
				}
			}
		}
		for(int i = 0 ; i < N ; i++) {
			if(arr[i] == area && !visited[i + 1]) {
				return false;
			}
		}
		return true;
	}
	static void cal(boolean[] arr) {
		int acnt = 0, bcnt = 0;
		for(boolean i : arr) {
			if(i) acnt++;
			else bcnt++;
		}
		if(acnt == 0 || bcnt == 0) return;
		int atotal = 0, btotal = 0;
		if(bfs(arr, true) && bfs(arr, false)) {
			for(int i = 0 ; i < arr.length ; i++) {
				if(arr[i]) {
					atotal += people[i];
				}else {
					btotal += people[i];
				}
			}
			ans = Math.min(Math.abs(btotal - atotal), ans);
		}
	}
	static void getSubsets(int idx, int k, boolean[] sel) {
		if(k == sel.length) {
			cal(sel);
			return;
		}
		if(idx == sel.length) {
			cal(sel);
			return;
		}
		sel[idx] = true;
		getSubsets(idx + 1, k + 1, sel);
		sel[idx] = false;
		getSubsets(idx + 1, k, sel);
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		N = Integer.parseInt(br.readLine());
		map = new ArrayList[N + 1];
//		for(int i = 1 ; i < N + 1 ; i++) {
//			map[i] = new ArrayList<>();
//		}
		people = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		for(int i = 1 ; i < N + 1 ; i++) {
			List<Integer> list = new ArrayList<>();
			int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			for(int j = 1 ; j < input[0] + 1 ; j++) {
				list.add(input[j]);
			}
			map[i] = list;
		}
		getSubsets(0, 1, new boolean[N]);
		System.out.println(ans == Integer.MAX_VALUE?-1:ans);
	}
}
