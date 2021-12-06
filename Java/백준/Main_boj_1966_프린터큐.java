package study;

import java.io.*;
import java.util.*;

public class Main_boj_1966_프린터큐 {
	static class Doc implements Comparable<Doc>{
		int idx, value;
		public Doc(int idx, int value) {
			this.idx = idx;
			this.value = value;
		}
		
		@Override
		public int compareTo(Doc o) {
			return o.value - this.value;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine().trim());
		StringBuilder sb = new StringBuilder();
		
		for(int tc=1;tc<=T;tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int N = Integer.parseInt(st.nextToken());
			int idx = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine(), " ");
			int[] order = new int[N];
			PriorityQueue<Doc> maxHeap = new PriorityQueue<Doc>();
			Queue<Doc> queue = new LinkedList<Doc>();
			for(int i=0;i<N;i++) {
				order[i] = i;
				int value = Integer.parseInt(st.nextToken());
				maxHeap.offer(new Doc(i, value));
				queue.offer(new Doc(i, value));
			}
			
			int count = 1;
			while(!queue.isEmpty()) {
				Doc now = queue.poll();
				Doc max = maxHeap.peek();
				
				if(max.value > now.value)
					queue.add(now);
				else {
					order[now.idx] = count++;
					maxHeap.poll();
				}
			}
			
			sb.append(order[idx]).append("\n");
		}
		System.out.print(sb.toString());
	}
}
