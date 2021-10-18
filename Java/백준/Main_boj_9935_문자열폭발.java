package study;

import java.io.*;
import java.util.Iterator;
import java.util.Stack;

public class Main_boj_9935_¹®ÀÚ¿­Æø¹ß {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		String bomb = br.readLine();
		Stack<Character> stack = new Stack<Character>();
		int len = s.length(), bLen = bomb.length();
		char end = bomb.charAt(bLen-1);
		for(int i=0;i<len;i++) {
			char ch = s.charAt(i);
			stack.push(ch);
			if(ch!=end)
				continue;
			Stack<Character> tmp = new Stack<Character>();
			for(int j=bLen-1;j>=0;j--) {
				if(stack.isEmpty() || stack.peek() != bomb.charAt(j)) {
					while(!tmp.isEmpty())
						stack.push(tmp.pop());
					break;
				}
				tmp.push(stack.pop());
			}
		}
		if(stack.isEmpty())
			System.out.println("FRULA");
		else {
			StringBuilder sb = new StringBuilder();
			Iterator<Character> iter = stack.iterator();
			while(iter.hasNext())
				sb.append(iter.next());
			System.out.println(sb.toString());
		}
	}
}
