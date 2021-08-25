package week8;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_boj_10173_니모를찾아서 {
	static String end = "EOI";
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		StringBuilder sb = new StringBuilder();
		while(!s.equals(end)) {
			int len = s.length()-3;
			char[] arr = s.toCharArray();
			boolean check = false;
			for(int i=0;i<len;i++) {
				char c = arr[i];
				if(c == 'n' || c == 'N') {
					c = arr[i+1];
					if(c == 'e' || c == 'E') {
						c = arr[i+2];
						if(c == 'm' || c == 'M') {
							c = arr[i+3];
							if(c == 'o' || c == 'O') {
								check = true;
								break;
							}
						}
					}
				}
			}
			if(check)
				sb.append("Found\n");
			else
				sb.append("Missing\n");
			s = br.readLine();
		}
		System.out.println(sb.toString());
	}
}
