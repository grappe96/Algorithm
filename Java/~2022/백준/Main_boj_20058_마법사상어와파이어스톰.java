package study;

import java.io.*;
import java.util.*;

public class Main_boj_20058_마법사상어와파이어스톰 {
	static int N, Q, A[][], dr[] = {-1,1,0,0}, dc[] = {0,0,-1,1}, size;
	static boolean[][] visited;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = (int) Math.pow(2, Integer.parseInt(st.nextToken()));
		Q = Integer.parseInt(st.nextToken());
		A = new int[N][N];
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=0;j<N;j++)
				A[i][j] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine(), " ");
		while(--Q>=0){
			size = (int) Math.pow(2, Integer.parseInt(st.nextToken()));
			if(size > 1)
				turnClock(N, 0, 0);
			A = melt();
		}
		int total = 0, max = 0;
		visited = new boolean[N][N];
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(A[i][j] == 0)
					continue;
				total += A[i][j];
				if(!visited[i][j])
					max = Math.max(max, bfs(i, j));
			}
		}
		System.out.println(total);
		System.out.println(max);
	}
	private static int bfs(int r, int c) {
		Queue<int[]> queue = new LinkedList<int[]>();
		visited[r][c] = true;
		queue.offer(new int[] {r, c});
		int count = 1;
		while(!queue.isEmpty()) {
			int[] now = queue.poll();
			for(int d=0;d<4;d++) {
				int nr = now[0] + dr[d];
				int nc = now[1] + dc[d];
				
				if(nr<0||nc<0||nr>=N||nc>=N||visited[nr][nc]||A[nr][nc]==0)
					continue;
				visited[nr][nc] = true;
				count++;
				queue.offer(new int[] {nr, nc});
			}
		}
		return count;
	}
	private static int[][] melt() {
		int[][] result = new int[N][N];
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				int value = A[i][j];
				if(A[i][j] > 0) {
					int count = 0;
					for(int d=0;d<4;d++) {
						int nr = i + dr[d];
						int nc = j + dc[d];
						
						if(nr<0||nc<0||nr>=N||nc>=N||A[nr][nc]==0)
							continue;
						count++;
					}
					if(count < 3)
						value -= 1;
				}
				result[i][j] = value;
			}
		}
		return result;
	}
	private static void turnClock(int len, int r, int c) {
		if(len == size) {
			int[][] result = new int[len][len];
			for(int i=r;i<r+len;i++)
				for(int j=c;j<c+len;j++)
					result[j-c][r+len-1-i] = A[i][j];
			for(int i=r;i<r+len;i++)
				for(int j=c;j<c+len;j++)
					A[i][j] = result[i-r][j-c];
			return;
		}
		int next = len/2;
		turnClock(next, r, c);
		turnClock(next, r+next, c);
		turnClock(next, r, c+next);
		turnClock(next, r+next, c+next);
	}
}
