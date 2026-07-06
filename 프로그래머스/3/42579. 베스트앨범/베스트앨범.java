import java.util.*;

class Solution {
    class Song{
        int id;
        int play;
        
        public Song(int id, int play){
            this.id = id;
            this.play = play;
        }
    }
    
    class Genre{
        List<Song> songs;
        String genre;
        int total;
        public Genre(String genre){
            songs = new ArrayList<>();
            this.genre = genre;
            this.total = 0;
        }
        
        public void add(int id, int play){
            songs.add(new Song(id, play));
            total += play;
        }
    }
    public int[] solution(String[] genres, int[] plays) {
        int[] answer = {};
        int id = 0;
        Map<String, Genre> map = new HashMap<>();
        for(int i = 0 ; i < genres.length ; i++){
            map.putIfAbsent(genres[i], new Genre(genres[i]));
            map.get(genres[i]).add(id++, plays[i]);
        }
        
        for(String key : map.keySet()){
            map.get(key).songs.sort((a, b) -> {
                if(b.play == a.play){
                    return a.id - b.id;
                }
                return b.play - a.play;
            });
        }
        
        List<String> keys = new ArrayList<>(map.keySet());    
        keys.sort((a, b) ->{
            return map.get(b).total - map.get(a).total;
        });
        List<Integer> ans = new ArrayList<>();
        for(String key : keys){
            // for(Song s : map.get(key).songs){
            //     System.out.println(s.id + " " + s.play);
            // }
            // System.out.println(map.get(key).total);
            ans.add(map.get(key).songs.get(0).id);
            if(map.get(key).songs.size() > 1){
                ans.add(map.get(key).songs.get(1).id);
            }
        }
        answer = new int[ans.size()];
        for(int i = 0 ; i < ans.size() ; i++){
            answer[i] = ans.get(i);
        }
        return answer;
    }
}