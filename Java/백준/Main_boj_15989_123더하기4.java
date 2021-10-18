package study;

import java.io.*;
import java.util.Arrays;

public class Main_boj_15989_123¥ı«œ±‚4 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine().trim());
		StringBuilder sb = new StringBuilder();
		for(int tc=1;tc<=T;tc++) {
			int N = Integer.parseInt(br.readLine().trim());
			int[] dp = new int[N+1];
			Arrays.fill(dp, 1);
			for(int i=2;i<=N;i++)
				dp[i] += dp[i-2];
			for(int i=3;i<=N;i++)
				dp[i] += dp[i-3];
			sb.append(dp[N]).append("\n");
		}
		System.out.println(sb.toString());
	}
}
