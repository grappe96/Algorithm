/*
문제

45656이란 수를 보자.
이 수는 인접한 모든 자리수의 차이가 1이 난다. 이런 수를 계단 수라고 한다.
세준이는 수의 길이가 N인 계단 수가 몇 개 있는지 궁금해졌다.
N이 주어질 때, 길이가 N인 계단 수가 총 몇 개 있는지 구하는 프로그램을 작성하시오. (0으로 시작하는 수는 없다.)

입력

첫째 줄에 N이 주어진다. N은 1보다 크거나 같고, 100보다 작거나 같은 자연수이다.

출력

첫째 줄에 정답을 1,000,000,000으로 나눈 나머지를 출력한다.
*/

import java.util.*;

public class NumberStair {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[][] num = new int[9][N];
        int answer=0;
        sc.close();

        for (int i=0; i<9; i++)
            num[i][0] = 1;
        for (int i=1; i<N; i++){
            if (i == 1)
                num[0][i] = (num[0][i] + 1 + num[1][i-1]) % 1000000000;
            else
                num[0][i] = (num[0][i] + num[0][i-2] + num[1][i-1]) % 1000000000;
            for (int j=1; j<8; j++)
                num[j][i] = (num[j][i] + num[j-1][i-1] + num[j+1][i-1]) % 1000000000;
            num[8][i] = (num[8][i] + num[7][i-1]) % 1000000000;
        }
        for (int i=0; i<9; i++)
            answer = (answer + num[i][N-1]) % 1000000000;
        System.out.println(answer%1000000000);
    }
}