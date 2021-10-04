package study;

import java.io.*;
import java.util.*;

public class Main_boj_2294_µ¿Àü2 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		final int max = 100001;
		boolean[] check = new boolean[max];
		int dp[] = new int[max+1], coins[] = new int[n], idx = 0;
		Arrays.fill(dp, max);
		Arrays.fill(coins, max);
		for(int i=0;i<n;i++) {
			int num = Integer.parseInt(br.readLine().trim());
			if(!check[num]) {
				check[num] = true;
				coins[idx++] = num;
				dp[num] = 1;
			}
		}
		Arrays.sort(coins);
		for(int i=0;i<idx;i++) {
			int tmp = coins[i];
			for(int j=tmp+1;j<=k;j++)
				dp[j] = Math.min(dp[j], dp[j-tmp]+1);
		}
		if(dp[k] == max)
			System.out.println(-1);
		else
			System.out.println(dp[k]);
	}
}
