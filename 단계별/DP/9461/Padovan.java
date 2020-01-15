/*
문제

삼각형이 나선 모양으로 놓여져 있다. 
첫 삼각형은 정삼각형으로 변의 길이는 1이다. 
그 다음에는 다음과 같은 과정으로 정삼각형을 계속 추가한다. 
나선에서 가장 긴 변의 길이를 k라 했을 때, 그 변에 길이가 k인 정삼각형을 추가한다.
파도반 수열 P(N)은 나선에 있는 정삼각형의 변의 길이이다. 
P(1)부터 P(10)까지 첫 10개 숫자는 1, 1, 1, 2, 2, 3, 4, 5, 7, 9이다.
N이 주어졌을 때, P(N)을 구하는 프로그램을 작성하시오.

입력

첫째 줄에 테스트 케이스의 개수 T가 주어진다. 각 테스트 케이스는 한 줄로 이루어져 있고, N이 주어진다. (1 ≤ N ≤ 100)

출력

각 테스트 케이스마다 P(N)을 출력한다.
*/

import java.util.Scanner;

public class Padovan {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        int num;
        long[] P = new long[100];
        P[0] = P[1] = P[2] = 1;
        P[3] = P[4] = 2;
        for (int i=5; i<100; i++)
            P[i] = P[i-5] + P[i-1];
        for (int i=0; i<T; i++) {
            num = sc.nextInt();
            System.out.println(P[num-1]);
        }
        sc.close();
    }
}