/*
문제

자연수 N과 정수 K가 주어졌을 때 이항계수를 10,007로 나눈 나머지를 구하는 프로그램을 작성하시오.

입력

첫째 줄에 N과 K가 주어진다. (1 ≤ N ≤ 1,000, 0 ≤ K ≤ N)

출력

이항계수를 10,007로 나눈 나머지를 출력한다.
*/

import java.io.*;
import java.util.*;

public class BinCoef2 {
    public static int[][] dp = new int[1001][1001];
    public static void main(String[] args) throws IOException {

        System.setIn(new FileInputStream("Test/test.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        for(int i=1;i<=N;i++){
            for(int j=0;j<=K;j++){
                if(j == 0 || j == i)
                    dp[i][j] = 1;
                else
                    dp[i][j] = (dp[i-1][j-1] + dp[i-1][j]) % 10007;
            }
        }
        bw.write(dp[N][K] + "\n");
        bw.close();
    }
}