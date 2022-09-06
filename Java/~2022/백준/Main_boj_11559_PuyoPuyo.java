package study;

import java.io.*;

public class Main_boj_11559_PuyoPuyo {
	static boolean[] visited[], exploded[];
	static int n = 12, m = 6, result = 0,
			dr[] = {-1,1,0,0}, dc[] = {0,0,-1,1};
	static char[][] field;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		field = new char[n][m];
		for(int i=0;i<n;i++)
			field[i] = br.readLine().toCharArray();
		
		int total = 0, count = 0;
		while(true) {
			visited = new boolean[n][m];
			for(int i=n-1;i>=0;i--) {
				for(int j=0;j<m;j++)
					if(!visited[i][j]) {
						if(field[i][j] == '.') {
							visited[i][j] = true;
							continue;
						}
						result = 1;
						dfs(i,j);
						if(result >= 4) {
							count++;
							exploded = new boolean[n][m];
							explode(i,j, field[i][j]);
						}
					}
			}
			if(count == 0)
				break;
			else {
				total++;
				count = 0;
				fall();
			}
		}
		System.out.println(total);
	}
	private static void dfs(int r, int c) {
		visited[r][c] = true;
		
		for(int d=0;d<4;d++) {
			int nr = r+dr[d];
			int nc = c+dc[d];
			
			if(nr<0||nc<0||nr>=n||nc>=m||visited[nr][nc])
				continue;
			
			if(field[nr][nc] == '.') {
				visited[nr][nc] = true;
				continue;
			}
			
			if(field[nr][nc] == field[r][c]) {
				result++;
				dfs(nr,nc);
			}
		}
	}
	private static void explode(int r, int c, char ch) {
		exploded[r][c] = true;
		field[r][c] = '.';
		
		for(int d=0;d<4;d++) {
			int nr = r+dr[d];
			int nc = c+dc[d];
			
			if(nr<0||nc<0||nr>=n||nc>=m||exploded[nr][nc])
				continue;
			
			if(field[nr][nc] == '.') {
				exploded[nr][nc] = true;
				continue;
			}
			
			if(field[nr][nc] == ch)
				explode(nr,nc, ch);
		}
	}
	private static void fall() {
		for(int i=0;i<m;i++) 
			for(int j=n-1;j>=0;j--)
				if(field[j][i] == '.')
					for(int k=j-1;k>=0;k--)
						if(field[k][i]!='.') {
							field[j][i] = field[k][i];
							field[k][i] = '.';
							break;
						}
	}
}
