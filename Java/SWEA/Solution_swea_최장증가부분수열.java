package week10;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution_swea_최장증가부분수열 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine().trim());
		StringBuilder sb = new StringBuilder();
		for(int tc=1;tc<=T;tc++) {
			int N = Integer.parseInt(br.readLine().trim());
			ArrayList<Integer> LIS = new ArrayList<Integer>();
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int num = Integer.parseInt(st.nextToken());
			LIS.add(num);
			for(int i=1;i<N;i++) {
				num = Integer.parseInt(st.nextToken());
				if(LIS.get(LIS.size()-1) <= num)
					LIS.add(num);
				else {
					int idx = Collections.binarySearch(LIS, num);
					if(idx < 0)
						LIS.set(Math.abs(idx)-1, num);
				}
			}
			sb.append("#").append(tc).append(" ").append(LIS.size()).append("\n");
		}
		System.out.println(sb.toString());
	}
}
