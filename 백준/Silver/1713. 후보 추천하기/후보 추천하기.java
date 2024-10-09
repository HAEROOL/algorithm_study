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
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static int N;
	static class Picture{
		int id, recommand, time;
		public Picture(int id, int time) {
			this.id = id;
			this.time = time;
			this.recommand = 1;
		}
	}
	static Picture[] pictures;
	static boolean[] v;
	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(br.readLine());
		int T = Integer.parseInt(br.readLine());
		pictures = new Picture[N];
		v = new boolean[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int t = 0 ; t < T ; t++) {
			int p = Integer.parseInt(st.nextToken());
			boolean isUpload = false;
			// 후보자가 배열에 있으면 추천수 증가
			for(int i = 0 ; i < N ; i++) {
				if(pictures[i] != null && pictures[i].id == p) {
					pictures[i].recommand++;
					isUpload = true;
					break;
				}
			}
			if(isUpload) continue;
			// 없고, 빈자리 있으면 거기가 추가
			for(int i = 0 ; i < N  ; i++) {
				if(!v[i]) {
					pictures[i] = new Picture(p, t);
					v[i] = true;
					isUpload = true;
					break;
				}
			}
			if(isUpload) continue;
			// 없고 빈자리도 없으면, 추천수 적고, 오래된 순으로 삭제
			
			int idx = 0;
			if(pictures[idx] == null ) {
				continue;
			}
			for(int i = 1 ; i < N ; i++) {
				if(pictures[i] != null && pictures[i].recommand < pictures[idx].recommand) {
					idx = i;
				}else if(pictures[i] != null && pictures[i].recommand == pictures[idx].recommand && pictures[i].time < pictures[idx].time) {
					idx = i;
				}
			}
			
			pictures[idx] = new Picture(p, t);
			v[idx] = true;
		}
		List<Integer> ans = new ArrayList<>();
		for(Picture p : pictures) {
			if(p == null) continue;
			ans.add(p.id);
		}
		ans.sort((a, b) -> a - b);
		for(int e : ans) {
			System.out.print(e + " ");
		}
	}
}