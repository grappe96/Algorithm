package study;

import java.io.*;
import java.util.*;

public class Main_boj_10164_격자상의경로 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		long[][] dp = new long[N+1][M+1];
		
		for(int i=1;i<=N;i++)
			dp[i][1] = 1;
		for(int j=1;j<=M;j++)
			dp[1][j] = 1;
		
		for(int i=2;i<=N;i++)
			for(int j=2;j<=M;j++)
				dp[i][j] = dp[i-1][j] + dp[i][j-1];
		
		if(K==0)
			System.out.println(dp[N][M]);
		else {
			int r = K%M == 0 ? K/M : K/M+1;
			int c = K%M == 0 ? M : K%M;
			System.out.println(dp[r][c] * dp[N-r+1][M-c+1]);
		}
	}
}
