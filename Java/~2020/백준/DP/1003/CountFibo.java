/*
문제

N이 주어졌을 때, fibonacci(N)을 호출했을 때, 0과 1이 각각 몇 번 출력되는지 구하는 프로그램을 작성하시오.

입력

첫째 줄에 테스트 케이스의 개수 T가 주어진다.
각 테스트 케이스는 한 줄로 이루어져 있고, N이 주어진다. N은 40보다 작거나 같은 자연수 또는 0이다.

출력

각 테스트 케이스마다 0이 출력되는 횟수와 1이 출력되는 횟수를 공백으로 구분해서 출력한다.
*/
import java.util.Scanner;

public class CountFibo {
    public static void main(String[] args) {
        int[] callZero = new int[41];
        int[] callOne = new int[41];
        callZero[0] = 1;
        callOne[0] = 0;
        callZero[1] = 0;
        callOne[1] = 1;
        for (int i=2; i<=40; i++){
            callZero[i] = callZero[i-2] + callZero[i-1];
            callOne[i] = callOne[i-2] + callOne[i-1];
        }
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while(T-- != 0){
            int n = sc.nextInt();
            System.out.println(callZero[n] + " " + callOne[n]);
        }
        sc.close();
    }
}