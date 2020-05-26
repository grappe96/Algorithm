/*
문제

개똥벌레 한 마리가 장애물(석순과 종유석)로 가득찬 동굴에 들어갔다. 
동굴의 길이는 N미터이고, 높이는 H미터이다. (N은 짝수) 
첫 번째 장애물은 항상 석순이고, 그 다음에는 종유석과 석순이 번갈아가면서 등장한다.
이 개똥벌레는 장애물을 피하지 않는다. 
자신이 지나갈 구간을 정한 다음 일직선으로 지나가면서 만나는 모든 장애물을 파괴한다.
동굴의 크기와 높이, 모든 장애물의 크기가 주어진다. 
이때, 개똥벌레가 파괴해야하는 장애물의 최솟값과 그러한 구간이 총 몇 개 있는지 구하는 프로그램을 작성하시오.

입력

첫째 줄에 N과 H가 주어진다. 
N은 항상 짝수이다. (2 ≤ N ≤ 200,000, 2 ≤ H ≤ 500,000)
다음 N개 줄에는 장애물의 크기가 순서대로 주어진다. 
장애물의 크기는 H보다 작은 양수이다.

출력

첫째 줄에 개똥벌레가 파괴해야 하는 장애물의 최솟값과 그러한 구간의 수를 공백으로 구분하여 출력한다.
*/

import java.io.*;
import java.util.*;

public class Firefly {
    public static void main(String[] args) throws IOException {

        System.setIn(new FileInputStream("test.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());
        int[] stlg = new int[H];
        int[] stlc = new int[H];
        int min, section, g, c;

        for(int i=1; i<=N/2; i++){
            stlg[Integer.parseInt(br.readLine())]++;
            stlc[Integer.parseInt(br.readLine())]++;
        }
        g = N/2;
        c = 0;
        min = g+c;
        for(int i=2; i<=H; i++){
            g -= stlg[i-1];
            c += stlc[H-(i-1)];
            if(min > g+c)
                min = g+c;
        }
        g = N/2;
        c = 0;
        section = 0;
        if(min == g+c)
            section++;
        for(int i=2; i<=H; i++){
            g -= stlg[i-1];
            c += stlc[H-(i-1)];
            if(g+c == min)
                section++;
        }
        bw.write(min + " " + section + "\n");
        bw.close();
    }
}