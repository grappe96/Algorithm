package study;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_boj_10830_Çà·ÄÁ¦°ö {
	static int N, A[][];
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		long B = Long.parseLong(st.nextToken());
		A = new int[N][N];
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=0;j<N;j++)
				A[i][j] = Integer.parseInt(st.nextToken())%1000;
		}
	
		int[][] answer = pow(A, B);
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++)
				System.out.print(answer[i][j] + " ");
			System.out.println();
		}
	}
	private static int[][] pow(int[][] aPrime, long B) {
		
		if(B == 1)
			return aPrime;
		int[][] half = pow(aPrime, B/2);
		int[][] result = multiplyMatrix(half, half);
		
		if(B%2 == 1)
			result = multiplyMatrix(result, A);
		
		return result;
	}
	private static int[][] multiplyMatrix(int[][] a, int[][] b) {
		int[][] result = new int[N][N];
		
		for(int i=0;i<N;i++)
			for(int j=0;j<N;j++)
				for(int k=0;k<N;k++) {
					result[i][j] += a[i][k] * b[k][j];
					result[i][j] %= 1000;
				}
		
		return result;
	}
}
