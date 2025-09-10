import java.util.*;

class Solution {
    public int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        int[] counts = new int[N + 2]; // 1~N+1 까지 저장용 (편의상)
        
        // 각 스테이지별 도전자 수 카운트
        for (int s : stages) {
            counts[s]++;
        }

        double[][] res = new double[N][2];
        int total = stages.length; // 현재까지 도전한 사람 수

        for (int i = 1; i <= N; i++) {
            double failRate = 0.0;
            if (total > 0) {
                failRate = (double) counts[i] / total;
            }
            res[i - 1][0] = i; // 스테이지 번호
            res[i - 1][1] = failRate; // 실패율
            total -= counts[i]; // i스테이지에 머무른 사람 제외
        }

        // 실패율 기준 정렬
        Arrays.sort(res, (a, b) -> {
            if (a[1] == b[1]) {
                return Double.compare(a[0], b[0]); // 스테이지 번호 오름차순
            }
            return Double.compare(b[1], a[1]); // 실패율 내림차순
        });

        for (int i = 0; i < N; i++) {
            answer[i] = (int) res[i][0];
        }
        
        return answer;
    }
}