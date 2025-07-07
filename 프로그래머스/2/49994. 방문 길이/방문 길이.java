import java.util.*;

class Solution {
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static String[] dc = {"U", "R", "D", "L"};
    public int solution(String dirs) {
        int answer = 0;
        String[] cmds = dirs.split("");
        Set<String> set = new HashSet<>();
        int x = 0;
        int y = 0;
        for(String cmd : cmds){
            for(int i = 0 ; i < 4 ; i++){
                if(cmd.equals(dc[i])){
                    int nx = x + dx[i];
                    int ny = y + dy[i];
                    if(-5 <= nx && nx <= 5 && -5 <= ny && ny <= 5){
                        if(!set.contains(x+""+y+dc[i]+nx+""+ny) && !set.contains(nx+""+ny+dc[(i + 2)%4]+x+""+y)){
                            set.add(x+""+y+dc[i]+nx+""+ny);
                            set.add(nx+""+ny+dc[(i + 2)%4]+x+""+y);
                            // System.out.println(x+""+y+dc[i]+nx+""+ny);
                            answer++;
                        }
                        x = nx;
                        y = ny;
                    }
                }
            }
        }
        return answer;
    }
}