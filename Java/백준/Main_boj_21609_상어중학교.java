package study;

import java.io.*;
import java.util.*;

public class Main_boj_21609_상어중학교 {
	static class Standard {
		int r, c, count, rainbow;
		public Standard(int r, int c, int count, int rainbow) {
			this.r = r;
			this.c = c;
			this.count = count;
			this.rainbow = rainbow;
		}
	}
	static int N, M, block[][], dr[] = {-1,1,0,0}, dc[] = {0,0,-1,1};
	static Standard max;
	static boolean[][] check;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		block = new int[N][N];
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=0;j<N;j++)
				block[i][j] = Integer.parseInt(st.nextToken());
		}
		int score = 0;
		max = new Standard(-1, -1, 0, 0);
		while(findGroup()) {
			score += Math.pow(max.count, 2);
			removeBlock(max.r, max.c);
			fallDown();
			block = turnClockwise();
			fallDown();
			max = new Standard(-1, -1, 0, 0);
		}
		System.out.println(score);
	}
	private static int[][] turnClockwise() {
		int[][] result = new int[N][N];
		for(int i=0;i<N;i++)
			for(int j=0;j<N;j++)
				result[N-1-j][i] = block[i][j];
		
		return result;
	}
	private static void fallDown() {
		for(int j=0;j<N;j++) {
			for(int i=N-1;i>0;i--) {
				if(block[i][j] > -2)
					continue;
				int idx = i-1;
				while(block[idx][j] == -2) {
					if(idx == 0)
						break;
					idx--;
				}
				if(block[idx][j] == -1) {
					i--;
					continue;
				}
				block[i][j] = block[idx][j];
				block[idx][j] = -2;
			}
		}
	}
	private static void removeBlock(int r, int c) {
		Queue<int[]> queue = new LinkedList<int[]>();
		int compare = block[r][c];
		queue.add(new int[] {r, c});
		while(!queue.isEmpty()) {
			int[] now = queue.poll();
			for(int d=0;d<4;d++) {
				int nr = now[0] + dr[d];
				int nc = now[1] + dc[d];
				if(nr<0||nc<0||nr>=N||nc>=N)
					continue;
				int num = block[nr][nc];
				if(num < 0 || num > 0 && num != compare)
					continue;
				block[nr][nc] = -2;
				queue.offer(new int[] {nr, nc});
			}
		}
	}
	private static boolean findGroup() {
		int count = 0;
		check = new boolean[N][N];
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(block[i][j]<1 || check[i][j])
					continue;
				Standard tmp = bfs(i, j);
				if(tmp.count == 0)
					continue;
				count++;
				if(tmp.count > max.count ||
						tmp.count == max.count && (
								tmp.rainbow > max.rainbow || 
									tmp.rainbow == max.rainbow && (
										tmp.r > max.r ||
											tmp.r == max.r &&
													tmp.c > max.c))) {
					max = tmp;
				}
			}
		}
		if(count > 0)
			return true;
		else
			return false;
	}
	private static Standard bfs(int r, int c) {
		int count = 0, compare = block[r][c], rainbow = 0;
		Queue<int[]> queue = new LinkedList<int[]>();
		boolean[][] visited = new boolean[N][N];
		queue.offer(new int[] {r, c});
		visited[r][c] = true;
		while(!queue.isEmpty()) {
			count++;
			int[] now = queue.poll();
			check[now[0]][now[1]] = true;
			for(int d=0;d<4;d++) {
				int nr = now[0] + dr[d];
				int nc = now[1] + dc[d];
				if(nr<0||nc<0||nr>=N||nc>=N||visited[nr][nc])
					continue;
				int num = block[nr][nc];
				if(num < 0 || num > 0 && num != compare)
					continue;
				if(num == 0)
					rainbow++;
				visited[nr][nc] = true;
				queue.offer(new int[] {nr, nc});
			}
		}
		if(count < 2)
			count = 0;
		return new Standard(r, c, count, rainbow);
	}
}
