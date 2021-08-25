package programmers;

import java.util.*;
import java.util.Map.Entry;

public class Solution_pg_메뉴리뉴얼 {

	public static void main(String[] args) {
		String[] orders = {"XYZ","XWY","WXA"};
		int[] course = {2,3,4};
		String[] answer = solution(orders, course);
		
		print(answer);
	}
	static int N, R, max, idx;
	static char[] menu, pick;
	static HashMap<String, Integer> map;
	public static String[] solution(String[] orders, int[] course) {
		int len = orders.length;
		for(int i=0;i<len;i++) {
			char[] arr = orders[i].toCharArray();
			Arrays.sort(arr);
			StringBuilder sb = new StringBuilder();
			for(char c : arr)
				sb.append(c);
			orders[i] = sb.toString();
		}
		
		ArrayList<String> list = new ArrayList<String>();
		for(int n : course) {
			R = n;
			max = 0;
			pick = new char[R];
			map = new HashMap<String, Integer>();
			for(String order: orders) {
				menu = order.toCharArray();
				N = order.length();
				combination(0,0);
			}
			idx++;
			
			if(max > 1) {
				Set<Entry<String, Integer>> set = map.entrySet();
				Iterator<Entry<String, Integer>> iter = set.iterator();
				while(iter.hasNext()) {
					Entry<String, Integer> entry = iter.next();
					if(entry.getValue() == max)
						list.add(entry.getKey());
				}
			}
		}
		
		len = list.size();
		String[] answer = new String[len];
		for(int i=0;i<len;i++)
			answer[i] = list.get(i);
		Arrays.sort(answer);
		
		return answer;
    }
	private static void combination(int cnt, int start) {
		if(cnt == R) {
			StringBuilder sb = new StringBuilder();
			for(char c : pick)
				sb.append(c);
			String s = sb.toString();
			if(map.containsKey(s))
				map.put(s, map.get(s)+1);
			else
				map.put(s, 1);
			
			max = Math.max(max, map.get(s));
			return;
		}
		for(int i=start;i<N;i++) {
			pick[cnt] = menu[i];
			combination(cnt+1, i+1);
		}
	}
	private static void print(String[] arr) {
		for(String s : arr)
			System.out.print(s+" ");
		System.out.println();
	}
}
