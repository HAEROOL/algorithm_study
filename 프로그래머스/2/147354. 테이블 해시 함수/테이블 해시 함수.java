import java.util.*;

class Solution {
    public int solution(int[][] data, int col, int row_begin, int row_end) {
        int answer = 0;
        Arrays.sort(data, (a, b) -> {
            if(a[col - 1] == b[col - 1]){
                return b[0] - a[0];
            }
            return a[col - 1] - b[col - 1];
        });
        
        int totalS_i = 0;
        // for(int[] row : data){
        //     System.out.println(Arrays.toString(row));    
        // }
        
        for(int i = row_begin ; i <= row_end ; i++){
            int S_i = 0;
            for(int a : data[i - 1]){
                // System.out.println(a + " mod " + i);
                S_i += a % i;
            }
            // System.out.println(S_i);
            totalS_i ^= S_i;
        }
        
        return totalS_i;
    }
}