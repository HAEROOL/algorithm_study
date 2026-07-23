import java.util.*;
class Solution {
    public int[][] solution(int[][] rc, String[] operations) {
        int[][] answer = new int[rc.length][rc[0].length];
        Deque<Integer> left = new ArrayDeque<Integer>();
        Deque<ArrayDeque<Integer>> center = new ArrayDeque<ArrayDeque<Integer>>();
        Deque<Integer> right = new ArrayDeque<Integer>();
        
        for(int i = 0 ; i < rc.length ; i++){
            left.offer(rc[i][0]);
            right.offer(rc[i][rc[0].length - 1]);
            ArrayDeque<Integer> dq = new ArrayDeque<>();
            for(int j = 1 ; j < rc[i].length - 1 ; j++) dq.offer(rc[i][j]);
            center.offer(dq);
        } 
        for(String op : operations){
            if(op.equals("Rotate")){
                center.peek().offerFirst(left.poll());
                right.offerFirst(center.peek().pollLast());
                center.peekLast().offer(right.pollLast());
                left.offer(center.peekLast().poll());

            }else{
                left.offerFirst(left.pollLast());
                center.offerFirst(center.pollLast());
                right.offerFirst(right.pollLast());
            }
        }
        //         System.out.println(left);
        // System.out.println(center);
        // System.out.println(right);
        for(int i = 0 ; i < rc.length ; i++){
            answer[i][0] = left.poll();  
            answer[i][rc[0].length - 1] = right.poll();
            Deque<Integer> crow = center.poll();
            for(int j = 1 ; j < rc[i].length - 1 ; j++) answer[i][j] = crow.poll();
            // for(int[] row : answer){
            //     System.out.println(Arrays.toString(row));
            // }
            // System.out.println("------------------");
        }
        return answer;
    }
}