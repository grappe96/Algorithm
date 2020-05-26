/*
문제

N×N개의 수가 N×N 크기의 표에 채워져 있다. (x1, y1)부터 (x2, y2)까지 합을 구하는 프로그램을 작성하시오. (x, y)는 x행 y열을 의미한다.
예를 들어, N = 4이고, 표가 아래와 같이 채워져 있는 경우를 살펴보자.
 1	 2	 3	 4
 2	 3	 4	 5
 3	 4	 5	 6
 4	 5	 6	 7
여기서 (2, 2)부터 (3, 4)까지 합을 구하면 3+4+5+4+5+6 = 27이고, (4, 4)부터 (4, 4)까지 합을 구하면 7이다.
표에 채워져 있는 수와 합을 구하는 연산이 주어졌을 때, 이를 처리하는 프로그램을 작성하시오.

입력

첫째 줄에 표의 크기 N과 합을 구해야 하는 횟수 M이 주어진다. (1 ≤ N ≤ 1024, 1 ≤ M ≤ 100,000) 둘째 줄부터 N개의 줄에는 표에 채워져 있는 수가 1행부터 차례대로 주어진다. 
다음 M개의 줄에는 네 개의 정수 x1, y1, x2, y2 가 주어지며, (x1, y1)부터 (x2, y2)의 합을 구해 출력해야 한다. 표에 채워져 있는 수는 1,000보다 작거나 같은 자연수이다. (x1 ≤ x2, y1 ≤ y2)

출력

총 M줄에 걸쳐 (x1, y1)부터 (x2, y2)까지 합을 구해 출력한다.
*/

import java.io.*;
import java.util.*;

public class SumOfSection2 {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[][] num = new int[N+1][N+1];
        int[][] sum = new int[N+1][N+1];
        int x1, x2, y1, y2;
        for (int i=1; i<=N; i++){
            for (int j=1; j<=N; j++){
                num[i][j] = sc.nextInt();
                if(j == 1)
                    sum[i][j] = sum[i-1][j] + num[i][j];
                else
                    sum[i][j] = sum[i-1][j] + sum[i][j-1] - sum[i-1][j-1] + num[i][j];
            }
        }
        for (int i=0; i<M; i++){
            x1 = sc.nextInt();
            y1 = sc.nextInt();
            x2 = sc.nextInt();
            y2 = sc.nextInt();
            bw.write(sum[x2][y2] - sum[x2][y1-1] - sum[x1-1][y2] + sum[x1-1][y1-1] + "\n");
        }
        sc.close();
        bw.flush();
        bw.close();
    }
}