package week7;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_boj_14620_²É±æ {

	static int N, map[][], dr[] = {1,-1,0,0,0}, dc[] = {0,0,-1,1,0}, min, res;
	static boolean[][] visited;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine().trim());
		map = new int[N][N];
		for(int i=0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for(int j=0;j<N;j++)
				map[i][j] = Integer.parseInt(st.nextToken());
		}
		
		min = Integer.MAX_VALUE;
		visited = new boolean[N][N];
		dfs(0, 0);
		
		System.out.println(min);
	}
	private static void dfs(int n, int sum) {
		
		if(n == 3) {
			min = Math.min(min, sum);
			return;
		}	
		
		for(int i=1;i<N-1;i++) {
			for(int j=1;j<N-1;j++) {
				if(!visited[i][j] && check(i, j)) {
					res = 0;
					toggle(i, j);
					dfs(n+1, sum+res);
					toggle(i, j);
				}
			}
		}
	}
	private static void toggle(int r, int c) {
		for(int d=0;d<5;d++) {
			int nr = r+dr[d];
			int nc = c+dc[d];
			
			res += map[nr][nc];
			visited[nr][nc] = !visited[nr][nc];
		}
	}
	private static boolean check(int r, int c) {
		for(int d=0;d<4;d++) {
			int nr = r+dr[d];
			int nc = c+dc[d];
			
			if(visited[nr][nc])
				return false;
		}
		return true;
	}
}
