package week10;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution_swea_외계인침공 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine().trim());
		for(int tc=1;tc<=T;tc++) {
			int N = Integer.parseInt(br.readLine().trim());
			int[] city = new int[N];
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for(int i=0;i<N;i++)
				city[i] = Integer.parseInt(st.nextToken());
			long[] dp = new long[N];
			int idx = 0;
			dp[0] = city[0];
			if(N>1) {
				if(city[0] >= city[1])
					dp[1] = city[0];
				else {
					dp[1] = city[1];
					idx = 1;
				}
			}
			for(int i=2;i<N;i++) {
				long n1 = dp[i-1];
				long n2 = dp[i-2];
				int now = city[i];
				if(idx == i-2) {
					dp[i] = n1 + now;
					idx = i;
				}else if(n1 >= n2+now)
					dp[i] = n1;
				else {
					dp[i] = n2+now;
					idx = i;
				}
			}
			bw.write("#"+tc+" "+dp[N-1]+"\n");
		}
		bw.flush();
		bw.close();
	}
}
