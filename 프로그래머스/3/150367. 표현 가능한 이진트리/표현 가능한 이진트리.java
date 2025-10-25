class Solution {
    static String getFullBinary(String binary){
        int len = binary.length();
        
        int height = 1;
        int node = 1;
        while(node < len){
            height *= 2;
            node += height;
        }
        for(int i = 0 ; i < node - len ; i++){
            binary = "0" + binary;
        }
        return binary;
    }
    static boolean isBinaryTree(String bin){
        int len = bin.length();
        
        if(len == 0) return true;
        
        int root = len / 2;
        
        if(bin.charAt(root) == '0'){
            return isZero(bin.substring(0, root)) && isZero(bin.substring(root + 1));
        }
        
        return isBinaryTree(bin.substring(0, root)) && isBinaryTree(bin.substring(root + 1));
    }
    static boolean isZero(String bin){
        int len = bin.length();
        
        if(len == 0) return true;
        int root = len / 2;
        if(bin.charAt(root) == '1') return false;
        return isZero(bin.substring(0, root)) && isZero(bin.substring(root + 1));
    }
    public int[] solution(long[] numbers) {
        int[] answer = new int[numbers.length];
        for(int i = 0 ; i <  numbers.length ; i++){
            String binary = Long.toBinaryString(numbers[i]);
            
            String fullBinary = getFullBinary(binary);
            
            // System.out.println(fullBinary);
            
            if(isBinaryTree(fullBinary)){
                answer[i] = 1;
            }else{
                answer[i] = 0;
            }
        }
        return answer;
    }
}