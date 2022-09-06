package week5;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_boj_17779_霸府盖歹傅2 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine().trim());
		int[][] A = new int[N+1][N+1];
		int min = Integer.MAX_VALUE;
		int total = 0;
		for(int i=1;i<=N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=1;j<=N;j++)
				total += A[i][j] = Integer.parseInt(st.nextToken());
		}
		
		for(int x=2;x<N-1;x++) {
			for(int y=2;y<N;y++) {
				for(int d1=1;d1<y;d1++) {
					for(int d2=1;(d1+d2)<=N-x && d2<=N-y;d2++) {
						int[] district = new int[5];

						//1备开
						int diff = 0;
						for(int r=1;r<x+d1;r++) {
							diff = r<x ? 0 : diff+1;
							for(int c=1;c<=y-diff;c++)
								district[0] += A[r][c];
						}
						
						//2备开
						diff = 1;
						for(int r=1;r<=x+d2;r++) {
							diff = r<=x ? 1 : diff+1;
							for(int c=y+diff;c<=N;c++)
								district[1] += A[r][c];
						}
						
						//3备开
						diff = 0;
						for(int r=x+d1;r<=N;r++) {
							for(int c=1;c<y-d1+diff;c++)
								district[2] += A[r][c];
							diff = diff<d2 ? diff+1 : diff;
						}
						
						//4备开
						diff = 0;
						for(int r=x+d2+1;r<=N;r++) {
							for(int c=y+d2-diff;c<=N;c++)
								district[3] += A[r][c];
							diff = diff<d1 ? diff+1 : diff;
						}
						
						//5备开
						district[4] = total - district[0] - district[1] - district[2] - district[3];
						Arrays.sort(district);
						min = Math.min(district[4]-district[0], min);
					}
				}
			}
		}
		
		System.out.println(min);
	}
}
