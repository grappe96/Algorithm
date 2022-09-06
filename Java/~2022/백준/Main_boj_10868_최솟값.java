package week8;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_boj_10868_ÃÖ¼Ú°ª {
	static int[] num, tree;
	static final int max = 1000000001;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		num = new int[N+1]; 
		for(int i=1;i<=N;i++)
			num[i] = Integer.parseInt(br.readLine().trim());
		
		tree = new int[N*4];
		insert(1, N, 1);
		
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
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
	private static int find(int start, int end, int idx, int a, int b) {
		if(start > b || end < a)
			return max;
		if(start >= a && end <= b)
			return tree[idx];
		
		int mid = (start + end) / 2;
		return Math.min(find(start, mid, idx*2, a, b), find(mid+1, end, idx*2+1, a, b));
	}
}
