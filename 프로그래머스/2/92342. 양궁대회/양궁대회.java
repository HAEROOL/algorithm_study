import java.util.*;
class Solution {
    static int mx;
    static int[] ans;
    static int[] INFO;

    static void dfs(int arrow, int depth, int atotal, int btotal, int[] arr){
        if(depth == INFO.length){
            if(atotal < btotal){
                int total = btotal - atotal;
                if(arrow != 0){
                    arr[10] = arrow;
                }
                if(total > mx){
                    System.out.println(Arrays.toString(ans) + " " + arrow);
                    for(int i = 0 ; i < 11 ; i++){
                        ans[i] = arr[i];
                    }
                    mx = total;
                }else if(mx == total){
                    for(int i = 10 ; i > -1 ; i--){
                        if(ans[i] < arr[i]){
                            for(int j = 0 ; j< 11 ; j++){
                                ans[j] = arr[j];
                            }
                            break;
                        }else if(ans[i] > arr[i]){
                            break;
                        }
                    }
                }
            }
            arr[10] = 0;
            return;
        }
        int tmp = atotal;
        if(INFO[depth] != 0){
            tmp += 10 - depth;
        }
        dfs(arrow, depth + 1, tmp, btotal, arr);
        if(INFO[depth] + 1 <= arrow){
            arr[depth] = INFO[depth] + 1;
            dfs(arrow - INFO[depth] - 1, depth + 1, atotal, btotal + 10 - depth, arr);
            arr[depth] = 0;
        }
        
        
    }
    public int[] solution(int n, int[] info) {
        ans = new int[11];
        INFO = info;
        mx = 0;
        int atotal = 0;
        for(int i = 0 ; i < 11 ; i++){
            if(info[i] != 0){
                atotal += 10 - i;
            }
        }
        dfs(n, 0, 0, 0, new int[11]);
        if(mx <= 0) return new int[]{-1};
        System.out.println(Arrays.toString(ans) + " " + mx);
        return ans;
    }
}