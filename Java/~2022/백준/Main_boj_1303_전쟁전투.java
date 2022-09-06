package study;

import java.io.*;
import java.util.StringTokenizer;

public class Main_boj_1303_¿¸¿Ô¿¸≈ı {
	static int N, M, count, dr[] = {-1,1,0,0}, dc[] = {0,0,-1,1};
	static char[][] map;
	static boolean[][] visited;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new char[M][N];
		visited = new boolean[M][N];
		
		for(int i=0;i<M;i++)
			map[i] = br.readLine().toCharArray();
		
		int ally = 0, enemy = 0;
		for(int i=0;i<M;i++) {
			for(int j=0;j<N;j++) {
				if(!visited[i][j]) {
					count = 1;
					dfs(i,j);
					if(map[i][j] == 'W')
						ally += (int)Math.pow(count, 2);
					else
						enemy += (int)Math.pow(count, 2);
				}
			}
		}
		System.out.println(ally+" "+enemy);
	}
	private static void dfs(int r, int c) {
		visited[r][c] = true;
		
		for(int d=0;d<4;d++) {
			int nr = r+dr[d];
			int nc = c+dc[d];
			
			if(nr<0||nc<0||nr>=M||nc>=N||visited[nr][nc])
				continue;
			
			if(map[nr][nc] == map[r][c]) {
				count++;
				dfs(nr, nc);
			}
		}
	}
}
