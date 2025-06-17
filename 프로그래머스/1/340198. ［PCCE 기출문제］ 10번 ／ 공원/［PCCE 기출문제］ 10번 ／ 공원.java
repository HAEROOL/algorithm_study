import java.io.*;
import java.util.*;

class Solution {
    public int solution(int[] mats, String[][] park) {
        int answer = -1;

        Arrays.sort(mats);

        for(int k = mats.length-1; k >= 0; k--) {
            int n = mats[k];

            for(int i = 0; i <= park.length - n; i++) {
               for(int j = 0; j <= park[0].length - n; j++) {

                   boolean flag = false;

                   label: for(int l = i; l < i + n; l++) {
                       for(int m = j; m < j + n; m++) {
                           if (!park[l][m].equals("-1")) {

                               flag = true;
                               break label;
                            }
                       }
                   }

                   if(!flag) {
                       answer = n;
                       return answer;
                   }
               }
            }

        }

        return answer;
    }
}