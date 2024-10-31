import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException{
        String input[] = br.readLine().split("");
        for(int i = 0 ; i < input.length - 1 ; i++){
            bw.write(input[i]+"");
            if(input[i].equals("(") && input[i + 1].equals(")")){
                bw.write(1+"");
            }else if(input[i].equals(")") && input[i + 1].equals("(")){
                bw.write("+");
            }
        }
            bw.write(input[input.length-1]+"");
        bw.close();
    }
}
