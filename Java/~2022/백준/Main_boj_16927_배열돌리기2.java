package study;

import java.io.*;
import java.util.StringTokenizer;

public class Main_boj_16927_�迭������2 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		
		int[][] arr = new int[N][M];
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=0;j<M;j++)
				arr[i][j] = Integer.parseInt(st.nextToken());
		}
		
		int repeat = Math.min(N, M)/2;
		for(int j=0;j<repeat;j++) {
			int newR = R % ((N-j*2)*2+(M-j*2)*2-4);
			for(int k=0;k<newR;k++) {
				int tmp = arr[j][j];
				// ���� ��������
				for(int i=j;i<M-j-1;i++)
					arr[j][i] = arr[j][i+1];
				// ������ ����
				for(int i=j;i<N-j-1;i++)
					arr[i][M-j-1] = arr[i+1][M-j-1];
				// �Ʒ��� ����������
				for(int i=M-j-1;i>j;i--)
					arr[N-j-1][i] = arr[N-j-1][i-1];
				// ���� �Ʒ���
				for(int i=N-j-1;i>j+1;i--)
					arr[i][j] = arr[i-1][j];
				arr[j+1][j] = tmp;
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++)
				sb.append(arr[i][j]).append(" ");
			sb.append("\n");
		}
		
		System.out.print(sb.toString());
	}
}
