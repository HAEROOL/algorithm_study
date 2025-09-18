import java.util.*;

class Solution {
    static String REGEX = "[0-9]+";

    static String[] parseString(String file){
        String[] str = file.split("");
        String[] res = new String[3];
        Arrays.fill(res, "");
        String token = "";
        int i = 0;
        for(String s : str){
            if(i == 0){
                if(s.matches(REGEX)){
                    res[i] = token;
                    token = s;
                    i++;
                }else{
                    token += s;    
                }
            }else if(i == 1){
                if(!s.matches(REGEX)){
                    res[i] = token;
                    token = s;
                    i++;
                }else{
                    token += s;
                }
            }else{
                token += s;
            }
        }
        res[i] = token;
        return res;
    }
    static class File{
        String name;
        String orderName;
        String tail;
        int id;
        String number;
        File(String name, int id, String number, String tail){
            this.name = name;
            this.orderName = name.toLowerCase();
            this.id = id;
            this.number = number;
            this.tail = tail;
        }
    }
    public String[] solution(String[] files) {
        String[] answer = {};
        PriorityQueue<File> q = new PriorityQueue<>((a, b) -> {
            if(a.orderName.equals(b.orderName)){
                if(Integer.parseInt(a.number) == Integer.parseInt(b.number)){
                    return a.id - b.id;
                }
                return Integer.parseInt(a.number) - Integer.parseInt(b.number);
            }
            return a.orderName.compareTo(b.orderName);
        });
        int id = 0;
        for(String file : files){
            String[] res = parseString(file);
            String head = res[0];
            String number = res[1];
            String tail =  res[2];
            // System.out.println(head + " " + number + " " + tail);
            q.offer(new File(head, id++, number, tail));
        }
        answer = new String[q.size()];
        int idx = 0;
        while(!q.isEmpty()){
            File f = q.poll();
            String r = f.name + f.number + f.tail;
            answer[idx++] = r;
        }
        return answer;
    }
}