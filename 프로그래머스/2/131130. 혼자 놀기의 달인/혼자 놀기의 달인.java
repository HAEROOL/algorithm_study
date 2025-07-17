import java.util.*;

class Solution {
    public int solution(int[] cards) {
        int answer = 0;
        boolean[] v = new boolean[cards.length + 1];
        List<Integer> li = new ArrayList<>();
        for(int i = 0 ; i < cards.length ; i++){
            if(!v[cards[i]]){
                int now = cards[i];
                // System.out.print(now + " ~ ");
                int len = 1;
                v[now] = true;
                while(true){
                    int next = cards[now - 1];
                    if(v[next]) break;
                    // System.out.print(next + " ~ ");
                    len++;
                    now = next;
                    v[next] = true;
                }
                // System.out.println();
                li.add(len);
            }
        }
        if(li.size() == 1) return 0;
        Collections.sort(li);
        System.out.println(li);
        return li.get(li.size() - 1) * li.get(li.size() - 2);
    }
}