package week10;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution_swea_올해의조련사 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine().trim());
		StringBuilder sb = new StringBuilder();
		for(int tc=1;tc<=T;tc++) {
			int N = Integer.parseInt(br.readLine().trim());
			char[] names = new char[N];
			for(int i=0;i<N;i++)
				names[i] = br.readLine().charAt(0);
			StringBuilder answer = new StringBuilder();
			int start = 0, end = N-1;
			while(start <= end) {
				char s = names[start], e = names[end];
				if(s < e)
					answer.append(names[start++]);
				else if(e < s)
					answer.append(names[end--]);
				else {
					if(start == end) {
						answer.append(names[start]);
						break;
					}
					
					int front = start+1, rear = end-1;
					while(front < rear && names[front] == names[rear]) {
						front++;
						rear--;
					}
					if(names[front] > names[rear])
						answer.append(names[end--]);
					else
						answer.append(names[start++]);
				}
			}
			
			sb.append("#").append(tc).append(" ").append(answer.toString()).append("\n");
		}
		System.out.print(sb.toString());
	}

}
