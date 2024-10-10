import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOError;
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
	static class Cloud{
		int x, y, time;
		public Cloud(int x, int y) {
			this.x = x;
			this.y = y;
			this.time = 0;
		}
	}
	public static void main(String[] args) throws IOException{
		StringTokenizer st = new StringTokenizer(br.readLine());
		int H = Integer.parseInt(st.nextToken());
		int W = Integer.parseInt(st.nextToken());
		int[][] map = new int[H][W];
		List<Cloud> cls = new ArrayList<>();
		for(int i = 0 ; i < H ; i++) {
			String[] input = br.readLine().split("");
			for(int j = 0 ; j < W ; j++) {
				String tile = input[j];
				map[i][j] = -1;
				if(tile.equals("c")) {
					cls.add(new Cloud(i, j));
				}
			}
		}
		
		for(int i = 0 ; i <= 100 ; i++) {
			for(Cloud c : cls) {
				if(c.y < W && map[c.x][c.y] == -1) {
					map[c.x][c.y] = c.time;					
				}
				c.y++;
				c.time++;
			}
		}
		for(int[] row : map) {
			for(int e : row) {
				System.out.print(e + " ");
			}
			System.out.println();
		}
	}

}
