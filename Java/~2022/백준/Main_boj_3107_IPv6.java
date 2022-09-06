package study;

import java.io.*;

//0000:1::
//3
//
//::
//2
//
//1:2:3:4:5:6:7::
//8
//
//::1:2:3:4:5:6:7
//9
public class Main_boj_3107_IPv6 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String origin = br.readLine();
		
		// ::를 :-:로 바꿔 축약이 된 부분은 "-"가 저장되게 바꿈
		String[] s = origin.replace("::", ":-:").split(":");
		int len = s.length;
		StringBuilder add = new StringBuilder();
		// split한 길이가 8보다 작은 경우 == 축약된 부분이 있는 경우
		// 축약이 하나만 된 경우 split한 배열의 길이가 8이 되므로 이 경우를 생각해 모자란 개수-1만큼 0000:을 붙임
		if(len < 8)
			for(int i=0;i<8-len;i++)
				add.append("0000:");

		StringBuilder sb = new StringBuilder();
		// ::가 맨 앞에 붙는 경우 split했을 때 빈 문자열이 맨 앞에 붙어 전체 길이가 9가 되어 이부분 처리
		int start = len > 8 ? len - 8 : 0;
		for(int i=start;i<len;i++) {
			if(s[i].equals("-")) // add를 붙일 때 0000:을 하나 마저 채워줌
				sb.append(add.toString()).append("0000:");
			else {
				// 길이 4가 될 때까지 앞에 0을 붙이고 마지막에 :을 붙임
				while(s[i].length() < 4)
					s[i] = '0' + s[i];
				sb.append(s[i]).append(':');
			}
		}
		//마지막 붙은 :을 제거하기 위해 0부터 38 인덱스까지만 출력
		System.out.println(sb.substring(0, 39));
	}
}
