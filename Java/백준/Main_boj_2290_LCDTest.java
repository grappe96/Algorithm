package study;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_boj_2290_LCDTest {
	static char[][] answer;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int s = Integer.parseInt(st.nextToken());
		String n = st.nextToken();
		int r = 2*s+3, c = s+2, len = n.length(), cIdx = 0;
		answer = new char[r][c*len+len];
		for(int i=0;i<r;i++)
			Arrays.fill(answer[i], ' ');
		for(int i=0;i<len;i++) {
			char num = n.charAt(i);
			switch(num) {
				case '0':
					drawRow(cIdx+1, cIdx+c-1, 0);
					drawColumn(1, r/2, cIdx);
					drawColumn(1, r/2, cIdx+c-1);
					drawColumn(r/2+1, r-1, cIdx);
					drawColumn(r/2+1, r-1, cIdx+c-1);
					drawRow(cIdx+1, cIdx+c-1, r-1);
					cIdx += c+1;
				break;
				case '1':
					drawColumn(1, r/2, cIdx+c-1);
					drawColumn(r/2+1, r-1, cIdx+c-1);
					cIdx += c+1;
					break;
				case '2':
					drawRow(cIdx+1, cIdx+c-1, 0);
					drawColumn(1, r/2, cIdx+c-1);
					drawRow(cIdx+1, cIdx+c-1, r/2);
					drawColumn(r/2+1, r-1, cIdx);
					drawRow(cIdx+1, cIdx+c-1, r-1);
					cIdx += c+1;
					break;
				case '3':
					drawRow(cIdx+1, cIdx+c-1, 0);
					drawColumn(1, r/2, cIdx+c-1);
					drawRow(cIdx+1, cIdx+c-1, r/2);
					drawColumn(r/2+1, r-1, cIdx+c-1);
					drawRow(cIdx+1, cIdx+c-1, r-1);
					cIdx += c+1;
					break;
				case '4':
					drawColumn(1, r/2, cIdx);
					drawColumn(1, r/2, cIdx+c-1);
					drawRow(cIdx+1, cIdx+c-1, r/2);
					drawColumn(r/2+1, r-1, cIdx+c-1);
					cIdx += c+1;
					break;
				case '5':
					drawRow(cIdx+1, cIdx+c-1, 0);
					drawColumn(1, r/2, cIdx);
					drawRow(cIdx+1, cIdx+c-1, r/2);
					drawColumn(r/2+1, r-1, cIdx+c-1);
					drawRow(cIdx+1, cIdx+c-1, r-1);
					cIdx += c+1;
					break;
				case '6':
					drawRow(cIdx+1, cIdx+c-1, 0);
					drawColumn(1, r/2, cIdx);
					drawRow(cIdx+1, cIdx+c-1, r/2);
					drawColumn(r/2+1, r-1, cIdx);
					drawColumn(r/2+1, r-1, cIdx+c-1);
					drawRow(cIdx+1, cIdx+c-1, r-1);
					cIdx += c+1;
					break;
				case '7':
					drawRow(cIdx+1, cIdx+c-1, 0);
					drawColumn(1, r/2, cIdx+c-1);
					drawColumn(r/2+1, r-1, cIdx+c-1);
					cIdx += c+1;
					break;
				case '8':
					drawRow(cIdx+1, cIdx+c-1, 0);
					drawColumn(1, r/2, cIdx);
					drawColumn(1, r/2, cIdx+c-1);
					drawRow(cIdx+1, cIdx+c-1, r/2);
					drawColumn(r/2+1, r-1, cIdx);
					drawColumn(r/2+1, r-1, cIdx+c-1);
					drawRow(cIdx+1, cIdx+c-1, r-1);
					cIdx += c+1;
					break;
				case '9':
					drawRow(cIdx+1, cIdx+c-1, 0);
					drawColumn(1, r/2, cIdx);
					drawColumn(1, r/2, cIdx+c-1);
					drawRow(cIdx+1, cIdx+c-1, r/2);
					drawColumn(r/2+1, r-1, cIdx+c-1);
					drawRow(cIdx+1, cIdx+c-1, r-1);
					cIdx += c+1;
					break;
			}
		}
		for(int i=0;i<r;i++) {
			for(int j=0;j<c*len+len;j++)
				System.out.print(answer[i][j]);
			System.out.println();
		}
	}
	private static void drawRow(int start, int end, int r) {
		for(int i=start;i<end;i++)
			answer[r][i] = '-';
	}
	private static void drawColumn(int start, int end, int c) {
		for(int i=start;i<end;i++)
			answer[i][c] = '|';
	}
}
