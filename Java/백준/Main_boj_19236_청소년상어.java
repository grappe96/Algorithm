package study;

import java.io.*;
import java.util.StringTokenizer;

public class Main_boj_19236_청소년상어 {
	static class Fish {
		int r, c, d, num;
		public Fish(int r, int c, int num, int d) {
			this.r = r;
			this.c = c;
			this.num = num;
			this.d = d;
		}
	}
	static int n = 4, dr[] = {0,-1,-1,0,1,1,1,0,-1}, dc[] = {0,0,-1,-1,-1,0,1,1,1}, max;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[][] map = new int[n][n];
		Fish[] fishes = new Fish[17];
		for(int i=0;i<n;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for(int j=0;j<n;j++) {
				int num = Integer.parseInt(st.nextToken());
				int d = Integer.parseInt(st.nextToken());
				fishes[num] = new Fish(i, j, num, d);
				map[i][j] = num;
			}
		}
		int start = map[0][0];
		map[0][0] = -1;
		fishes[start].num = 0;
		Fish shark = new Fish(0, 0, start, fishes[start].d);
		moveShark(map, fishes, shark, start, 1);
		System.out.println(max);
	}
	private static void moveShark(int[][] map, Fish[] fishes, Fish shark, int sum, int depth) {
		max = Math.max(max, sum);
		moveFish(map, fishes);

		for(int d=1;d<4;d++) {
			int nr = shark.r + dr[shark.d]*d;
			int nc = shark.c + dc[shark.d]*d;
			if(nr<0||nc<0||nr>=n||nc>=n)
				break;
			int num = map[nr][nc];
			if(num <= 0)
				continue;
			
			Fish[] copiedFish = new Fish[17];
			for(int i=1;i<=16;i++)
				copiedFish[i] = new Fish(fishes[i].r, fishes[i].c, fishes[i].num, fishes[i].d);
			int[][] copiedMap = new int[n][n];
			for(int i=0;i<n;i++)
				copiedMap[i] = map[i].clone();
			
			copiedMap[shark.r][shark.c] = 0;
			copiedMap[nr][nc] = -1;
			copiedFish[num].num = 0;
			Fish newShark = new Fish(nr, nc, num, copiedFish[num].d);
			moveShark(copiedMap, copiedFish, newShark, sum+num, depth+1);
		}
	}
	private static void moveFish(int[][] map, Fish[] fishes) {
		for(int i=1;i<=16;i++) {
			Fish now = fishes[i];
			if(now.num == 0)
				continue;
			for(int d=1;d<=8;d++) {
				int nr = now.r + dr[now.d];
				int nc = now.c + dc[now.d];
				
				if(nr<0||nc<0||nr>=n||nc>=n||map[nr][nc]==-1) {
					now.d = now.d+1 == 8 ? 8 : (now.d+1)%8;
					continue;
				}
				
				int num = map[nr][nc];
				map[now.r][now.c] = num;
				if(num > 0) {
					fishes[num].r = now.r;
					fishes[num].c = now.c;
				}
				map[nr][nc] = i;
				fishes[i].r = nr;
				fishes[i].c = nc;
				fishes[i].d = now.d;
				break;
			}
		}
	}
}