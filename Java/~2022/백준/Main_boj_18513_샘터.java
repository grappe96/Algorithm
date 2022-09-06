package boj;

import java.io.*;
import java.util.*;

public class Main_boj_18513_ป๙ลอ {

	static int N, K;
	static long answer;
	static int[] house, dc = {1, -1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		house = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++)
			house[i] = Integer.parseInt(st.nextToken());
		
		bfs();
		System.out.println(answer);
	}
	
	private static void bfs() {
		Queue<int[]> queue = new LinkedList<int[]>();
		Set<Integer> visited = new HashSet<Integer>();
		
		int k = K;
		for(int i=0;i<N;i++) {
			visited.add(house[i]);
			queue.add(new int[] {house[i], house[i]});
		}
		
		while(!queue.isEmpty()) {
			int[] next = queue.poll();
			
			for(int d=0;d<2;d++) {
				int nx = next[0] + dc[d];
				if(!visited.contains(nx)) {
					visited.add(nx);
					queue.add(new int[] {nx, next[1]});
					k--;
					answer += Math.abs(nx - next[1]);
					if(k == 0)
						return;
				}
			}
			
		}
	}
}