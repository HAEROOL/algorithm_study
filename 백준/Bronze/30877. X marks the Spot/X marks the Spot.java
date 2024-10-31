import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException{
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for(int i = 0 ; i < N ; i++){
            st = new StringTokenizer(br.readLine());
            String[] input1 = st.nextToken().split("");
            String[] input2 = st.nextToken().split("");
            for(int j = 0 ; j < input1.length ; j++){
                if(input1[j].equals("x") || input1[j].equals("X")){
                    bw.write(input2[j].toUpperCase());
                    break;
                }
            }
        }
        bw.close();
    }
}
