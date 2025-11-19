import java.util.*;

class Solution {
    static int parseTime(String time){
        String[] tokens = time.split(":");
        return Integer.parseInt(tokens[0]) * 60 + Integer.parseInt(tokens[1]); 
    }
    
    static class Job{
        int startTime, playTime, age;
        String name;
        public Job(String name, String startTime, String playTime){
            this.name = name;
            this.age = 0;
            this.startTime = parseTime(startTime);
            this.playTime = Integer.parseInt(playTime);
        }
    }
    
    public String[] solution(String[][] plans) {
        List<String> answer = new ArrayList<>();
        
        Job[] jobs = new Job[plans.length];
        for(int i = 0; i < jobs.length; i++){
            jobs[i] = new Job(plans[i][0], plans[i][1], plans[i][2]);
        }
        
        // 시작 시간 순으로 정렬
        Arrays.sort(jobs, (a, b) -> a.startTime - b.startTime);
        
        Job current = null;
        Deque<Job> stopq = new ArrayDeque<>();
        int idx = 0;
        int time = jobs[0].startTime;
        
        while(answer.size() < jobs.length){
            // 1. 현재 시간에 시작해야 하는 과제 확인
            if(idx < jobs.length && jobs[idx].startTime == time){
                if(current != null){
                    stopq.push(current); // 진행 중이던 과제 멈춤
                }
                current = jobs[idx++];
            }
            
            // 2. 현재 과제 1분 진행
            if(current != null){
                current.age++;
                if(current.age == current.playTime){
                    answer.add(current.name);
                    current = null;
                    
                    // 3. 끝났으면 멈춘 과제 재개
                    if(!stopq.isEmpty()){
                        current = stopq.pop();
                    }
                }
            }
            
            time++;
        }
        
        return answer.toArray(new String[0]);
    }
}