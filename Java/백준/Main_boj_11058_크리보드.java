package study;

import java.util.Scanner;

public class Main_boj_11058_크리보드 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		sc.close();
		
		long[] dp = new long[N+1];
		if(N<=3) {
			dp[N] = N;
		} else {
			dp[1] = 1;
			dp[2] = 2;
			dp[3] = 3;
			
			for(int i=4;i<=N;i++) {
				dp[i] = Math.max(dp[i-1]+1, dp[i-3]*2);
				for(int j=2;j<=i-3;j++)
					dp[i] = Math.max(dp[i], dp[i-(j+2)]*(j+1));
			}
		}
		System.out.println(dp[N]);
	}
}
