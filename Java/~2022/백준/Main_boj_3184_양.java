package study;

import java.io.*;
import java.util.StringTokenizer;

public class Main_boj_3184_양 {
	static int R, C, dr[] = {-1, 1, 0, 0}, dc[] = {0,0,-1,1}, sheep, wolf;
	static char[][] yard;
	static boolean[][] visited;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		yard = new char[R][C];
		
		// 총 양의 수와 늑대의 수
		int totalSheep = 0, totalWolf = 0;
		for(int i=0;i<R;i++) {
			yard[i] = br.readLine().toCharArray();
			for(int j=0;j<C;j++) {
				if(yard[i][j] == '.' || yard[i][j] == '#')
					continue;
				if(yard[i][j] == 'o')
					totalSheep++;
				else totalWolf++;
			}
		}
		
		visited = new boolean[R][C];
		for(int i=0;i<R;i++)
			for(int j=0;j<C;j++)
				if(!visited[i][j] && yard[i][j] != '#') { // 벽으로 구분된 각 영역 탐색
					visited[i][j] = true;
					sheep = 0;
					wolf = 0;
					
					// 현재 지점이 늑대거나 양인 경우
					if(yard[i][j] == 'v')
						wolf = 1;
					else if(yard[i][j] == 'o')
						sheep = 1;
					
					dfs(i, j);
					
					// 양이 늑대보다 많으면 늑대 추방, 아니면 양 잡아먹힘
					if(sheep > wolf)
						totalWolf -= wolf;
					else
						totalSheep -= sheep;
				}
		
		System.out.print(totalSheep + " " + totalWolf);
	}
	private static void dfs(int r, int c) {
		for(int d=0;d<4;d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			
			if(nr<0||nr>=R||nc<0||nc>=C||visited[nr][nc]||yard[nr][nc]=='#')
				continue;
			
			visited[nr][nc] = true;
			
			// 현재 영역에 있는 양과 늑대 숫자 세기
			if(yard[nr][nc] == 'o')
				sheep++;
			else if(yard[nr][nc] == 'v')
				wolf++;
			
			dfs(nr, nc);
		}
	}
}
