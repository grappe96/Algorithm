/*
문제

어느 날, 미르코는 우연히 길거리에서 양수 N을 보았다. 미르코는 30이란 수를 존경하기 때문에, 그는 길거리에서 찾은 수에 포함된 숫자들을 섞어 30의 배수가 되는 가장 큰 수를 만들고 싶어한다.
미르코를 도와 그가 만들고 싶어하는 수를 계산하는 프로그램을 작성하라.

입력

N을 입력받는다. N는 최대 105개의 숫자로 구성되어 있으며, 0으로 시작하지 않는다.

출력

미르코가 만들고 싶어하는 수가 존재한다면 그 수를 출력하라. 
그 수가 존재하지 않는다면, -1을 출력하라.
*/

import java.io.*;

public class Thirty {
    public static void main(String[] args) throws IOException {

        System.setIn(new FileInputStream("test.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String N = br.readLine();
        int[] number = new int[10];
        int sum = 0, no = 0;
        StringBuilder s = new StringBuilder();

        for(int i=0; i<N.length(); i++){
            int num = N.charAt(i) - '0';
            number[num]++;
            sum += num;
        }
        if(number[0] == 0 || sum%3 != 0){
            bw.write("-1\n");
            no = 1;
        }
        if(no == 0){
            for(int i=9; i>=0; i--){
                while(number[i]>0){
                    s.append(i);
                    number[i]--;
                }
            }
            bw.write(s + "\n");
        }
        bw.close();
    }
}