/*
문제

두 전봇대 A와 B 사이에 하나 둘씩 전깃줄을 추가하다 보니 전깃줄이 서로 교차하는 경우가 발생하였다. 
합선의 위험이 있어 이들 중 몇 개의 전깃줄을 없애 전깃줄이 교차하지 않도록 만들려고 한다.
전깃줄이 전봇대에 연결되는 위치는 전봇대 위에서부터 차례대로 번호가 매겨진다. 
전깃줄의 개수와 전깃줄들이 두 전봇대에 연결되는 위치의 번호가 주어질 때, 남아있는 모든 전깃줄이 서로 교차하지 않게 하기 위해 없애야 하는 전깃줄의 최소 개수를 구하는 프로그램을 작성하시오.

입력

첫째 줄에는 두 전봇대 사이의 전깃줄의 개수가 주어진다. 전깃줄의 개수는 100 이하의 자연수이다. 
둘째 줄부터 한 줄에 하나씩 전깃줄이 A전봇대와 연결되는 위치의 번호와 B전봇대와 연결되는 위치의 번호가 차례로 주어진다. 
위치의 번호는 500 이하의 자연수이고, 같은 위치에 두 개 이상의 전깃줄이 연결될 수 없다.

출력

첫째 줄에 남아있는 모든 전깃줄이 서로 교차하지 않게 하기 위해 없애야 하는 전깃줄의 최소 개수를 출력한다.
*/

import java.io.*;
import java.util.*;

public class Wire {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int[][] con = new int[N][2];
        ArrayList<Integer> LIS = new ArrayList<>();
        int idx;
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            con[i][0] = Integer.parseInt(st.nextToken());
            con[i][1] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(con, new Comparator<int[]>() {
            @Override
            public int compare(int[] a1, int[] a2){
                return a1[0] - a2[0];
            }
        });
        LIS.add(con[0][1]);
        for(int i=1;i<N;i++){
            if(LIS.get(LIS.size()-1) < con[i][1])
                LIS.add(con[i][1]);
            else {
                idx = Collections.binarySearch(LIS, con[i][1]);
                if(idx < 0){
                    idx = -1-idx;
                    LIS.remove(idx);
                    LIS.add(idx, con[i][1]);
                }
            }
        }
        bw.write(N-LIS.size() + "\n");
        bw.close();
    }
}