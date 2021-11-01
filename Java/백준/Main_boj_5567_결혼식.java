package study;

import java.io.*;
import java.util.StringTokenizer;

public class Main_boj_5567_°áÈ¥½Ä {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine().trim());
		int m = Integer.parseInt(br.readLine().trim());
		int[][] adj = new int[n+1][n+1];
		for(int i=0;i<m;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			adj[a][b] = adj[b][a] = 1;
		}
		
		for(int i=2;i<=n;i++) {
			if(adj[1][i] == 1) {
				for(int j=2;j<=n;j++)
					if(adj[1][j] != 1 && adj[i][j] == 1)
						adj[1][j] = 2;
			}
		}
		
		int count = 0;
		for(int i=2;i<=n;i++)
			if(adj[1][i] > 0)
				count++;
		System.out.println(count);
	}
}
