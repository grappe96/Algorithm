/*
문제

유리수 분수를 소수로 나타내면, 소수점 아래 자리가 유한 개인 경우(1/8 = 0.125)와 어떤 자리에서부터 일정한 숫자가 한없이 되풀이 되는 경우(1/11 = 0.090909...)가 있다.
소수를 입력받은 뒤, 분수로 나타내는 프로그램을 작성하시오.

입력

첫째 줄에 테스트 케이스의 개수가 주어진다. 테스트 케이스의 개수는 100개를 넘지 않는다. 각 테스트 케이스는 한 줄에 소수가 하나씩 주어진다.
소수의 첫 두 자리는 "0."이다. 그 다음에는 숫자 0개~6개가 주어진다. 
그 다음, 길이가 1과 9사이면서 괄호로 감싸져있는 수가 주어질 수도 있다. 이 수는 무한히 반복되는 자리를 의미한다.
항상 0이 아닌 자리가 하나는 주어지며, 괄호 안에 주어지는 수는 0이나 9로만 이루어져 있지 않다.

출력

각 테스트 케이스에 대해서, 입력으로 주어진 소수의 분수 표현을 출력한다. (분모와 분자는 서로소이어야 한다)
*/

import java.io.*;

public class Demical2Fraction {
    public static void main(String[] args) throws IOException {

        System.setIn(new FileInputStream("test.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        for(int i=0; i<N; i++){
            String[] demical = br.readLine().split("[.]")[1].split("\\(");
            long n=0, d=1;
            if(demical.length == 1){
                n = Long.parseLong(demical[0]);
                for(int j=0; j<demical[0].length();j++)
                    d*=10;
            }else{
                StringBuilder numer1 = new StringBuilder();
                StringBuilder numer2 = new StringBuilder();
                StringBuilder denomin = new StringBuilder();
                demical[1] = demical[1].replaceAll("\\)", "");
                numer1.append(demical[0]);
                numer1.append(demical[1]);
                numer2.append(demical[0]);
                for(int j=0; j<demical[1].length(); j++)
                    denomin.append(9);
                for(int j=0; j<demical[0].length(); j++)
                    denomin.append(0);
                if(numer2.length() > 0)
                    n = Long.parseLong(numer1.toString()) - Long.parseLong(numer2.toString());
                else
                    n = Long.parseLong(numer1.toString());
                d = Long.parseLong(denomin.toString());
            }
            long a = n, b = d;
            while(b!=0){
                long r = a%b;
                a = b;
                b = r;
            }
            if(a != 1){
                n /= a;
                d /= a;
            }
            bw.write(n + "/" + d + "\n");
        }
        bw.close();
    }
}