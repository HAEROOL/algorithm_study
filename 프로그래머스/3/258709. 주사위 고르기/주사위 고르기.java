import java.io.*;
import java.util.*;

class Solution {
    static int N;
    static void combination(int idx, int k, int[] sel){
        if(idx == sel.length){
            // System.out.println(Arrays.toString(sel));
            cal(sel);
            return;
        }
        if(k == N) return;
        
        combination(idx, k + 1, sel);
        
        sel[idx] = k;
        combination(idx + 1, k + 1, sel);
    }
    static void cal(int[] sel){
        int[] a = new int[N / 2];
        int[] b = new int[N / 2];
        int ap = 0;
        int bp = 0;
        for(int i = 0 ; i < N ; i++){
            boolean isA = false;
            for(int j = 0 ; j < sel.length ; j++){
                if(sel[j] == i){
                    isA = true;
                    break;
                }
            }
            if(isA) a[ap++] = i;
            else b[bp++] = i;
        }
        // System.out.println(Arrays.toString(a) + " " + Arrays.toString(b));
        List<Integer> acombi = new ArrayList<>();
        List<Integer> bcombi = new ArrayList<>();
        
        getCombi(0, 0, a, acombi);
        getCombi(0, 0, b, bcombi);
        
        int res = simulation(acombi, bcombi);
        if(res > mx){
            Arrays.sort(a);
            mx = res;
            answer = new int[a.length];
            for(int i = 0 ; i < a.length ; i++) answer[i] = a[i] + 1;
        }
    }
    
    static int simulation(List<Integer> acombi, List<Integer> bcombi){
        Collections.sort(bcombi);
        int awincnt = 0;
        for(int e : acombi){
            awincnt += binSearch(e, bcombi);
        }
        // System.out.println(awincnt);
        return awincnt;
    }
    
    static int binSearch(int tgt, List<Integer> arr){
        int st = 0;
        int end = arr.size() - 1;
        int res = arr.size();
        while(st <= end){
            int mid = (st + end) / 2;
            
            if(arr.get(mid) < tgt){
                st = mid + 1;
            }else{
                end = mid - 1;
                res = mid;
            }
        }
        return res;
    }
    
    static void getCombi(int depth, int total, int[] arr, List<Integer> result){
        if(depth == arr.length){
            result.add(total);
            return;
        }
        for(int i = 0 ; i < 6 ; i++){
            getCombi(depth + 1, total + DICE[arr[depth]][i], arr, result);
        }
    }
    static int[][] DICE;
    static int[] answer;
    static int mx = -1;
    public int[] solution(int[][] dice) {
        DICE = dice;
        N = dice.length;
        combination(0, 0, new int[N / 2]);
        return answer;
    }
}