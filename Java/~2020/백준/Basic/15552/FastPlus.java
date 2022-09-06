import java.io.*;

public class FastPlus {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(bf.readLine());
        String[] num;
        int a, b, result;
        for (int i = 0; i<T; i++) {
            num = bf.readLine().split(" ");
            a = Integer.parseInt(num[0]);
            b = Integer.parseInt(num[1]);
            result = a+b;
            bw.write(result + "\n");
        }
        bw.flush();
        bw.close();
    }
}