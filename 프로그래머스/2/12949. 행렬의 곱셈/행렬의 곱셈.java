class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        //answer = arr1의 행크기 * arr2 행의 열크기
        int[][] answer = new int[arr1.length][arr2[0].length];
        
        int row1, row2, col2;
            
        for(row1 = 0; row1 < arr1.length; row1++){
            for(col2 = 0; col2 < arr2[0].length; col2++){
                int sum = 0;
                
                for(row2 = 0; row2 < arr2.length; row2++){
                    sum += arr1[row1][row2] * arr2[row2][col2];
                }
                answer[row1][col2] = sum;
            }
        }
        return answer;
    }

}