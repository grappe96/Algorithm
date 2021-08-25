package week8;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_boj_6487_두직선의교차여부 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine().trim());
		StringBuilder sb = new StringBuilder();
		for(int tc=1;tc<=N;tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			float x1 = Integer.parseInt(st.nextToken());
			float y1 = Integer.parseInt(st.nextToken());
			float x2 = Integer.parseInt(st.nextToken());
			float y2 = Integer.parseInt(st.nextToken());
			float x3 = Integer.parseInt(st.nextToken());
			float y3 = Integer.parseInt(st.nextToken());
			float x4 = Integer.parseInt(st.nextToken());
			float y4 = Integer.parseInt(st.nextToken());
			
			char intercept1 = 'n', intercept2 = 'n';
			float a1 = 0 , a2 = 0, b1 = 0, b2 = 0;
			if(x1 == x2) { // y축에 평행할 때
				a1 = 0;
				intercept1 = 'x';
				b1 = x1;
			}else {
				a1 = (y2-y1)/(x2-x1);
				if(y1 == y2) { // x축에 평행할 때
					intercept1 = 'y';
					b1 = y1;
				}else
					b1 = y1-x1*a1;
			}
			if(x3 == x4) { // y축에 평행할 때
				a2 = 0;
				intercept2 = 'x';
				b2 = x3;
			}else {
				a2 = (y4-y3)/(x4-x3);
				if(y3 == y4) { //x축에 평행할 때
					intercept2 = 'y';
					b2 = y3;
				}else
					b2 = y3-x3*a2;
			}
			
			if(a1 != a2 || a1==a2 && intercept1 != intercept2) {
				float x = 0, y = 0;
				if(intercept1 == 'x')
					x = b1;
				else if(intercept2 == 'x')
					x = b2;
				else 
					x = (b2-b1)/(a1-a2);
				if(intercept1 == 'y')
					y = b1;
				else if(intercept2 == 'y')
					y = b2;
				else
					y = intercept1 == 'x' ? a2*x+b2 : a1*x+b1;
				
				x = x == 0 ? 0 : x;
				y = y == 0 ? 0 : y;

				sb.append("POINT ").append(String.format("%.2f ", x)).append(String.format("%.2f \n", y));
			}else {
				if(b1 == b2)
					sb.append("LINE\n");
				else
					sb.append("NONE\n");
			}
		}
		System.out.print(sb.toString());
	}
}
