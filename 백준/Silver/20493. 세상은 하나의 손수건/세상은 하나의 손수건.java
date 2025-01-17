import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, T;
	static int dr[] = {1, 0, -1, 0};
	static int dc[] = {0, -1, 0, 1};
	static int cR, cC, time, dir, curTime, totalTime;
	static String d;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken()); // 방향 바꾼 횟수
		T = Integer.parseInt(st.nextToken()); // 총 걸어간 시간
		
		for (int tc = 0; tc < N; tc++) {
			st = new StringTokenizer(br.readLine(), " ");
			totalTime = Integer.parseInt(st.nextToken());  
			curTime = totalTime - curTime;
			cR = cR + dr[dir] * curTime;
			cC = cC + dc[dir] * curTime;
			d = st.nextToken();
			if(d.equals("right")) {
				dir = (dir + 1) % 4;
			}else if(d.equals("left")) {
				dir = (dir + 3) % 4;
			}
			curTime = totalTime;
		}
		
		curTime = T - totalTime;
		cR = cR + dr[dir] * curTime;
		cC = cC + dc[dir] * curTime;
		System.out.println(cR + " " + cC);
	}
}