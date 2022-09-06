/*
문제

수열 S가 어떤 수 Sk를 기준으로 S1 < S2 < ... Sk-1 < Sk > Sk+1 > ... SN-1 > SN을 만족한다면, 그 수열을 바이토닉 수열이라고 한다.
예를 들어, {10, 20, 30, 25, 20}과 {10, 20, 30, 40}, {50, 40, 25, 10} 은 바이토닉 수열이지만,  {1, 2, 3, 2, 1, 2, 3, 2, 1}과 {10, 20, 30, 40, 20, 30} 은 바이토닉 수열이 아니다.
수열 A가 주어졌을 때, 그 수열의 부분 수열 중 바이토닉 수열이면서 가장 긴 수열의 길이를 구하는 프로그램을 작성하시오.

입력

첫째 줄에 수열 A의 크기 N이 주어지고, 둘째 줄에는 수열 A를 이루고 있는 Ai가 주어진다. (1 ≤ N ≤ 1,000, 1 ≤ Ai ≤ 1,000)

출력

첫째 줄에 수열 A의 부분 수열 중에서 가장 긴 바이토닉 수열의 길이를 출력한다.
*/

import java.io.*;
import java.util.*;

public class Bitonic {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(st.nextToken());
        int[] num = new int[N+1];
        int[][] dp = new int[N+1][2];
        int max = 0, len;
        st = new StringTokenizer(br.readLine());
        for (int i=1; i<=N; i++)
            num[i] = Integer.parseInt(st.nextToken());

        for (int i=1; i<=N; i++) {
            len = 0;
            for (int j=1; j<i; j++)
                if(num[j] < num[i] && len < dp[j][0])
                    len = dp[j][0];
            dp[i][0] = len+1;
        }
        for (int i=N; i>=1; i--) {
            len = 0;
            for (int j=N; j>i; j--)
                if(num[j] < num[i] && len < dp[j][1])
                    len = dp[j][1];
            dp[i][1] = len+1;
            max = Math.max(max, dp[i][0]+dp[i][1]-1);
        }
        bw.write(max + "\n");
        bw.close();
    }
}