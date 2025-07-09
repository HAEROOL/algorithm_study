class Solution {
    public long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];
        for(int i = 0 ; i < numbers.length ; i++){
            long number = numbers[i];
            String bnum = Long.toBinaryString(number);
            // System.out.println(bnum);
            if(bnum.charAt(bnum.length() - 1) == '0'){
                answer[i] = number + 1;
                // System.out.println(answer[i]);
                continue;
            }
            int zeroIdx = -1;
            for(int j = 0 ; j < bnum.length() ; j++){
                if(bnum.charAt(j) == '0'){
                    zeroIdx = j;
                    // break;
                }
            }
            if(zeroIdx == -1){
                String[] tmp = ("1"+bnum).split("");
                tmp[1] = "0";
                // System.out.println(bnum + "/" + Long.parseLong(String.join("", tmp)));
                answer[i] = Long.parseLong(String.join("", tmp), 2);
                continue;
            }
            String[] tmp = bnum.split("");
            tmp[zeroIdx] = "1";
            tmp[zeroIdx + 1] = "0";
            // System.out.println(bnum + "/" + String.join("", tmp));
            answer[i] = Long.parseLong(String.join("", tmp), 2);
        }
        return answer;
    }
}