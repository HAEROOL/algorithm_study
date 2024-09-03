import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    private static int N, M;
    private static int[] dy = {-1, 0, 0, 1};
    private static int[] dx = {0, -1, 1, 0};

    static int[][] map;
    static Dest[] dest;
    private static int sty, stx;
    private static int guest, gas;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        gas = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        dest = new Dest[M + 2]; 

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        st = new StringTokenizer(br.readLine());

        sty = Integer.parseInt(st.nextToken())-1;
        stx = Integer.parseInt(st.nextToken())-1;


        for (int i = 2; i <= M + 1; i++) {
            st = new StringTokenizer(br.readLine());
            map[Integer.parseInt(st.nextToken())-1][Integer.parseInt(st.nextToken())-1] = i;
            dest[i] = new Dest(Integer.parseInt(st.nextToken())-1, Integer.parseInt(st.nextToken())-1);
        }

        
        int cnt = 0;


        while (true) {
            boolean isTake = (findGuest(sty, stx, gas));
            int gas1 = gas; 
            if (isTake) {
                boolean isArrive = findDest(new Node(sty, stx, gas, guest));// 손님을 도착지까지 데려다주고 남은 연료량
                if (isArrive) {
                    gas += (gas1 - gas) * 2;
                    cnt++;
                    if (cnt == M) {
                        System.out.println(gas);
                        return;
                    }

                } else { // 손님을 태우고 도착하지 못한경우
                    System.out.println(-1);
                    return;
                }
            } else {   // 손님을 태우지 못한경우
                System.out.println(-1);
                return;
            }
        }


    }


    private static boolean findGuest(int y, int x, int restGas) {
        Queue<Node> q = new LinkedList<>();
        PriorityQueue<Node> pq = new PriorityQueue<>();

        q.add(new Node(y, x, restGas, map[y][x]));
        boolean[][] visited = new boolean[N][N];
        visited[y][x] = true;

        while (!q.isEmpty()) {
            Node node = q.poll();
            if (map[node.y][node.x] > 1) {
                pq.add(new Node(node.y, node.x, node.gas, map[node.y][node.x]));
            }
            for (int i = 0; i < 4; i++) {
                int ny = node.y + dy[i];
                int nx = node.x + dx[i];
                if (ny < 0 || nx < 0 || ny >= N || nx >= N || visited[ny][nx] || map[ny][nx] == 1 || node.gas == 0) {
                    continue;
                }
                visited[ny][nx] = true;
                q.add(new Node(ny, nx, node.gas - 1, map[ny][nx] > 1 ? map[ny][nx] : 0));
            }
        }
        if (!pq.isEmpty()) {
            Node guestP = pq.poll();
            sty = guestP.y;
            stx = guestP.x;
            gas = guestP.gas;
            guest = map[sty][stx];
            map[sty][stx] = 0;  // 손님을 태움
            return true;
        }
        return false;
    }

    private static boolean findDest(Node fg) {
        Queue<Node> q = new LinkedList<>();
        q.add(fg);

        boolean[][] visited = new boolean[N][N];
        visited[fg.y][fg.x] = true;

        while (!q.isEmpty()) {
            Node node = q.poll();

            if (node.y == dest[guest].y && node.x == dest[guest].x) {
                sty= node.y;
                stx = node.x;
                gas = node.gas;
                guest = 0;
                return true;
            }

            for (int i = 0; i < 4; i++) {
                int ny = node.y + dy[i];
                int nx = node.x + dx[i];
                if (ny < 0 || nx < 0 || ny >= N || nx >= N || visited[ny][nx] || map[ny][nx] == 1 || node.gas == 0) {
                    continue;
                }
                visited[ny][nx] = true;

                q.add(new Node(ny, nx, node.gas - 1, node.guest));
            }
        }
        return false;
    }




    private static class Node implements Comparable<Node> {
        int y;
        int x;
        int gas;
        int guest;

        public Node(int y, int x, int gas, int guest) {
            this.y = y;
            this.x = x;
            this.gas = gas;
            this.guest = guest;
        }

        @Override
        public int compareTo(Node o) {
            if (o.gas != this.gas) {
                return o.gas - this.gas;
            } else if (o.y != this.y) {
                return this.y - o.y;
            } else return this.x - o.x;
        }
    }

    private static class Dest {
        int y ;
        int x;

        public Dest(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
}