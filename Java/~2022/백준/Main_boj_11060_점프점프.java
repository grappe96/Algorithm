package study;

import java.io.*;
import java.util.*;

public class Main_boj_11060_점프점프 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine().trim());
		int[] A = new int[N];
		int[] dp = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for(int i=0;i<N;i++) {
			A[i] = Integer.parseInt(st.nextToken());
			dp[i] = N;
		}
		dp[0] = 0;
		for(int i=0;i<N-1;i++) {
			if(dp[i] == N)
				continue;
			
			for(int j=1;j<=A[i];j++) {
				if(i+j >= N)
					continue;
				if(dp[i+j] > dp[i]+1)
					dp[i+j] = dp[i]+1;
			}
		}
		dp[N-1] = dp[N-1] == N ? -1 : dp[N-1];
		System.out.println(dp[N-1]);
	}
}
