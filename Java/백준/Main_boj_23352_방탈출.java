package study;

import java.io.*;
import java.util.*;

public class Main_boj_23352_πÊ≈ª√‚ {
	static int N, M, map[][], max, answer, dr[] = {-1,1,0,0}, dc[] = {0,0,-1,1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=0;j<M;j++)
				map[i][j] = Integer.parseInt(st.nextToken());
		}
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(map[i][j] == 0)
					continue;
				bfs(i, j);
			}
		}
		System.out.print(answer);
	}
	private static void bfs(int r, int c) {
		boolean[][] visited = new boolean[N][M];
		Queue<int[]> queue = new LinkedList<int[]>();
		
		visited[r][c] = true;
		queue.add(new int[] {r, c, 1});
		if(max == 0)
			answer = Math.max(answer, map[r][c]*2);
		
		while(!queue.isEmpty()) {
			int[] now = queue.poll();
			
			for(int d=0;d<4;d++) {
				int nr = now[0] + dr[d];
				int nc = now[1] + dc[d];
				
				if(nr<0||nc<0||nr>=N||nc>=M||map[nr][nc]==0||visited[nr][nc])
					continue;
				
				visited[nr][nc] = true;
				queue.offer(new int[] {nr, nc, now[2]+1});
				if(now[2]+1 > max) {
					max = now[2]+1;
					answer = map[r][c] + map[nr][nc];
				}else if(now[2] + 1 == max) 
					answer = Math.max(answer, map[r][c] + map[nr][nc]);
			}
		}
	}
}
