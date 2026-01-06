import java.util.*;

class Solution {
    public int solution(int[][] land) {
        int answer = 0;
        int N = land.length;
        int M = land[0].length;
        Map<Integer, Integer> map = new HashMap<>();
        int[][] v = new int[N][M];
        int id = 1;
        int[] dx = new int[]{0, 1, 0, -1};
        int[] dy = new int[]{1, 0, -1, 0};
        for(int i = 0 ; i < N ; i++){
            for(int j = 0 ; j < M ; j++){
                if(land[i][j] == 1 && v[i][j] == 0){
                    Deque<int[]> q = new ArrayDeque<>();
                    q.offer(new int[]{i, j});
                    int oid = id++;
                    v[i][j] = oid;
                    int size = 1;
                    while(!q.isEmpty()){
                        int[] now = q.poll();
                        
                        for(int k = 0 ; k < 4 ; k++){
                            int nx = now[0] + dx[k];
                            int ny = now[1] + dy[k];
                            
                            if(0 <= nx && nx < N && 0 <= ny && ny < M && v[nx][ny] == 0 && land[nx][ny] == 1){
                                q.offer(new int[]{nx, ny});
                                v[nx][ny] = oid;
                                size++;
                            }
                        }
                    }
                    map.put(oid, size);
                }
            }
        }
        //for(int[] row : v) System.out.println(Arrays.toString(row));
        //for(int key : map.keySet()) System.out.println(key + ": " + map.get(key));
        for(int i = 0 ; i < M ; i++){
            Set<Integer> oset = new HashSet<>();
            for(int j = 0 ; j < N ; j++){
                if(land[j][i] == 1){
                    oset.add(v[j][i]);
                }
            }
            int total = 0;
            for(int e : oset){
                total += map.get(e);
            }
            answer = Math.max(answer, total);
        }
        
        return answer;
    }
}