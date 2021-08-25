package week6;

import java.io.*;
import java.util.*;

public class Main_boj_16954_움직이는미로탈출 {
		static final int SIZE = 8;
		static class State {
			int r, c, time;
			
			public State(int r, int c, int time) {
				this.r = r;
				this.c = c;
				this.time = time;
			}
		}

		static char[][] map = new char[SIZE][SIZE];
		public static void main(String[] args) throws Exception {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			int wall = 0;
			for(int i=0;i<SIZE;i++) {
				String s = br.readLine();
				for(int j=0;j<SIZE;j++) {
					map[i][j] = s.charAt(j);
					if(map[i][j] == '#')
						wall++;
				}
			}
			
			int result = 0;
			if(wall == 0)
				result = 1;
			else {
				int[] dr = {-1,-1,0,1,1,1,0,-1,0}, dc = {1,0,1,1,0,-1,-1,-1,0};
				int[] character = {SIZE-1, 0}, end = {0, SIZE-1};
				int time = 1;
				Queue<State> queue = new LinkedList<State>();
				
				queue.offer(new State(character[0], character[1], 1));
				
				while(!queue.isEmpty()) {
					State now = queue.poll();
					
					if(now.time != time) {
						time++;
						move();
					}
					if(now.r == end[0] && now.c == end[1]) {
						result = 1;
						break;
					}
					if(now.time == SIZE) {
						if(map[now.r][now.c]!='#')
							result = 1;
						break;
					}
					
					for(int d=0;d<9;d++) {
						int nr = now.r + dr[d];
						int nc = now.c + dc[d];
						
						if(nr<0||nc<0||nr>=SIZE||nc>=SIZE||map[nr][nc]=='#'||(nr-1>=0 && map[nr-1][nc]=='#'))
							continue;
						
						queue.offer(new State(nr, nc, now.time+1));
					}
				}
			}
			System.out.println(result);
		}
		private static void move() {
			for(int i=SIZE-1;i>0;i--)
				for(int j=0;j<SIZE;j++)
					map[i][j] = map[i-1][j];
			for(int j=0;j<SIZE;j++)
				map[0][j] = '.';
		}
	}