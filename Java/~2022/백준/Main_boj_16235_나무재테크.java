package study;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main_boj_16235_나무재테크 {
	static class Tree implements Comparable<Tree>{
		int r, c, age;
		public Tree(int r, int c, int age) {
			this.r = r;
			this.c = c;
			this.age = age;
		}
		@Override
		public int compareTo(Tree o) {
			return this.age - o.age;
		}
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[][] A = new int[N+1][N+1];
		int[][] map = new int[N+1][N+1];
		for(int i=1;i<=N;i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=1;j<=N;j++) {
				A[i][j] = Integer.parseInt(st.nextToken());
				map[i][j] = 5;
			}
		}
		List<Tree> tree = new LinkedList<Tree>();
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine(), " ");
			tree.add(new Tree(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
		}
		
		int answer = M, dr[] = {-1, -1, -1, 0, 0, 1, 1, 1}, dc[] = {-1, 0, 1, -1, 1, -1, 0, 1};
		while(--K >= 0) {
			List<Tree> next = new LinkedList<Tree>();
			List<Tree> summer = new LinkedList<Tree>();
			List<Tree> fall = new LinkedList<Tree>();
			
			Collections.sort(tree);
			while(!tree.isEmpty()) { // 봄
				Tree now = tree.remove(0);
				if(map[now.r][now.c] >= now.age) {
					map[now.r][now.c] -= now.age;
					now.age += 1;
					next.add(now);
					if(now.age % 5 == 0)
						fall.add(now);
				}else {
					summer.add(now);
					answer--;
				}
			}
			
			while(!summer.isEmpty()) { // 여름
				Tree now = summer.remove(0);
				map[now.r][now.c] += Math.floor(now.age/2);
			}
			
			while(!fall.isEmpty()) { // 가을
				Tree now = fall.remove(0);
				for(int d=0;d<8;d++) {
					int nr = now.r + dr[d];
					int nc = now.c + dc[d];
					if(nr<=0||nc<=0||nr>N||nc>N)
						continue;
					next.add(new Tree(nr, nc, 1));
					answer++;
				}
			}
			
			for(int i=1;i<=N;i++) // 겨울
				for(int j=1;j<=N;j++)
					map[i][j] += A[i][j];
			
			tree = next;
		}
		System.out.println(answer);
	}
}
