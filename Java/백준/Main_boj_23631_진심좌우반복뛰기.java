package study;

import java.io.*;
import java.util.StringTokenizer;

public class Main_boj_23631_Áø½ÉÁÂ¿ì¹Ýº¹¶Ù±â {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine().trim());
		StringBuilder sb = new StringBuilder();
		for(int tc=1;tc<=T;tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			
			int sum = 0, num = 0, isOdd = 0, count = 0;
			while(true) {
				count++;
				isOdd = isOdd == 1 ? 0 : 1;
				if(sum + count*K > N-1) {
					num = isOdd == 1 ? num + (N-1 - sum) : num - (N-1 - sum);
					break;
				}
				sum += count*K;
				num = isOdd == 1 ? num + count*K : num - count*K;
			}
			sb.append(num).append(" ");
			if(isOdd == 1)
				sb.append("R");
			else
				sb.append("L");
			sb.append("\n");
		}
		System.out.print(sb.toString());
	}
}
