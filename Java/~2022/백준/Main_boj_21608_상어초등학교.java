package week9;

import java.io.*;
import java.util.*;

public class Main_boj_21608_상어초등학교 {
	static class Seat implements Comparable<Seat>{
		int r, c, like, empty;
		public Seat(int r, int c, int like, int empty) {
			this.r = r;
			this.c = c;
			this.like = like;
			this.empty = empty;
		}
		@Override
		public int compareTo(Seat o) {
			if(this.like == o.like) {
				if(this.empty == o.empty) {
					if(this.r == o.r)
						return this.c - o.c;
					else
						return this.r - o.r;
				}else
					return -(this.empty - o.empty);
			}else
				return -(this.like - o.like);
		}
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine().trim()), total = N*N;
		int[][] map = new int[N+1][N+1];
		int[] dr = {-1,1,0,0}, dc = {0,0,-1,1};
		Map<Integer, Set<Integer>> info = new HashMap<Integer, Set<Integer>>();
		StringTokenizer st;
		for(int k=1;k<=total;k++) {
			st = new StringTokenizer(br.readLine());
			int no = Integer.parseInt(st.nextToken());
			Set<Integer> likes = new HashSet<Integer>();
			for(int i=0;i<4;i++)
				likes.add(Integer.parseInt(st.nextToken()));
			info.put(no, likes);
			
			PriorityQueue<Seat> queue = new PriorityQueue<Seat>();
			for(int i=1;i<=N;i++) {
				for(int j=1;j<=N;j++) {
					if(map[i][j] > 0)
						continue;
					int like = 0, empty = 0;
					for(int d=0;d<4;d++) {
						int nr = i + dr[d];
						int nc = j + dc[d];
						if(nr<=0 || nc<=0 || nr>N || nc>N)
							continue;
						int num = map[nr][nc];
						if(num == 0)
							empty++;
						else if(likes.contains(num))
							like++;
					}
					queue.add(new Seat(i, j, like, empty));
				}
			}
			
			Seat find = queue.poll();
			map[find.r][find.c] = no;
		}
		
		int score = 0;
		for(int i=1;i<=N;i++) {
			for(int j=1;j<=N;j++) {
				int now = map[i][j];
				int count = 0;
				for(int d=0;d<4;d++) {
					int nr = i+dr[d];
					int nc = j+dc[d];
					
					if(nr<=0 || nc<=0 || nr>N || nc>N)
						continue;
					
					Set<Integer> likes = info.get(now);
					if(likes.contains(map[nr][nc]))
						count++;
				}
				score += count == 0 ? 0 : (int)Math.pow(10, count-1);
			}
		}
		System.out.println(score);
	}
}
