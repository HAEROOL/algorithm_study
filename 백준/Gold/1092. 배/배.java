import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        List<Integer> arr = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < N ; i++){
            arr.add(Integer.parseInt(st.nextToken()));
        }
        int M = Integer.parseInt(br.readLine());
        boolean[] v = new boolean[M];
        st = new StringTokenizer(br.readLine());
        List<Integer> boxes = new ArrayList<>();
        for(int i = 0 ; i < M ; i++){
            boxes.add(Integer.parseInt(st.nextToken()));
        }
        arr.sort(Collections.reverseOrder());
        boxes.sort(Collections.reverseOrder());
        int time = 0;
        if(arr.get(0) < boxes.get(0)){
            bw.write(-1 + "");
            bw.close();
            return;
        }
        while(!boxes.isEmpty()){
            int idx = 0, cidx = 0;
            while(cidx < N){
                if(idx == boxes.size())break;
                else if(arr.get(cidx) >= boxes.get(idx)){
                    boxes.remove(idx);
                    cidx++;
                }else{
                    idx++;
                }
            }
            time++;
        }
        bw.write(time+"");
        bw.close();
    }
}

