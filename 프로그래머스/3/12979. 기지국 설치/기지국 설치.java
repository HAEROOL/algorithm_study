class Solution {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;
        
        int position=1;
        int station=0;
        while(position<=n){
           //기존 기지국 만난 경우
           if(station<stations.length&&position>=stations[station]-w){
           //기지국 끝+1으로 이동
                position=stations[station]+w+1;
                station++;
            }
            //기지국 설치 후 2w+1만큼 이동
            else{
                answer+=1;
                position+=(2*w+1);
                
            }
        }
        return answer;
    }
}