import java.util.Scanner;
import java.math.BigInteger;
 
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // 정수 n 입력
        int n = sc.nextInt();
        
        // 입력된 정수에 해당하는 피보나치 수 계산
        BigInteger fibN = fibonacci(n);
        
        // 계산된 피보나치 수 출력
        System.out.println(fibN);
    }
    private static BigInteger fibonacci(int n) {
        if (n == 1 || n == 2) {
            return BigInteger.ONE;
        }

        BigInteger a = BigInteger.ONE; // 첫 번째 항
        BigInteger b = BigInteger.ONE; // 두 번째 항
        BigInteger c = BigInteger.ZERO; // 세 번째 항
        
        for (int i = 3; i <= n; i++) {
            c = a.add(b);
            a = b;
            b = c;
        }
        
        return c;
    }
}