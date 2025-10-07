import java.util.*;

class Solution {
    public int solution(String[] friends, String[] gifts) {
        int answer = 0;
        Map<String, Map<String,Integer>> map = new HashMap<>();
        Map<String, Integer> ratioMap = new HashMap<>();
        Map<String, Integer> answerMap = new HashMap<>();
        for(String f : friends){
            Map<String, Integer> fmap = new HashMap<>();
            for(int i = 0 ; i < friends.length ; i++){
                if(!friends[i].equals(f)){
                    fmap.put(friends[i], 0);
                }
            }
            map.put(f, fmap);
            ratioMap.put(f, 0);
            answerMap.put(f, 0);
        }
        
        for(String g : gifts){
            String[] tmp = g.split(" ");
            String giver = tmp[0];
            String reciever = tmp[1];
            
            Map<String, Integer> giftMap = map.get(giver);
            if(giftMap.get(reciever) != null){
                giftMap.replace(reciever, giftMap.get(reciever) + 1);
            }else{
                giftMap.put(reciever, 1);
            }
        }
        
        for(String giver : map.keySet()){
            int giveCnt = 0;
            int recieveCnt = 0;
            for(String reciever : map.get(giver).keySet()){
                giveCnt += map.get(giver).get(reciever);
                if(map.get(reciever).get(giver) != null){
                    recieveCnt += map.get(reciever).get(giver);
                }
            }
            ratioMap.replace(giver, giveCnt - recieveCnt);
        }
        
        for(int i = 0 ; i < friends.length ; i++){
            for(int j = i + 1 ; j < friends.length ; j++){
                String A = friends[i];
                String B = friends[j];
                int Acnt = map.get(A).get(B);
                int Bcnt = map.get(B).get(A);
                
                if(Acnt > Bcnt){
                    answerMap.replace(A, answerMap.get(A) + 1);
                }else if(Bcnt > Acnt){
                    answerMap.replace(B, answerMap.get(B) + 1);
                }else{
                    int Aratio = ratioMap.get(A);
                    int Bratio = ratioMap.get(B);
                    if(Aratio > Bratio){
                        answerMap.replace(A, answerMap.get(A) + 1);
                    }else if(Bratio > Aratio){
                        answerMap.replace(B, answerMap.get(B) + 1);
                    }
                }
            }
        }
        for(String name : answerMap.keySet()){
            if(answer < answerMap.get(name)){
                answer = answerMap.get(name);
            }
        }
        return answer;
    }
}