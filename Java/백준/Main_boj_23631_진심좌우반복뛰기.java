package study;

import java.io.*;
import java.util.StringTokenizer;

public class Main_boj_23631_Áø½ÉÁÂ¿ì¹İº¹¶Ù±â {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine().trim());
		StringBuilder sb = new StringBuilder();
		for(int tc=1;tc<=T;tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			
			long count = binarySearch(0, 5000, N, K);
			long diff = N-1 - (count+1)*count*K/2;
			
			if(count%2 == 0) {
				long num = -1 * K * (count/2) - diff;
				sb.append(num).append(" ").append("L\n");
			} else {
				long num = K * (count/2+1) + diff;
				sb.append(num).append(" ").append("R\n");
			}
		}
		System.out.print(sb.toString());
	}
	private static long binarySearch(long start, long end, int n, int k) {
		if(start >= end)
			return start;
		long middle = (start+end)/2;
		
		if((middle+1)*middle*k/2 >= n)
			return binarySearch(start, middle, n, k);
		else
			return binarySearch(middle+1, end, n, k);
	}
}
