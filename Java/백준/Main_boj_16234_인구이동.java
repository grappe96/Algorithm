package study;

import java.io.*;
import java.util.*;

public class Main_boj_16234_인구이동 {
	static class Block {
		int r, c;
		public Block(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
	static int N, L, R, total, sum, map[][], dr[] = {-1, 1, 0, 0}, dc[] = {0, 0, -1, 1};
	static boolean[][] visited;
	static List<Block> union; 
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());

		map = new int[N][N];
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=0;j<N;j++)
				map[i][j] = Integer.parseInt(st.nextToken());
		}
		
		int day = 0;
		boolean check = true;
		while(check) {
			visited = new boolean[N][N];
			int[][] newMap = new int[N][N];
			int count = 0;
			
			for(int i=0;i<N;i++)
				newMap[i] = map[i].clone();

			for(int i=0;i<N&&check;i++) {
				for(int j=0;j<N&&check;j++) {
					if(!visited[i][j]) {
						count++;
						visited[i][j] = true;
						total = 1;
						sum = map[i][j];
						union = new ArrayList<Block>();
						union.add(new Block(i, j));
						dfs(i, j);
						
						if(total == 1)
							continue;
						else if(total == N*N)
							check = false;
						
						int average = Math.floorDiv(sum, total);
						for(int k=0;k<total;k++) {
							Block now = union.get(k);
							newMap[now.r][now.c] = average;
						}
					}
				}
			}
			if(count == N*N)
				break;
			for(int i=0;i<N;i++)
				map[i] = newMap[i].clone();
			day++;
		}
		System.out.print(day);
	}
	private static void dfs(int r, int c) {
		for(int d=0;d<4;d++) {
			int nr = r+dr[d];
			int nc = c+dc[d];
			
			if(nr<0||nc<0||nr>=N||nc>=N||visited[nr][nc]||Math.abs(map[r][c]-map[nr][nc])>R||Math.abs(map[r][c]-map[nr][nc])<L)
				continue;
			
			visited[nr][nc] = true;
			total++;
			sum += map[nr][nc];
			union.add(new Block(nr, nc));
			dfs(nr, nc);
		}
	}
}
