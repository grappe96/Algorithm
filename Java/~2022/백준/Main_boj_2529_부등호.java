package study;

import java.io.*;
import java.util.*;

public class Main_boj_2529_∫ŒµÓ»£ {
	static int k, number[];
	static boolean[] picked;
	static char[] sign;
	static LinkedList<String> list;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		k = Integer.parseInt(br.readLine().trim());
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		sign = new char[k];
		for(int i=0;i<k;i++)
			sign[i] = st.nextToken().charAt(0);
		number = new int[k+1];
		picked = new boolean[10];
		list = new LinkedList<String>();
		permutation(0);
		Collections.sort(list);
		System.out.println(list.get(list.size()-1));
		System.out.println(list.get(0));
	}
	private static void permutation(int count) {
		if(count == k+1) {
			StringBuilder sb = new StringBuilder();
			for(int i=0;i<k+1;i++)
				sb.append(number[i]);
			list.add(sb.toString());
			return;
		}
		for(int i=0;i<10;i++) {
			if(picked[i])
				continue;
			if(count > 0 && ((sign[count-1] == '>' && number[count-1] < i) || (sign[count-1] == '<' && number[count-1] > i)))
				continue;
			picked[i] = true;
			number[count] = i;
			permutation(count+1);
			picked[i] = false;
		}
	}
}
