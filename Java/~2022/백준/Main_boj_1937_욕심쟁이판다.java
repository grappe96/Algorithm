package study;

import java.io.*;
import java.util.StringTokenizer;

public class Main_boj_1937_øÂΩ…¿Ô¿Ã∆«¥Ÿ {
	static int N, map[][], dp[][], max, dr[] = {-1,1,0,0}, dc[] = {0,0,-1,1};
	static boolean[][][] visited;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine().trim());
		map = new int[N][N];
		StringTokenizer st;
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=0;j<N;j++)
				map[i][j] = Integer.parseInt(st.nextToken());
		}
		
		dp = new int[N][N];
		max = 0;
		for(int i=0;i<N;i++)
			for(int j=0;j<N;j++) {
				if(dp[i][j] == 0)
					max = Math.max(max, dfs(i, j, map[i][j]));
			}
		System.out.println(max);
	}
	private static int dfs(int r, int c, int value) {
		if(dp[r][c] > 0)
			return dp[r][c];
		
		dp[r][c] = 1;
		
		for(int d=0;d<4;d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			
			if(nr<0||nc<0||nr>=N||nc>=N||map[nr][nc]<=value)
				continue;
			
			dp[r][c] = Math.max(dp[r][c], dfs(nr, nc, map[nr][nc]) + 1);
		}
		
		return dp[r][c];
	}
}
