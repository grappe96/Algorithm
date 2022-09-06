package week5;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_boj_2573_빙산 {

	static int N, M, iceberg[][], dr[] = {1,-1,0,0}, dc[] = {0,0,-1,1};
	static boolean[][] visited;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		iceberg = new int[N][M];
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++)
				iceberg[i][j] = Integer.parseInt(st.nextToken());
		}
		
		int time = 0;
		while(true) {
			time++;
			
			//얼음이 녹는 부분
			int[][] after = new int[N][M];
			for(int i=1;i<N-1;i++)
				for(int j=1;j<M-1;j++) {
					if(iceberg[i][j]>0) {
						int count = 0;
						for(int d=0;d<4;d++) {
							int nr = i+dr[d];
							int nc = j+dc[d];
							
							if(nr<0||nc<0||nr>=N||nc>=M)
								continue;
							if(iceberg[nr][nc] == 0)
								count++;
						}
						
						after[i][j] = iceberg[i][j] - count > 0 ? iceberg[i][j] - count : 0;
					}
				}
			
			for(int i=1;i<N-1;i++)
				iceberg[i] = after[i].clone();
			
			//빙산이 한 조각인지 확인
			visited = new boolean[N][M];
			int count = 0;
			for(int i=1;i<N-1;i++)
				for(int j=1;j<M-1;j++) {
					if(iceberg[i][j]>0 && !visited[i][j]) {
						dfs(i, j);
						count++;
					}
				}
			
			if(count > 1)
				break;
			else if(count == 0) {
				time = 0;
				break;
			}
		}
		System.out.println(time);
	}

	private static void dfs(int i, int j) {
		visited[i][j] = true;
		
		for(int d=0;d<4;d++) {
			int nr = i+dr[d];
			int nc = j+dc[d];
			
			if(nr<0||nc<0||nr>=N||nc>=M||visited[nr][nc])
				continue;
			if(iceberg[nr][nc]>0)
				dfs(nr, nc);
		}
	}
}
