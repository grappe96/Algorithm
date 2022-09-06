package study;

import java.io.*;

public class Main_boj_17425_약수의합 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine().trim());
		StringBuilder sb = new StringBuilder();
		
		long[] f = new long[1000001];
		
		for(int i=1;i<=1000000;i++) {
			for(int j=1;i*j<=1000000;j++)
				f[i*j] += i;
		}
		
		long[] g = new long[1000001];
		
		for(int i=1;i<=1000000;i++)
			g[i] = g[i-1] + f[i];
		
		for(int tc=1;tc<=T;tc++) {
			int N = Integer.parseInt(br.readLine().trim());
			sb.append(g[N]).append("\n");
		}
		
		System.out.print(sb.toString());
	}
}
