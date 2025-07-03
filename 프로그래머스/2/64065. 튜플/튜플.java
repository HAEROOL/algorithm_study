import java.util.*;

class Solution {
    public int[] solution(String s) {
        String[] arr = s.substring(2, s.length() - 2).split("\\}\\,\\{");
        List<String[]> list = new ArrayList<>();
        for(String e : arr){
            list.add(e.split(","));
        }
        Collections.sort(list, (a, b) -> a.length - b.length);
        int[] answer = new int[list.size()];
        for(int i = 0 ; i < answer.length ; i++){
            String[] tmp = list.get(i);
            for(int j = 0 ; j < list.get(i).length ; j++){
                String a = list.get(i)[j];
                boolean isContain = false;
                for(int k = 0 ; k < i ; k++){
                    if(answer[k] == Integer.parseInt(a)){
                        isContain = true;
                        break;
                    }
                }
                if(!isContain){
                    answer[i] = Integer.parseInt(a);
                    break;
                }
            }
        }
        
        return answer;
    }
}