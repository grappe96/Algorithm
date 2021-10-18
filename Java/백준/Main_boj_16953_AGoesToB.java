package study;

import java.util.*;

public class Main_boj_16953_AGoesToB {
	static long A, B, min;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		A = sc.nextLong();
		B = sc.nextLong();
		sc.close();
		
		bfs();
		System.out.println(min);
	}
	private static void bfs() {
		Queue<long[]> queue = new LinkedList<long[]>();
		HashSet<Long> hSet = new HashSet<Long>();
		queue.add(new long[] {A, 1});
		hSet.add(A);
		
		while(!queue.isEmpty()) {
			long[] now = queue.poll();
			long twice = now[0]*2;
			StringBuilder sb = new StringBuilder();
			sb.append(now[0]).append(1);
			long addOne = Long.parseLong(sb.toString());
			if(twice == B || addOne == B) {
				min = now[1]+1;
				break;
			}
			if(!hSet.contains(twice) && twice < B) {
				hSet.add(twice);
				queue.add(new long[] {twice, now[1]+1});
			}
			if(!hSet.contains(addOne) && addOne < B) {
				hSet.add(addOne);
				queue.add(new long[] {addOne, now[1]+1});
			}
		}
		if(min == 0)
			min = -1;
	}
}
