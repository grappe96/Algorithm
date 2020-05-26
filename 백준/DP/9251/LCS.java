/*
문제

LCS(Longest Common Subsequence, 최장 공통 부분 수열)문제는 두 수열이 주어졌을 때, 모두의 부분 수열이 되는 수열 중 가장 긴 것을 찾는 문제이다.
예를 들어, ACAYKP와 CAPCAK의 LCS는 ACAK가 된다.

입력

첫째 줄과 둘째 줄에 두 문자열이 주어진다. 
문자열은 알파벳 대문자로만 이루어져 있으며, 최대 1000글자로 이루어져 있다.

출력

첫째 줄에 입력으로 주어진 두 문자열의 LCS의 길이를 출력한다.
*/

import java.io.*;

public class LCS {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S1, S2;
        int L1, L2;
        int[][] DP;

        S1 = br.readLine();
        L1 = S1.length();
        S2 = br.readLine();
        L2 = S2.length();
        DP = new int[L1+1][L2+1];
        
        for(int i=1; i<=L1; i++){
            for(int j=1; j<=L2; j++){
                if(S1.charAt(i-1) == S2.charAt(j-1))
                    DP[i][j] = DP[i-1][j-1]+1;
                else
                    DP[i][j] = Math.max(DP[i-1][j], DP[i][j-1]);
            }
        }
        bw.write(DP[L1][L2] + "\n");
        bw.close();
    }
}