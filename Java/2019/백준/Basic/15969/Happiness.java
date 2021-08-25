import java.io.*;

public class Happiness {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(bf.readLine());
        String[] num = bf.readLine().split(" ");
        int min, max, tmp, res;
        min = max = Integer.parseInt(num[0]);
        for (int i=1; i<N; i++){
            tmp = Integer.parseInt(num[i]);
            if(tmp < min)
                min = tmp;
            else if(tmp > max)
                max = tmp;
        }
        res = max-min;
        bw.write(res + "\n");
        bw.flush();
        bw.close();
    }
}