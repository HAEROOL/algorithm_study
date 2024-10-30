import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException{
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	int N = Integer.parseInt(st.nextToken());
    	int target = Integer.parseInt(st.nextToken());

    	Map<Integer, Integer> map = new HashMap<>();
    	map.put(0, 0);
    	for(int i = 0 ; i < N ; i++) {
    		st = new StringTokenizer(br.readLine());
    		int a = Integer.parseInt(st.nextToken());
    		int b = Integer.parseInt(st.nextToken());
    		if(a >= b) {
    			map.put(0, map.get(0) + 1);
    		}
    		else {
    			int raise = b - a;
    			if(map.containsKey(raise)) {
    				map.put(raise, map.get(raise) + 1);
    			}else {
    				map.put(raise, 1);
    			}
    		}
    	}
    	List<Integer> keySet = new ArrayList<>(map.keySet());
    	Collections.sort(keySet);
    	int ans = -1;
    	int cnt = 0;
    	for(int key : keySet) {
    		cnt += map.get(key);
    		if(cnt >= target) {
    			ans = key;
    			break;
    		}
    	}
//    	for(int key : keySet) {
//    		System.out.println(key + " " + map.get(key));
//    	}
    	bw.write(ans + "");
        bw.close();
    }

}