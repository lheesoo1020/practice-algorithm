import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] tri = new int[130000];
        int cursor = 1;

        for (int i = 0; i< n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            while (st.hasMoreTokens()) {
                tri[cursor] = Integer.parseInt(st.nextToken());
                cursor++;
            }
        }
        int result;

        if (n > 1) {
            cursor = 2;

            for (int level = 2; level <= n; level++) {
                tri[cursor] += tri[cursor - level + 1];
                cursor++;
                for (int j = cursor; j < cursor + level - 2; j++) {
                    tri[j] += Integer.max(tri[j - level], tri[j - level + 1]);
                }
                cursor = cursor + level - 2;
                tri[cursor] += tri[cursor - level];
                cursor++;
            }

            cursor = cursor - n + 1;
            result = tri[cursor];

            for (int i = 1; i <= n; i++) {
                if (tri[cursor + i] > result) {
                    result = tri[cursor + i];
                }
            }
        } else {
            result = tri[1];
        }

        bw.write(result + "\n");
        bw.flush();
        bw.close();

    }

}
