package study;

import java.io.*;
import java.util.StringTokenizer;

public class Main_boj_23288_주사위굴리기2 {
	static class Dice {
		int c, r, d, front, back, left, right, up, down;
		public Dice(int c, int r, int d, int front, int back, int left, int right, int up, int down) {
			this.c = c;
			this.r = r;
			this.d = d;
			this.front = front;
			this.back = back;
			this.left = left;
			this.right = right;
			this.up = up;
			this.down = down;
		}
	}
	static int N, M, map[][], dc[] = {0,1,0,-1}, dr[] = {1,0,-1,0}, count;
	static boolean[][] visited;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=0;j<M;j++)
				map[i][j] = Integer.parseInt(st.nextToken());
		}
		Dice dice = new Dice(0, 0, 0, 1, 6, 4, 3, 2, 5);
		int score = 0;
		while(--K >= 0) {
			int nc = dice.c + dc[dice.d];
			int nr = dice.r + dr[dice.d];
			
			if(nc<0||nr<0||nc>=N||nr>=M) {
				dice.d = (dice.d+2)%4;
				nc = dice.c + dc[dice.d];
				nr = dice.r + dr[dice.d];
			}
			dice.c = nc;
			dice.r = nr;
			
			rollDice(dice);
			
			visited = new boolean[N][M];
			count = 1;
			visited[nc][nr] = true;
			int num = map[nc][nr];
			dfs(nc, nr, num);
			score += num * count;
			
			if(dice.back > num)
				dice.d = dice.d == 3 ? 0 : dice.d+1;
			else if(dice.back < num)
				dice.d = dice.d == 0 ? 3 : dice.d-1;
		}
		System.out.println(score);
	}
	private static void dfs(int c, int r, int num) {
		for(int d=0;d<4;d++) {
			int nc = c + dc[d];
			int nr = r + dr[d];
			
			if(nc<0||nr<0||nc>=N||nr>=M||visited[nc][nr]||map[nc][nr]!=num)
				continue;
			count++;
			visited[nc][nr] = true;
			dfs(nc, nr, num);
		}
	}
	private static void rollDice(Dice dice) {
		int tmp = dice.front;
		switch(dice.d) {
		case 0:
			dice.front = dice.left;
			dice.back = 7-dice.front;
			dice.right = tmp;
			dice.left = 7-dice.right;
			break;
		case 1:
			dice.front = dice.up;
			dice.back = 7-dice.front;
			dice.down = tmp;
			dice.up = 7-dice.down;
			break;
		case 2:
			dice.front = dice.right;
			dice.back = 7-dice.front;
			dice.left = tmp;
			dice.right = 7-dice.left;
			break;
		case 3:
			dice.front = dice.down;
			dice.back = 7-dice.front;
			dice.up = tmp;
			dice.down = 7-dice.up;
			break;
		}
	}
}
