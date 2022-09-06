package week4;

import java.util.*;

public class Main_boj_1351_무한수열 {
	
	static Map<Long, Long> map;
	static int P, Q;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long N = sc.nextLong();
		P = sc.nextInt();
		Q = sc.nextInt();
		sc.close();
		
		map = new HashMap<Long, Long>();
		map.put((long) 0, (long) 1);
		System.out.println(dfs(N));
	}
	private static long dfs(long n) {
		if(map.containsKey(n))
			return map.get(n);
		
		long a = Math.floorDiv(n, P);
		long b = Math.floorDiv(n, Q);
		
		long ans = dfs(a) + dfs(b);
		map.put(n, ans);
		
		return ans;
	}
}
