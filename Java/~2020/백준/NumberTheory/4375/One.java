/*
문제

2와 5로 나누어 떨어지지 않는 정수 n(1 ≤ n ≤ 10000)가 주어졌을 때, 1로만 이루어진 n의 배수를 찾는 프로그램을 작성하시오.

입력

입력을 여러 개의 테스트 케이스로 이루어져 있다. 각 테스트 케이스는 한 줄로 이루어져 있고, n이 주어진다.

출력

1로 이루어진 n의 배수 중 가장 작은 수의 자리수를 출력한다.
*/
import java.io.*;

public class One {
    public static void main(String[] args) throws IOException {

        System.setIn(new FileInputStream("Test/test.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String s = br.readLine();

        while(s != null){
            int len = s.length();
            int n = Integer.parseInt(s);
            StringBuilder sb = new StringBuilder();
            for(int i=0; i<len; i++)
                sb.append(1);
            while(true){
                int mod = 0;
                for(int i=0; i<sb.length(); i++)
                    mod = (mod*10 + (sb.charAt(i)-'0')) % n;
                if(mod == 0){
                    bw.write(sb.length() + "\n");
                    break;
                }
                sb.append(1);
            }
            s = br.readLine();
        }
        bw.close();
    }
}