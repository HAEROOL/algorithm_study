class Solution {
    static int parseTime(String str){
        String[] tmp = str.split(":");
        int hour = Integer.parseInt(tmp[0]) * 60;
        int minute = Integer.parseInt(tmp[1]);
        return hour + minute;
    }
    public int solution(String[][] book_time) {
        int answer = 0;
        int[] rooms = new int[60 * 24 + 10];
        
        for(String[] time : book_time){
            int startTime = parseTime(time[0]);
            int endTime = parseTime(time[1]);
            for(int i = startTime ; i < endTime + 10 ; i++){
                rooms[i]++;
            }
        }
        
        for(int i : rooms){
            answer = Math.max(answer, i);
        }
        return answer;
    }
}