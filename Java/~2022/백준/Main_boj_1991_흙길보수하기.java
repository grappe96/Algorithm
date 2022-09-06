package study;

import java.io.*;
import java.util.*;

public class Main_boj_1991_흙길보수하기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		int[][] pool = new int[N][2];
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine(), " ");
			pool[i][0] = Integer.parseInt(st.nextToken());
			pool[i][1] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(pool, Comparator.comparingInt(o1 -> o1[1]));
		int count = 0, idx = N-1, end = pool[idx][1];
		while(idx >= 0) {
			int length = end - pool[idx][0];
			int tmp = (int) Math.ceil((double)length/L);
			count += tmp;
			tmp *= L;
			if(idx > 0)
				end = end-tmp < pool[idx-1][1] ? end-tmp : pool[idx-1][1];
			idx--;
		}
		System.out.println(count);
	}
}
