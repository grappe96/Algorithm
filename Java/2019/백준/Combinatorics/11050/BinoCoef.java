/*
문제

자연수 N과 정수 K가 주어졌을 때 이항계수를 구하는 프로그램을 작성하시오.

입력

첫째 줄에 N과 K가 주어진다. (1 ≤ N ≤ 10, 0 ≤ K ≤ N)

출력

이항 계수를 출력한다.
*/

import java.io.*;
import java.util.*;

public class BinoCoef {
    public static int[][] dp = new int[11][11];
    public static void main(String[] args) throws IOException {

        System.setIn(new FileInputStream("Test/test.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        bw.write(bin(N, K) + "\n");
        bw.close();
    }
    public static int bin(int n, int k){
        if(dp[n][k] > 0)
            return dp[n][k];
        if(k == 0 || k == n)
            return dp[n][k] = 1;
        return bin(n-1, k-1) + bin(n-1, k);
    }
}