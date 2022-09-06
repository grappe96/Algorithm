package study;

import java.io.*;
import java.util.*;

public class Main_boj_1062_°¡¸£Ä§ {
	static int N, K, max;
	static String[] arr;
	static boolean[] visited;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		K-=5;
		if(K < 0)
			System.out.println(0);
		else {
			visited = new boolean[26];
			String regex = "[antic]";
			for(int i=1;i<=5;i++)
				visited[regex.charAt(i)-97] = true;
			arr = new String[N];
			for(int i=0;i<N;i++)
				arr[i] = br.readLine().replaceAll(regex, "");
			combination(0, 0);
			System.out.println(max);
		}
	}
	private static void combination(int start, int count) {
		if(count == K) {
			int result = 0;
			for(String s : arr) {
				int len = s.length();
				boolean check = false;
				for(int i=0;i<len;i++)
					if(!visited[s.charAt(i)-97]) {
						check = true;
						break;
					}
				if(!check)
					result++;
			}
			max = Math.max(max, result);
		}
		for(int i=start;i<26;i++) {
			if(!visited[i]) {
				visited[i] = true;
				combination(i+1, count+1);
				visited[i] = false;
			}
		}
	}
}
