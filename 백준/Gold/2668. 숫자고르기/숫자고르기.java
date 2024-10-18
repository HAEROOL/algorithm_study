import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static int N;
	static int[] arr;
	static Set<Integer> ans = new HashSet();
	static void dfs(int n, boolean[] v) {
		int next = arr[n];
		if(!v[next]) {
			v[next] = true;
			dfs(next, v);
		}
	}
    public static void main(String[] args) throws IOException{
        N = Integer.parseInt(br.readLine());
        arr = new int[N + 1];
        for(int i = 1 ; i < N + 1 ; i++) {
        	arr[i] = Integer.parseInt(br.readLine());
        }
        for(int i = 1 ; i < N + 1 ; i++) {
        	boolean[] v = new boolean[N + 1];
        	dfs(i, v);
//        	System.out.println(Arrays.toString(v));
        	if(v[i]) {
        		for(int j = 1 ; j < N + 1 ; j++) {
        			if(v[j])ans.add(j);
        		}
        	}
        }
        List<Integer> anslist = new ArrayList<>(ans);
        Collections.sort(anslist);
//        System.out.println(anslist.toString());
        bw.write(ans.size() + "\n");
        for(int a : anslist) {
        	bw.write(a + "\n");
        }
        bw.close();
    }

}