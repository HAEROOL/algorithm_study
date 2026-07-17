import java.util.*;

class Solution {
    static boolean[] v;
    static int total;
    static String[][] tickets;
    static String[] answer;
    static void dfs(int now, int used, List<String> log){
        if(answer != null) return;
        if(used == total){
            answer = new String[log.size()];
            for(int i = 0 ; i < log.size() ; i++){
                answer[i] = log.get(i);
            }
            return;
        }
        
        for(int i = 0 ; i < tickets.length ; i++){
            if(i == now) continue;
            if(v[i]) continue;
            if(!tickets[now][1].equals(tickets[i][0])) continue;
            v[i] = true;
            log.add(tickets[i][1]);
            dfs(i, used + 1, log);
            v[i] = false;    
            log.remove(log.size() - 1);
        }
    }
    public String[] solution(String[][] tickets) {
        this.tickets = tickets;
        v = new boolean[tickets.length];
        total = tickets.length;
        
        Arrays.sort(tickets, (a, b) -> {
            if(a[0].equals(b[0])){
                return a[1].compareTo(b[1]);
            }
            return a[0].compareTo(b[0]);
        });
        
        for(int i = 0 ; i < tickets.length ; i++){
            if(!tickets[i][0].equals("ICN")) continue;
            v = new boolean[tickets.length];
            v[i] = true;
            List<String> log = new ArrayList<>();
            log.add(tickets[i][0]);
            log.add(tickets[i][1]);
            dfs(i, 1, log);
        }
        return answer;
    }
}