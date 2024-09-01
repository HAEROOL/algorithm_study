import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int n,m,R[],B[], O[], min;
	static boolean visited[][][][];
	static char map[][];
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new char[n][m];
		
		for(int i=0; i<n; i++) {
			map[i] = br.readLine().toCharArray();
			for(int j=0; j<m; j++) {
				if(map[i][j]=='B') B = new int[] {i, j};
				else if(map[i][j]=='R') R = new int[] {i, j};
				else if(map[i][j]=='B') O = new int[] {i,j};
			}
		}
		
		visited = new boolean[n][m][n][m];
		min = Integer.MAX_VALUE;
		bfs();
		System.out.println(min==Integer.MAX_VALUE ? -1 : min);
	}
	static int[] dy= {-1,0,1,0}, dx= {0,1,0,-1};
	private static void bfs() {
		Queue<int[]> q = new LinkedList<int[]>();
		q.offer(new int[] {B[0], B[1], R[0], R[1]});
		
		int temp[], qSize, nby, nbx, nrx, nry, count=0, result=0;
		while(!q.isEmpty()) {
			qSize = q.size();
			count++;
			if(count>10) break;
			for(int i=0; i<qSize; i++) {
				temp = q.poll();
				for(int d=0; d<4; d++) {
					nby = temp[0];
					nbx = temp[1];
					nry = temp[2];
					nrx = temp[3];
					boolean blueStop=false, redStop=false;
					int blueTime=0, redTime=0;
					while(!(blueStop&&redStop)) {
						if(!blueStop) {
							nby += dy[d];
							nbx += dx[d];
							blueTime++;
						}
						if(!redStop) {
							nry += dy[d];
							nrx += dx[d];
							redTime++;
						}
						if(map[nby][nbx]=='#' || map[nby][nbx]=='O') {
							blueStop=true;
							nby-=dy[d];
							nbx-=dx[d];
						}
						if(map[nry][nrx]=='#' || map[nry][nrx]=='O') {
							redStop=true; 
							nry-=dy[d];
							nrx-=dx[d];
						}
					}
					if(map[nby+dy[d]][nbx+dx[d]]=='O') {
						//실패
						continue;
					}
					else if(map[nry+dy[d]][nrx+dx[d]]=='O'){
						//성공
						min = Math.min(min, count);
						continue;
					}
					if(nby==nry && nbx==nrx) {	
						//같은 곳인경우
						if(redTime>blueTime) {
							nry-=dy[d];
							nrx-=dx[d];
						}else {
							nby-=dy[d];
							nbx-=dx[d];
						}
					}
					if(visited[nby][nbx][nry][nrx]) continue;
					q.offer(new int[] {nby, nbx, nry, nrx});
					visited[nby][nbx][nry][nrx]=true;
				}
			}
		}
	}
}