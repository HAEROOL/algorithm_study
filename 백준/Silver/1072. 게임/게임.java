import java.awt.*;
import java.io.*;
import java.util.*;

public class Main {



    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        long X, Y;

        StringTokenizer st = new StringTokenizer(br.readLine());

        X = Long.parseLong(st.nextToken());
        Y = Long.parseLong(st.nextToken());

        long Z;

        if (X == Y) {
            bw.write("-1");
        } else{

            Z = 100 * Y / X;

            if (Z == 99) {
                bw.write("-1");
            } else {
                long one = (X * Z + X - 100 * Y);
                long two = 99 - Z;
                long mid = one / two;

                if (one % two == 0) {
                    bw.write(String.valueOf(mid));
                } else {
                    bw.write(String.valueOf(mid + 1));
                }
            }
        }


        bw.flush();

    }




}