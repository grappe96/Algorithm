package study;

import java.util.Scanner;

public class Main_boj_2193_ÀÌÄ£¼ö {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		sc.close();

		long[] dp = new long[90];
		dp[0] = dp[1] = 1;
		
		for(int i=2;i<N;i++)
			dp[i] = dp[i-1] + dp[i-2];
		
		System.out.println(dp[N-1]);
	}
}
