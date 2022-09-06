package study;

public class Solution_pg_2017카카오코드예선_카카오프렌즈컬러링북 {
	static int dr[] = {-1,1,0,0}, dc[] = {0,0,-1,1}, map[][], count;
	boolean[][] visited;
	public int[] solution(int m, int n, int[][] picture) {
        int numberOfArea = 0, maxSizeOfOneArea = 0;
        visited = new boolean[m][n];
        map = new int[m][n];
        
        for(int i=0;i<m;i++)
        	map[i] = picture[i].clone();
        
        for(int i=0;i<m;i++)
        	for(int j=0;j<n;j++)
        		if(picture[i][j] > 0 && !visited[i][j]) {
        			visited[i][j] = true;
        			numberOfArea++;
        			count = 0;
        			dfs(m, n, i, j, picture[i][j]);
        			maxSizeOfOneArea = Math.max(maxSizeOfOneArea, count);
        		}
        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }
	private void dfs(int m, int n, int r, int c, int num) {
		count++;
		
		for(int d=0;d<4;d++) {
			int nr = r+dr[d];
			int nc = c+dc[d];
			
			if(nr<0||nc<0||nr>=m||nc>=n||visited[nr][nc]||map[nr][nc]!=num)
				continue;
			
			visited[nr][nc] = true;
			dfs(m, n, nr, nc, num);
		}
	}
}
