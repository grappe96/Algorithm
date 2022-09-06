package study;

import java.io.*;
import java.util.StringTokenizer;

public class Main_boj_20061_모노미노도미노2 {
	static int score = 0, board[][] = new int[10][10], rs = 0, re = 3, grs = 4, gre = 9, gcs = rs, gce = re, brs = rs, bre = re, bcs = 4, bce = 9;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine().trim());
		for(int i=0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int t = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			moveToBlue(t, x, y);
			moveToGreen(t, x, y);
			int c = isBlueFull();
			while(c > -1){
				score++;
				breakBlue(c);
				c = isBlueFull();
			}
			int r = isGreenFull();
			while(r > -1){
				score++;
				breakGreen(r);
				r = isGreenFull();
			}
			checkPaleBlue();
			checkPaleGreen();
		}
		System.out.println(score);
		System.out.println(countTile());
	}
	private static int countTile() {
		int count = 0;
		for(int i=brs;i<=bre;i++)
			for(int j=bcs;j<=bce;j++)
				if(board[i][j]==1)
					count++;
		for(int i=grs;i<=gre;i++)
			for(int j=gcs;j<=gce;j++)
				if(board[i][j]==1)
					count++;
		return count;
	}
	private static void checkPaleGreen() {
		int count = 0;
		for(int i=5;i>=4;i--) {
			for(int j=gcs;j<=gce;j++)
				if(board[i][j] == 1) {
					count++;
					break;
				}
		}
		if(count > 0) {
			int idx = gre;
			for(int i=gre-count;i>=grs;i--) {
				for(int j=gcs;j<=gce;j++)
					board[idx][j] = board[i][j];
				idx--;
			}
			for(int i=5;i>=4;i--)
				for(int j=gcs;j<=gce;j++)
					board[i][j] = 0;
		}
	}
	private static void checkPaleBlue() {
		int count = 0;
		for(int i=5;i>=4;i--) {
			for(int j=brs;j<=bre;j++)
				if(board[j][i] == 1) {
					count++;
					break;
				}
		}
		if(count > 0) {
			int idx = bce;
			for(int i=bce-count;i>=bcs;i--) {
				for(int j=brs;j<=bre;j++)
					board[j][idx] = board[j][i];
				idx--;
			}
			for(int i=5;i>=4;i--)
				for(int j=brs;j<=bre;j++)
					board[j][i] = 0;
		}
	}
	private static void breakGreen(int r) {
		for(int i=gcs;i<=gce;i++)
			board[r][i] = 0;
		for(int i=r;i>grs;i--)
			for(int j=gcs;j<=gce;j++)
				board[i][j] = board[i-1][j];
		for(int i=gcs;i<=gce;i++)
			board[grs][i] = 0;
	}
	private static int isGreenFull() {
		for(int i=gre;i>=grs;i--) {
			int count = 0;
			for(int j=gcs;j<=gce;j++)
				if(board[i][j] == 1)
					count++;
			if(count == 4)
				return i;
		}
		return -1;
	}
	private static void breakBlue(int c) {
		for(int i=brs;i<=bre;i++)
			board[i][c] = 0;
		for(int i=c;i>bcs;i--)
			for(int j=brs;j<=bre;j++)
				board[j][i] = board[j][i-1];
		for(int i=brs;i<=bre;i++)
			board[i][bcs] = 0;
	}
	private static int isBlueFull() {
		for(int i=bce;i>=bcs;i--) {
			int count = 0;
			for(int j=brs;j<=bre;j++)
				if(board[j][i] == 1)
					count++;
			if(count == 4)
				return i;
		}
		return -1;
	}
	private static void moveToGreen(int t, int x, int y) {
		int idx = 0;
		for(int i=grs+2;i<=gre;i++)
			if(board[i][y] == 1 || (t == 2 && board[i][y+1] == 1)) {
				idx = i;
				break;
			}
		
		if(idx == 0)
			idx = 10;
		board[idx-1][y] = 1;
		switch(t) {
		case 2:
			board[idx-1][y+1] = 1;
			break;
		case 3:
			board[idx-2][y] = 1;
			break;
		}
	}
	private static void moveToBlue(int t, int x, int y) {
		int idx = 0;
		for(int i=bcs+2;i<=bce;i++)
			if(board[x][i] == 1 || (t == 3 && board[x+1][i] == 1)) {
				idx = i;
				break;
			}
		if(idx == 0)
			idx = 10;
		
		board[x][idx-1] = 1;
		switch(t) {
		case 2:
			board[x][idx-2] = 1;
			break;
		case 3:
			board[x+1][idx-1] = 1;
			break;
		}
	}
}
