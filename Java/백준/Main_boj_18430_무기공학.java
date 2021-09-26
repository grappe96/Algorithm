package study;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_boj_18430_무기공학 {
	static int N, M, answer, wood[][],
	dy[][] = {{0,1},{-1,0},{-1,0},{0,1}}, 
	dx[][] = {{-1,0},{0,-1},{0,1},{1,0}};
	static boolean[][] visited;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		answer = 0;
		if(N>=2 && M>=2) {
			wood = new int[N][M];
			for(int i=0;i<N;i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for(int j=0;j<M;j++)
					wood[i][j] = Integer.parseInt(st.nextToken());
			}
			visited = new boolean[N][M];
			dfs(0, 0, 0);
		}
		System.out.println(answer);
	}
	private static void dfs(int i, int j, int sum) {
		if(i==N && j==M) {
			answer = Math.max(answer, sum);
			return;
		}
		
		int ni = 0, nj = 0;
		if(i==N-1 && j==M-1) {
			ni = N;
			nj = M;
		} else {
			nj = (j+1)%M;
			ni = nj==0 ? (i+1)%N : i;
		}
		
		if(!visited[i][j]) {
			for(int t=0;t<4;t++) {
				int res = 0;
				for(int d=0;d<2;d++) {
					int ny = i+dy[t][d];
					int nx = j+dx[t][d];
					
					if(ny<0||nx<0||ny>=N||nx>=M||visited[ny][nx]) {
						res = -1;
						break;
					}
					res += wood[ny][nx];
				}
				
				if(res > 0) {
					res += wood[i][j]*2;
					visited[i][j] = true;
					visited[i+dy[t][0]][j+dx[t][0]] = true;
					visited[i+dy[t][1]][j+dx[t][1]] = true;
					dfs(ni, nj, sum+res);
					visited[i][j] = false;
					visited[i+dy[t][0]][j+dx[t][0]] = false;
					visited[i+dy[t][1]][j+dx[t][1]] = false;
				}
			}
		}
		dfs(ni, nj, sum);
	}
}
