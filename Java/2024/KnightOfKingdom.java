import java.io.*;

public class KnightOfKingdom {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int c, r, dr[] = {2, 2, 1, -1, -2, -2, 1, -1}, dc[] = {1, -1, 2, 2, 1, -1, -2, -2}, count = 0;
        char[] input = br.readLine().toCharArray();
        c = input[0] - 'a' + 1;
        r = input[1] - '1' + 1;
       
        for (int d = 0; d < 8; d++) {
            int nr = r + dr[d];
            int nc = c + dc[d];

            if (nr < 1 || nc < 1 || nr > 8 || nc > 8) {
                continue;
            }
            count++;
        }

        bw.append(Integer.toString(count));
        bw.flush();
        bw.close();
    }
}
