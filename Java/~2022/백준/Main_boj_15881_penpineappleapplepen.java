package week5;

import java.io.*;

public class Main_boj_15881_penpineappleapplepen {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine().trim());
		String list = br.readLine();
		String str = "pPAp";
		int count = 0, len = N-3;
		
		for(int i=0;i<len;i++) {
			if(list.substring(i, i+4).equals(str)) {
				count++;
				i+=3;
			}
		}
		System.out.println(count);
	}
}
