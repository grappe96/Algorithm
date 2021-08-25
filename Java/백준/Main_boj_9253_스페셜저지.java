package week7;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_boj_9253_스페셜저지 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String A = br.readLine();
		String B = br.readLine();
		String C = br.readLine();
		
		if(A.contains(C) && B.contains(C))
			System.out.println("YES");
		else
			System.out.println("NO");
	}
}
