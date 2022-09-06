package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_boj_14438_¼ö¿­°úÄõ¸®17 {
	static final int MAX = 1000000001;
	static int[] num, tree;
	public static void main(String[] args) throws Exception {	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine().trim());
		num = new int[N+1];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=1;i<=N;i++)
			num[i] = Integer.parseInt(st.nextToken());
		tree = new int[N*4];
		insert(1, N, 1);
	
		int M = Integer.parseInt(br.readLine().trim());
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			String query = st.nextToken();
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			if(query.equals("1")) {
				num[a] = b;
				change(1, N, 1, a);
			} else
				sb.append(find(1, N, 1, a, b)).append("\n");
		}
		System.out.print(sb.toString());
	}
	private static int insert(int start, int end, int idx) {
		if(start == end)
			return tree[idx] = num[start];
		
		int mid = (start + end) / 2;
		return tree[idx] = Math.min(insert(start, mid, idx*2), insert(mid+1, end, idx*2+1));
	}
	private static int find(int start, int end, int idx, int i, int j) {
		if(start > j || end < i)
			return MAX;
		if(start >= i && end <= j)
			return tree[idx];
		int mid = (start + end) / 2;
		return Math.min(find(start, mid, idx*2, i, j), find(mid+1, end, idx*2+1, i, j));
	}
	private static int change(int start, int end, int idx, int pos) {
		if(start == end && start == pos)
			return tree[idx] = num[pos];
		if(start > pos || end < pos)
			return tree[idx];
		int mid = (start + end) / 2;
		return tree[idx] = Math.min(change(start, mid, idx*2, pos), change(mid+1, end, idx*2+1, pos));
	}
}
