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
		
		// ::�� :-:�� �ٲ� ����� �� �κ��� "-"�� ����ǰ� �ٲ�
		String[] s = origin.replace("::", ":-:").split(":");
		int len = s.length;
		StringBuilder add = new StringBuilder();
		// split�� ���̰� 8���� ���� ��� == ���� �κ��� �ִ� ���
		// ����� �ϳ��� �� ��� split�� �迭�� ���̰� 8�� �ǹǷ� �� ��츦 ������ ���ڶ� ����-1��ŭ 0000:�� ����
		if(len < 8)
			for(int i=0;i<8-len;i++)
				add.append("0000:");

		StringBuilder sb = new StringBuilder();
		// ::�� �� �տ� �ٴ� ��� split���� �� �� ���ڿ��� �� �տ� �پ� ��ü ���̰� 9�� �Ǿ� �̺κ� ó��
		int start = len > 8 ? len - 8 : 0;
		for(int i=start;i<len;i++) {
			if(s[i].equals("-")) // add�� ���� �� 0000:�� �ϳ� ���� ä����
				sb.append(add.toString()).append("0000:");
			else {
				// ���� 4�� �� ������ �տ� 0�� ���̰� �������� :�� ����
				while(s[i].length() < 4)
					s[i] = '0' + s[i];
				sb.append(s[i]).append(':');
			}
		}
		//������ ���� :�� �����ϱ� ���� 0���� 38 �ε��������� ���
		System.out.println(sb.substring(0, 39));
	}
}
