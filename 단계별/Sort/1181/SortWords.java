/*
문제

알파벳 소문자로 이루어진 N개의 단어가 들어오면 아래와 같은 조건에 따라 정렬하는 프로그램을 작성하시오.
 길이가 짧은 것부터
 길이가 같으면 사전 순으로

입력
 첫째 줄에 단어의 개수 N이 주어진다. (1≤N≤20,000) 
 둘째 줄부터 N개의 줄에 걸쳐 알파벳 소문자로 이루어진 단어가 한 줄에 하나씩 주어진다. 
 주어지는 문자열의 길이는 50을 넘지 않는다.

출력

조건에 따라 정렬하여 단어들을 출력한다. 
단, 같은 단어가 여러 번 입력된 경우에는 한 번씩만 출력한다.
*/

import java.io.*;
import java.util.*;

public class SortWords{
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(bf.readLine());
        String[] words = new String[N];
        
        for (int i=0; i<N; i++)
            words[i] = bf.readLine();

        Comparator<String> wordComparator = new Comparator<String>() {
            @Override
            public int compare(String w1, String w2) {
                if (w1.length() == w2.length())
                    return w1.compareTo(w2);
                else
                    return w1.length() - w2.length();
            }
        };
        Arrays.sort(words, wordComparator);

        bw.write(words[0] + "\n");
        for (int i=1; i<N; i++)
            if (words[i].compareTo(words[i-1]) != 0)
                bw.write(words[i] + "\n");
        bw.flush();
        bw.close();
    }
}