package study;

import java.io.*;
import java.util.StringTokenizer;

public class Main_boj_17204_죽음의게임 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[] point = new int[N];
		
		for(int i=0;i<N;i++)
			point[i] = Integer.parseInt(br.readLine().trim());
		
		int M = theGameOfDeath(N, K, point);
		
		System.out.print(M);
	}

	private static int theGameOfDeath(int n, int k, int[] point) {
		boolean[] visited = new boolean[n];
		
		int next = 0, count = 0;
		while(true) {
			if(visited[next]) {
				count = -1;
				break;
			}
			
			count++;
			visited[next] = true;
			next = point[next];
			
			if(next == k)
				break;
		}
		
		return count;
	}
}
