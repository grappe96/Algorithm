package study;

import java.io.*;
import java.util.*;

public class Main_boj_2252_줄세우기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		List<Integer>[] adj = new List[N+1];
		int[] count = new int[N+1];
		
		for(int i=1;i<=N;i++)
			adj[i] = new LinkedList<Integer>();
		
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			adj[A].add(B);
			count[B]++;
		}
		
		Queue<Integer> queue = new LinkedList<Integer>();
		boolean[] visited = new boolean[N+1];
		for(int i=1;i<=N;i++)
			if(count[i] == 0) {
				queue.add(i);
				visited[i] = true;
			}
		
		StringBuilder sb = new StringBuilder();
		while(!queue.isEmpty()) {
			int now = queue.poll();
			sb.append(now).append(" ");
			
			for(int next : adj[now]) {
				if(!visited[next] && --count[next] == 0) {
					visited[next] = true;
					queue.add(next);
				}
			}
		}
		System.out.println(sb.toString());
	}
}
