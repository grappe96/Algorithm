package study;

import java.io.*;
import java.util.StringTokenizer;

public class Main_boj_1520_내리막길 {
	static int[] dr = {-1,1,0,0}, dc= {0,0,-1,1};
	static int M, N, map[][], dp[][];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		map = new int[M][N];
		dp = new int[M][N];
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=0;j<N;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				dp[i][j] = -1;
			}
		}
		
		System.out.println(dfs(0,0, map[0][0]));
	}
	private static int dfs(int r, int c, int now) {
		if(r == M-1 && c == N-1)
			return 1;
		
		int result = dp[r][c];
		if(result > -1) return result;
		
		result = 0;
		for(int d=0;d<4;d++) {
			int nr = r+dr[d];
			int nc = c+dc[d];
			
			if(nr<0||nc<0||nr>=M||nc>=N||map[nr][nc]>=now)
				continue;
			
			dp[r][c] = result += dfs(nr,nc,map[nr][nc]);
		}
		return result;
	}
}
