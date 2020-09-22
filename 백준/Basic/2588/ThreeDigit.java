import java.util.Scanner;

public class ThreeDigit {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int first = sc.nextInt();
        String second = sc.next();
        int one, two, three, result;
        sc.close();
        one = first*(second.charAt(2)-'0');
        System.out.println(one);
        two = first*(second.charAt(1)-'0');
        System.out.println(two);
        three = first*(second.charAt(0)-'0');
        System.out.println(three);
        result = one + two*10 + three*100;
        System.out.println(result);
    }
}