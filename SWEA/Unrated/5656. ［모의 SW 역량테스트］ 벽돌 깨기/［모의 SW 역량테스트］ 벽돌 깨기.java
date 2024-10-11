import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class Solution {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static int N, W, H;
	static int[][] base;
	static int[][] map;
	static int[][] copyMap(){
		int[][] res = new int[H][W];
		for(int i = 0 ; i < H ; i++) {
			for(int j = 0 ; j < W ; j++) {
				res[i][j] = base[i][j];
			}
		}
		return res;
	}
	static void permutation(int[] sel, int depth) {
		if(depth == sel.length) {
			if(ans == 0) return;
			cal(sel);
//			System.out.println(Arrays.toString(sel));
			return;
		}
		for(int i = 0 ; i < W ; i++) {
			sel[depth] = i;
			permutation(sel, depth + 1);
		}
	}
	static void cal(int[] sel) {
		map = copyMap();
		for(int i = 0 ; i < sel.length ; i++) {
			int target = sel[i];
			for(int x = 0 ; x < H ; x++) {
				if(map[x][target] != 0) {
					process(x, target);
					break;
				}
			}
			gravity(map);
		}
		int cnt = 0;

		for(int i = 0 ; i < H ; i++) {
			for(int j = 0 ; j < W ; j++) {
				if(map[i][j] != 0) {
					cnt++;
				}
			}
		}
		ans = Math.min(cnt, ans);
	}
	static int[] dx = {1, 0, -1, 0};
	static int[] dy = {0, 1, 0, -1};
	static int ans = Integer.MAX_VALUE;
	static void process(int sx, int sy) {
		int l = map[sx][sy];
		map[sx][sy] = 0;
		for(int i = 0 ; i < 4 ; i++) {
			for(int j = 0 ; j < l ; j++) {
				int nx = sx + dx[i] * j;
				int ny = sy + dy[i] * j;
				if(0 <= nx && nx < H && 0 <= ny && ny < W && map[nx][ny] != 0) {
					process(nx, ny);
				}
			}
		}
	}
	static void gravity(int[][] arr) {
		Stack<Integer>stack=new Stack<Integer>();
		for(int j=0;j<W;j++) {
			for(int i=0;i<H;i++) {
				if(arr[i][j]>0)stack.push(arr[i][j]);
				arr[i][j]=0;
			}
			int index=H-1;
			while(!stack.empty()) {
				arr[index--][j]=stack.pop();
			}
		}
	}
	public static void main(String[] args) throws IOException {
		int TC = Integer.parseInt(br.readLine());
		for(int tc = 1 ; tc <= TC ; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());
			base = new int[H][W];
			map = new int[H][W];
			ans = Integer.MAX_VALUE;
			for(int i = 0 ; i < H ; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0 ; j < W ; j++) {
					base[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			map = copyMap();
//			for(int[] row : base) {
//				System.out.println(Arrays.toString(row));
//			}
//			System.out.println();
			permutation(new int[N], 0);
//			map = copyMap();
//			cal(new int[] {2, 2, 6});
			bw.write("#" + tc + " " + ans + "\n");
		}
		bw.close();
	}

}
