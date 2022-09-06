package week10;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_swea_최장공통부분수열 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine().trim());
		StringBuilder sb = new StringBuilder();
		for(int tc=1;tc<=T;tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			String s1 = st.nextToken(), s2 = st.nextToken();
			int len1 = s1.length(), len2 = s2.length();
			int[][] dp = new int[len1+1][len2+1];
			
			for(int i=1;i<=len1;i++)
				for(int j=1;j<=len2;j++) {
					if(s1.charAt(i-1) == s2.charAt(j-1))
						dp[i][j] = dp[i-1][j-1] + 1;
					else
						dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
				}
			
			sb.append("#").append(tc).append(" ").append(dp[len1][len2]).append("\n");
		}
		System.out.println(sb.toString());
	}
}
