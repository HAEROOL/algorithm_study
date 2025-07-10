class Solution {
    static int[] recursive(int w, int sx, int sy){
        if(w == 2){
            // System.out.println(sx + ", " +  sy);
            int zeroCnt = 0;
            int oneCnt = 0;
            for(int i = sx ; i < sx + w ; i++){
                for(int j = sy ; j < sy + w ; j++){
                    if(map[i][j] == 1){
                        oneCnt++;
                    }else{
                        zeroCnt++;
                    }
                }
            }
            if(zeroCnt == 0){
                return new int[]{0, 1};    
            }else if(oneCnt == 0){
                return new int[]{1, 0};
            }else{
                return new int[]{zeroCnt, oneCnt};
            }
        }
        
        int[] lt = recursive(w/2, sx, sy);
        int[] rt = recursive(w/2, sx + w/2, sy);
        int[] lb = recursive(w/2, sx, sy + w/2);
        int[] rb = recursive(w/2, sx + w/2, sy + w/2);
        
        int totalZero = lt[0] + rt[0] + lb[0] + rb[0];
        int totalOne = lt[1] + rt[1] + lb[1] + rb[1];
        if(totalZero == 0){
            return new int[]{0, 1};
        }else if(totalOne == 0){
            return new int[]{1, 0};
        }else{
            return new int[]{totalZero, totalOne};
        }
    }
    static int[][] map;
    public int[] solution(int[][] arr) {
        int[] answer = {};
        map = arr;
        answer = recursive(arr.length, 0, 0);
        return answer;
    }
}