/*
문제

수열 A가 주어졌을 때, 가장 긴 증가하는 부분 수열을 구하는 프로그램을 작성하시오.
예를 들어, 수열 A = {10, 20, 10, 30, 20, 50} 인 경우에 가장 긴 증가하는 부분 수열은 A = {10, 20, 10, 30, 20, 50} 이고, 길이는 4이다.

입력

첫째 줄에 수열 A의 크기 N (1 ≤ N ≤ 1,000,000)이 주어진다.
둘째 줄에는 수열 A를 이루고 있는 Ai가 주어진다. (1 ≤ Ai ≤ 1,000,000)

출력

첫째 줄에 수열 A의 가장 긴 증가하는 부분 수열의 길이를 출력한다.
*/

import java.io.*;
import java.util.*;

public class LongestSub2 {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        ArrayList<Integer> LIS = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        int key, idx;

        key = Integer.parseInt(st.nextToken());
        LIS.add(key);
        for(int i=2;i<=N;i++){
            key = Integer.parseInt(st.nextToken());
            if(LIS.get(LIS.size()-1) < key)
                LIS.add(key);
            else {
                idx = Collections.binarySearch(LIS, key);
                if(idx < 0){
                    idx = -1-idx;
                    LIS.remove(idx);
                    LIS.add(idx, key);
                }
            }
        }
        bw.write(LIS.size() + "\n");
        bw.close();
    }
}