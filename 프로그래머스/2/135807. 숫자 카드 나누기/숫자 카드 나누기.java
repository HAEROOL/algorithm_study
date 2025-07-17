class Solution {
    static int getGcd(int[] arr){
        int result = arr[0];
        for(int i = 1 ; i < arr.length ; i++){
            result = gcd(result, arr[i]);
        }
        return result;
    }
    static int gcd(int a, int b){
        if(b== 0) return a;
        return gcd(b, a % b);
    }
    public int solution(int[] arrayA, int[] arrayB) {
        int answer = 0;
        int a = getGcd(arrayA);
        int b = getGcd(arrayB);
        boolean aFlag = true;
        boolean bFlag = true;
        
        for(int i  : arrayB){
            if(i % a == 0){
                aFlag = false;
                break;
            }
        }
        for(int i  : arrayA){
            if(i % b == 0){
                bFlag = false;
                break;
            }
        }
        if(aFlag && bFlag) answer = Math.max(a, b);
        else if(aFlag) answer = a;
        else if(bFlag) answer = b;
        else answer = 0;
        return answer;
    }
            
    
}