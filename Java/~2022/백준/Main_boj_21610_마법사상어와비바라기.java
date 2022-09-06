package study;

import java.io.*;
import java.util.StringTokenizer;

public class Main_boj_21610_마법사상어와비바라기 {
	static int N, M, A[][], cloud[][], dr[] = {0,0,-1,-1,-1,0,1,1,1}, dc[] = {0,-1,-1,0,1,1,1,0,-1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		A = new int[N][N];
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=0;j<N;j++)
				A[i][j] = Integer.parseInt(st.nextToken());
		}
		cloud = new int[N][N];
		cloud[N-1][0] = cloud[N-1][1] = cloud[N-2][0] = cloud[N-2][1] = 1;
		for(int i=0;i<M;i++) {
			int[] spell = new int[2];
			st = new StringTokenizer(br.readLine(), " ");
			spell[0] = Integer.parseInt(st.nextToken());
			spell[1] = Integer.parseInt(st.nextToken());
			cloud = move(spell[0], spell[1]);
			rainNDisappear();
			copyWaterBug();
			makeCloud();
		}
		int answer = 0;
		for(int i=0;i<N;i++)
			for(int j=0;j<N;j++)
				answer += A[i][j];
		System.out.println(answer);
	}
	private static void makeCloud() {
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(cloud[i][j] == -1)
					cloud[i][j] = 0;
				else if(A[i][j] >= 2) {
					A[i][j] -= 2;
					cloud[i][j] = 1;
				}
			}
		}
	}
	private static void copyWaterBug() {
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(cloud[i][j] == -1) {
					int count = 0;
					for(int d=2;d<9;d+=2) {
						int nr = i+dr[d];
						int nc = j+dc[d];
						
						if(nr<0||nc<0||nr>=N||nc>=N||A[nr][nc]==0)
							continue;
						count++;
					}
					A[i][j] += count;
				}
			}
		}
	}
	private static void rainNDisappear() {
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(cloud[i][j] == 1) {
					A[i][j]++;
					cloud[i][j] = -1;
				}
			}
		}
	}
	private static int[][] move(int d, int s) {
		int[][] result = new int[N][N];
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(cloud[i][j] == 1) {
					int nr = i+dr[d]*s;
					if(nr < 0)
						while(nr < 0)
							nr += N;
					else
						nr %= N;
					int nc = j+dc[d]*s;
					if(nc < 0)
						while(nc < 0)
							nc += N;
					else
						nc %= N;
					result[nr][nc] = 1;
				}
			}
		}
		return result;
	}
}
