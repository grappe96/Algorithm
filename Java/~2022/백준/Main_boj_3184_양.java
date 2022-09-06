package study;

import java.io.*;
import java.util.StringTokenizer;

public class Main_boj_3184_�� {
	static int R, C, dr[] = {-1, 1, 0, 0}, dc[] = {0,0,-1,1}, sheep, wolf;
	static char[][] yard;
	static boolean[][] visited;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		yard = new char[R][C];
		
		// �� ���� ���� ������ ��
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
				if(!visited[i][j] && yard[i][j] != '#') { // ������ ���е� �� ���� Ž��
					visited[i][j] = true;
					sheep = 0;
					wolf = 0;
					
					// ���� ������ ����ų� ���� ���
					if(yard[i][j] == 'v')
						wolf = 1;
					else if(yard[i][j] == 'o')
						sheep = 1;
					
					dfs(i, j);
					
					// ���� ���뺸�� ������ ���� �߹�, �ƴϸ� �� ��Ƹ���
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
			
			// ���� ������ �ִ� ��� ���� ���� ����
			if(yard[nr][nc] == 'o')
				sheep++;
			else if(yard[nr][nc] == 'v')
				wolf++;
			
			dfs(nr, nc);
		}
	}
}
