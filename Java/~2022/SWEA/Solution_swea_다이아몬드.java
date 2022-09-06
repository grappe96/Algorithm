package week10;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_swea_다이아몬드 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine().trim());
		StringBuilder sb = new StringBuilder();
		for(int t=1;t<=tc;t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			int[] diamonds = new int[N+1];
			for(int i=1;i<=N;i++)
				diamonds[i] = Integer.parseInt(br.readLine().trim());
			Arrays.sort(diamonds);
			int start = 1, end = 1, count = 0, max = -1;
			while(end<=N) {
				if(diamonds[end]-diamonds[start]<=K) {
					end++;
					max = Math.max(max, ++count);
				}else {
					count--;
					start++;
				}
			}
			sb.append("#").append(t).append(" ").append(max).append("\n");
		}
		System.out.println(sb.toString());
	}
}
