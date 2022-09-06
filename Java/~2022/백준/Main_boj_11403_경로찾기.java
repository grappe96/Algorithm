package week9;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_boj_11403_경로찾기 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine().trim());
		int[][] adj = new int[N+1][N+1];
		StringTokenizer st;
		for(int i=1;i<=N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=1;j<=N;j++)
				adj[i][j] = Integer.parseInt(st.nextToken());
		}
		
		for(int k=1;k<=N;k++)
			for(int i=1;i<=N;i++)
				for(int j=1;j<=N;j++) {
					if(adj[i][j] == 1)
						continue;
					adj[i][j] = adj[i][k] + adj[k][j] == 2 ? 1 : 0;
				}
		
		StringBuilder sb = new StringBuilder();
		for(int i=1;i<=N;i++) {
			for(int j=1;j<=N;j++)
				sb.append(adj[i][j]).append(" ");
			sb.append("\n");
		}
		System.out.print(sb.toString());
	}
}
