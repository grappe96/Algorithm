/*
문제

상근이는 카드 n(4 ≤ n ≤ 10)장을 바닥에 나란히 놓고 놀고있다. 
각 카드에는 1이상 99이하의 정수가 적혀져 있다. 
상근이는 이 카드 중에서 k(2 ≤ k ≤ 4)장을 선택하고, 가로로 나란히 정수를 만들기로 했다. 
상근이가 만들 수 있는 정수는 모두 몇 가지일까?
 예를 들어, 카드가 5장 있고, 카드에 쓰여 있는 수가 1, 2, 3, 13, 21라고 하자. 
 여기서 3장을 선택해서 정수를 만들려고 한다. 
 2, 1, 13을 순서대로 나열하면 정수 2113을 만들 수 있다. 또, 21, 1, 3을 순서대로 나열하면 2113을 만들 수 있다. 
 이렇게 한 정수를 만드는 조합이 여러 가지 일 수 있다.
n장의 카드에 적힌 숫자가 주어졌을 때, 그 중에서 k개를 선택해서 만들 수 있는 정수의 개수를 구하는 프로그램을 작성하시오.

입력

첫째 줄에 n이, 둘째 줄에 k가 주어진다. 
셋째 줄부터 n개 줄에는 카드에 적혀있는 수가 주어진다.

출력

첫째 줄에 상근이가 만들 수 있는 정수의 개수를 출력한다.
*/

import java.io.*;
import java.util.*;

public class SetCard {
    public static HashMap<String, Integer> card = new HashMap<>();
    public static ArrayList<Integer> num = new ArrayList<>();
    public static void main(String[] args) throws IOException {

        System.setIn(new FileInputStream("test.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine()); 
        LinkedList<Integer> list = new LinkedList<>();
        int[] check = new int[N];

        for(int i=0; i<N; i++){
            int n = Integer.parseInt(br.readLine());
            num.add(n);
        }
        permutation(list, check, N, K);
        bw.write(card.size() + "\n");
        bw.close();
    }
    public static void permutation(LinkedList<Integer> l, int[] chk, int n, int r) {
		if(l.size() == r){
            StringBuilder sb = new StringBuilder();
			for(int i : l)
                sb.append(i);
            String s = sb.toString();
            card.put(s, 1);
			return;
		}
		for(int i=0; i<n; i++){
			if(chk[i] == 0){
				chk[i] = 1;
				l.add(num.get(i));
				permutation(l, chk, n, r);
				l.removeLast();
				chk[i] = 0;
			}
		}
		
	}
}