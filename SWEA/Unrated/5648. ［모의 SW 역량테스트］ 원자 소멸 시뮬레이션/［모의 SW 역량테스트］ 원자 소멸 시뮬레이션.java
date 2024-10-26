import java.io.*;
import java.util.*;

public class Solution {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	
	static class Atom{
		int x, y, d, id, val;
		boolean isalive;
		Atom(int x, int y, int d, int val, int id){
			this.x = x;
			this.y = y;
			this.d = d;
			this.id = id;
			this.val = val;
			this.isalive = true;
			
		}
		void move(){
			int nx = x + dx[d];
			int ny = y + dy[d];
			if(0 <= nx && nx < 4001 && 0 <= ny && ny < 4001) {
				map[x][y] = 0;
				if(map[nx][ny] != 0) {
//					System.out.println(map[nx][ny] +" " + atoms.length);
					atoms[map[nx][ny]].isalive = false;
					atoms[this.id].isalive = false;
				}else {
					this.x = nx;
					this.y = ny;
					map[x][y] = this.id;	
				}
			}else {
				map[x][y] = 0;
				isdead[id] = true;
				cnt++;
			}
		}
	}
	static int[][] map = new int[4001][4001];
	static Atom[] atoms;
	static int ans;
	static int cnt;
	static boolean[] isdead;
	public static void main(String[] args) throws IOException {
		  int TC = Integer.parseInt(br.readLine());
		  for(int tc = 1 ; tc < TC + 1 ; tc++) {
//			 List<Atom> log = new ArrayList<>();
			 int N = Integer.parseInt(br.readLine());
			 atoms = new Atom[N + 1];
			 isdead = new boolean[N + 1];
			 ans = 0;
			 cnt = 0;
			 StringTokenizer st;
			 for(int i = 1 ; i < N + 1 ; i++) {
				 st = new StringTokenizer(br.readLine());
				 int y = (Integer.parseInt(st.nextToken()) + 1000) * 2;
				 int x = 4000 -(Integer.parseInt(st.nextToken()) + 1000) * 2;
				 int d = Integer.parseInt(st.nextToken());
				 int K = Integer.parseInt(st.nextToken());
				 atoms[i] = new Atom(x, y, d, K, i);
				 map[x][y] = i;
//				 System.out.println(map[x][y]);
			 }
//			 System.out.println(atoms);
			 while(cnt != N) {
//				 System.out.println(cnt);
				 for(int i = 1 ; i < N + 1 ; i++) {
					 if(isdead[atoms[i].id]) continue;
					 atoms[i].move();
				 }
				 for(int i = 1 ; i < N + 1 ; i++) {
					 Atom a = atoms[i];
					 if(!a.isalive && !isdead[a.id]) {
//						 log.add(a);
						 ans += a.val;
						 map[a.x][a.y] = 0;
						 isdead[a.id] = true;
						 cnt++;
					 }
				 }	
//				 for(Atom a : atoms) {
//					 if(a == null) continue;
//					 System.out.println(a.id + " " + a.x + " " + a.y + " " + a.val);
//				 }
			 }
//			 System.out.println("log---------------------");
//			 for(Atom l : log) {
//				 System.out.println(l.id + " " + l.x + " " + l.y + " " + l.val);
//			 }
			 bw.write("#" + tc + " " + ans + "\n");
		  }
		  bw.close();
	}
}