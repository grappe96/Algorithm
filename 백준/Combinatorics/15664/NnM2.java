/*
문제

N개의 자연수와 자연수 M이 주어졌을 때, 아래 조건을 만족하는 길이가 M인 수열을 모두 구하는 프로그램을 작성하시오.
 N개의 자연수 중에서 M개를 고른 수열
 고른 수열은 비내림차순이어야 한다.
 길이가 K인 수열 A가 A1 ≤ A2 ≤ ... ≤ AK-1 ≤ AK를 만족하면, 비내림차순이라고 한다.

입력

첫째 줄에 N과 M이 주어진다. (1 ≤ M ≤ N ≤ 8)
둘째 줄에 N개의 수가 주어진다. 입력으로 주어지는 수는 10,000보다 작거나 같은 자연수이다.

출력

한 줄에 하나씩 문제의 조건을 만족하는 수열을 출력한다. 
중복되는 수열을 여러 번 출력하면 안되며, 각 수열은 공백으로 구분해서 출력해야 한다.
수열은 사전 순으로 증가하는 순서로 출력해야 한다.
*/

import java.io.*;
import java.util.*;

public class NnM2 {
    public static ArrayList<String> seq = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        
        System.setIn(new FileInputStream("Test/test.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] num = new int[N];
        LinkedList<Integer> list = new LinkedList<>();
        int[] check = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++)
            num[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(num);
        permutation(list, num, check, N, M, 0);
        for(String s : seq)
            bw.write(s + "\n");
        bw.close();
    }
    public static void permutation(LinkedList<Integer> l, int[] num, int[] chk, int n, int m, int st) {
		if(l.size() == m){
            StringBuilder sb = new StringBuilder();
            for(int i : l){
                sb.append(i);
                sb.append(" ");
            }
            String s = sb.toString();
            if(!seq.contains(s))
                seq.add(s);
			return;
		}
		for(int i=st; i<n; i++){
			if(chk[i] == 0){
				chk[i] = 1;
				l.add(num[i]);
				permutation(l, num, chk, n, m, i);
				l.removeLast();
				chk[i] = 0;
			}
		}
	}
}