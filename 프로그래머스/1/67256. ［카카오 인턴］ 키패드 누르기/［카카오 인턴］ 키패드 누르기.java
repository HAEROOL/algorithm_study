class Solution {
    public String solution(int[] numbers, String hand) {
        String answer = "";
        int[] r = new int[]{3, 2};
        int[] l = new int[]{3, 0};
        for(int i = 0 ; i < numbers.length ; i++){
            if(numbers[i] == 1 || numbers[i] == 4 || numbers[i] == 7){
                answer += "L";
                l = new int[]{numbers[i]/3 , 0};
            }else if(numbers[i] == 3 || numbers[i] == 6 || numbers[i] == 9){
                r = new int[]{numbers[i]/3 - 1 , 2};
                answer += "R";
            }else{
                int tx = numbers[i] == 0? 3 : numbers[i] / 3;
                int ty = 1;
                int rd = Math.abs(tx - r[0]) + Math.abs(ty - r[1]);
                int ld = Math.abs(tx - l[0]) + Math.abs(ty - l[1]);
                if(rd > ld){
                    answer += "L";
                    l = new int[]{tx, ty};
                }else if(rd < ld){
                    answer += "R";
                    r = new int[]{tx, ty};
                }else{
                    if(hand.equals("right")){
                        answer += "R";
                        r = new int[]{tx, ty};
                    }else{
                        answer += "L";
                        l = new int[]{tx, ty};
                    }
                }
            }
        }
        return answer;
    }
}