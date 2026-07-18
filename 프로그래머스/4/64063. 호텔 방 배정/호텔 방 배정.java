import java.util.*;

class Solution {
    static Map<Long, Long> map;
    static long find(long x){
        if(!map.containsKey(x)){
            map.put(x, x + 1);
            return x;
        }
        
        long emptyRoom = find(map.get(x));
        
        map.put(x, emptyRoom + 1);
        
        return emptyRoom;
        
    }

    public long[] solution(long k, long[] room_number) {
        long[] answer = new long[room_number.length];
        map = new HashMap<>();
        for(int i = 0 ; i < room_number.length ; i++){
            answer[i] = find(room_number[i]);
        }
        return answer;
    }
}