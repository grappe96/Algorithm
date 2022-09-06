package week4;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main_boj_16948_데스나이트 {
	static class Square {
		int r, c, count;
		
		public Square(int r, int c, int count) {
			this.r = r;
			this.c = c;
			this.count = count;
		}
	}

	static int N, r1, c1, r2, c2;
	static int[] dr = {-2, -2, 0, 0, 2, 2}, dc = {-1, 1, -2, 2, -1, 1};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		r1 = sc.nextInt();
		c1 = sc.nextInt();
		r2 = sc.nextInt();
		c2 = sc.nextInt();
		sc.close();
		
		System.out.println(bfs());
	}
	private static int bfs() {
		int answer = 0;
		boolean[][] visited = new boolean[N][N];
		Queue<Square> queue = new LinkedList<Square>();
		
		queue.add(new Square(r1, c1, 0));
		visited[r1][c1] = true;
		
		while(!queue.isEmpty()) {
			Square now = queue.poll();
			
			for(int d=0;d<6;d++) {
				int nr = now.r + dr[d];
				int nc = now.c + dc[d];
				
				if(nr < 0 || nc < 0 || nr >= N || nc >= N || visited[nr][nc])
					continue;
				
				if(nr == r2 && nc == c2) {
					answer = now.count + 1;
					break;
				}
				
				visited[nr][nc] = true;
				queue.add(new Square(nr, nc, now.count+1));
			}
			
			if(answer > 0)
				break;
		}
		
		return answer > 0 ? answer : -1;
	}
}
