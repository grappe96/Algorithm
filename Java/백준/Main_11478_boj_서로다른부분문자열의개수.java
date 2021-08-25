package week4;

import java.util.*;

public class Main_11478_boj_서로다른부분문자열의개수 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String S = sc.next();
		sc.close();
		
		int len = S.length();
		HashSet<String> substr = new HashSet<String>();
		for(int i=1;i<=len;i++)
			for(int j=0;j+i<=len;j++)
				substr.add(S.substring(j, j+i));
		
		System.out.println(substr.size());
	}
}
