import java.util.Scanner;

public class Plus3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        int a, b, result;
        for (int i=1; i<=T; i++) {
            a = sc.nextInt();
            b = sc.nextInt();
            result = a+b;
            System.out.println("Case #" + i + ": "+ a + " + " + b + " = " + result);
        }
        sc.close();
    }
}