import java.io.*;
import java.util.*;

public class Solution {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static class Cell{
		int x, y, life, sleep, power;
		boolean isdead;
		Cell(int x, int y, int life){
			this.x = x;
			this.y = y;
			this.life = life;
			this.sleep = life;
			this.power = life;
			this.isdead = false;
		}
		
	}
	static int[] dx = {1, 0, -1, 0};
	static int[] dy = {0, 1, 0, -1};
	public static void main(String[] args) throws IOException {
		  int TC = Integer.parseInt(br.readLine());
		  for(int tc = 1 ; tc < TC + 1 ; tc++) {
			  PriorityQueue<Cell> cells = new PriorityQueue<>((a, b) -> {
				  return b.power - a.power;
			  });
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			int[][] map = new int[N][M];
			Map<String, Boolean> coordMap = new HashMap<>(); 
			for(int i = 0 ; i < N ; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0 ; j < M ; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if(map[i][j] != 0) {
						cells.add(new Cell(i, j, map[i][j]));
						coordMap.put(i + " " + j, true);
					}
				}
			}
			for(int time = 0 ; time < K ; time++) {
				PriorityQueue<Cell> nCells = new PriorityQueue<>((a, b) -> {
					  return b.power - a.power;
				  });
				while(!cells.isEmpty()) {
					Cell cell = cells.poll();
					// 비활성화 상태라면 sleep - 1
					if(cell.sleep > 0) {
						cell.sleep--;
						nCells.offer(cell);
						continue;
					}
					// 비활성화 상태 아니고, life가 0보다 크다면 life - 1하고 증식
					if(cell.sleep == 0) {
						cell.sleep--;
						for(int i = 0 ; i < 4 ; i++) {
							int nx = cell.x + dx[i];
							int ny = cell.y + dy[i];
							String key = nx + " " + ny;
							if(!coordMap.containsKey(key)) {
								nCells.add(new Cell(nx, ny, cell.power));
								coordMap.put(key, true);
							}
									
						}
					}
					if(!cell.isdead && cell.life > 0) {
						cell.life--;
						nCells.add(cell);
					}
					if(!cell.isdead && cell.life == 0) {
						cell.isdead = true;
					}

				}
				cells = nCells;
			}
			int cnt = 0;
			for(Cell cell : cells) {
				if(!cell.isdead) cnt++;
			}
			bw.write("#" + tc + " " + cnt + "\n");
		  }
		  bw.close();
	}
}