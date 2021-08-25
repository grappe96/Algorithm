package boj;

import java.io.*;
import java.util.StringTokenizer;

public class Main_boj_1074_Z {

	static int r, c, order;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		N = (int)Math.pow(2, N);
		
		order = 0;
		z(N, 0, 0);
	}
	private static void z(int n, int y, int x) {
		if(y == r && x == c) {
			System.out.println(order);
			return;
		}
		
		if(n > 1) {
			int size = n/2;
			if(r>=y&&r<y+n&&c>=x&&c<x+n) {
				z(size, y, x);
				z(size, y, x+size);
				z(size, y+size, x);
				z(size, y+size, x+size);
			} else
				order += n*n;
		} else
			order++;
	}
}
