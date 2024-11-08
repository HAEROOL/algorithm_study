import java.io.*;
import java.util.*;

public class Solution {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static class Robot{
		int x, y, dir;
		Robot(){
			this.x = 0;
			this.y = 0;
			this.dir = 1;
		}
		
		void rotateR(){
			dir = (dir + 1) % 4;
		}
		
		void rotateL() {
			dir--;
			if(dir < 0) dir = 3;
		}
		void move() {
			x += dx[dir];
			y += dy[dir];
		}
	}
	// 상 우 하 좌
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};
	public static void main(String[] args) throws IOException {
		int TC = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= TC; tc++) {
			String[] inputs = br.readLine().split("");
			int ans = 0;
			Robot r = new Robot();
			for(int i = 0 ; i < 4 ; i++) {
				int sdir = r.dir;
				for(int j = 0 ; j < inputs.length ; j++) {
					if(inputs[j].equals("R")) {
						r.rotateR();
					}else if(inputs[j].equals("L")) {
						r.rotateL();
					}else if(inputs[j].equals("S")) {
						r.move();
					}
					ans = Math.max(ans, Math.abs(r.x) * Math.abs(r.x) + Math.abs(r.y) * Math.abs(r.y));
				}
				if(r.x == 0 && r.y == 0) {
					break;
				}
				if(r.dir == sdir) {
					ans = -1;
					break;
				}
			}
			if(ans == -1) {
				bw.write("#" + tc + " " + "oo" + "\n");
			}else {
				bw.write("#" + tc + " " + ans + "\n");
			}
			
		}
		
		bw.close();
	}

}
