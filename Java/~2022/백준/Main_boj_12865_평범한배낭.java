package study;

import java.io.*;
import java.util.StringTokenizer;

public class Main_boj_12865_Æò¹üÇÑ¹è³¶ {
	static class Stuff {
		int weight, value;
		public Stuff(int weight, int value) {
			this.weight = weight;
			this.value = value;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		Stuff arr[] = new Stuff[N];
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int weight = Integer.parseInt(st.nextToken());
			int value = Integer.parseInt(st.nextToken());
			arr[i] = new Stuff(weight, value);
		}
		
		int[] dp = new int[K+1];
		for(int i=0;i<N;i++) {
			for(int w=K;w>=arr[i].weight;w--)
				if(dp[w] < dp[w-arr[i].weight] + arr[i].value)
					dp[w] = dp[w-arr[i].weight] + arr[i].value;
		}
		System.out.println(dp[K]);
	}
}
