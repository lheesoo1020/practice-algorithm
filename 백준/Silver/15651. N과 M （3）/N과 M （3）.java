import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] result = new int[m+1];

        dfs(1, n, m, result);

        bw.close();

    }

    public static void dfs(int depth, int n, int m, int[] result) throws IOException {
        if (depth == m+1) {
            for (int i = 1; i < m+1; i++) {
                bw.write(result[i] + " ");
            }
            bw.write("\n");
            return;
        }
        for (int i = 1; i <= n; i++) {
            result[depth] = i;
            dfs(depth + 1, n, m, result);
        }
    }
}

