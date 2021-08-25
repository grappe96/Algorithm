package week3;

import java.io.*;
import java.util.*;

public class Main_boj_15591_Mootube {
	static class Video { // 유사한 비디오 번호와 유사도를 가진 Video 클래스
		int to, usado;
		
		public Video(int to, int usado) {
			this.to = to;
			this.usado = usado;
		}
	}
	
	static int N, Q;
	static List<Video>[] USADO; // 인접행렬
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		Q = Integer.parseInt(st.nextToken());
		USADO = new ArrayList[N+1];
		
		for(int i=0;i<=N;i++)
			USADO[i] = new ArrayList<Video>();
		
		for(int i=1;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			int p = Integer.parseInt(st.nextToken());
			int q = Integer.parseInt(st.nextToken());
			int r = Integer.parseInt(st.nextToken());
			
			USADO[p].add(new Video(q, r));
			USADO[q].add(new Video(p, r));
		}
		
		StringBuffer sb = new StringBuffer();
		for(int i=0;i<Q;i++) {
			st = new StringTokenizer(br.readLine());
			int k = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			
			sb.append(bfs(k, v)).append("\n");
		}
		System.out.print(sb);
	}
	
	private static int bfs(int k, int v) {
		int[] usado = new int[N+1]; // v와 나머지 동영상의 유사도를 저장할 배열
		Queue<Video> queue = new LinkedList<Video>();
		
		// v와 유사한 동영상 queue에 집어넣기
		for(Video vertex : USADO[v]) {
			queue.add(vertex);
			usado[vertex.to] = vertex.usado;
		}
		
		while(!queue.isEmpty()) {
			Video now = queue.poll();
			
			// queue에 저장된 동영상마다 v이거나 유사도가 없는 동영상 제외하고 가장 작은 유사도 값을 저장
			for(Video vertex : USADO[now.to]) {
				if(vertex.to == v || usado[vertex.to] != 0)
					continue;
				
				usado[vertex.to] = Math.min(vertex.usado, now.usado);
				queue.add(new Video(vertex.to, usado[vertex.to]));
			}
		}
		
		int num = 0;
		for(int n : usado) // k보다 큰 유사도를 가진 동영상 개수 세기
			if(n >= k)
				num++;
		
		return num;
	}
}
