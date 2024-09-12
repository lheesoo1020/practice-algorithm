import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        int n, m;
        long cnt = 0;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st1 = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st1.nextToken());
        m = Integer.parseInt(st1.nextToken());

        int[] num = new int[n];
        long[] prefixSum = new long[n];
        int[] remain = new int[m];

        StringTokenizer st2 = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            num[i] = Integer.parseInt(st2.nextToken());
        }

        prefixSum[0] = num[0];

        for (int i = 1; i < n; i++) {
            prefixSum[i] = prefixSum[i - 1] + num[i];
        }

        for (int i = 0; i < n; i++) {
            if (prefixSum[i] % m == 0) {
                cnt++;
            }
            remain[(int) (prefixSum[i] % m)]++;
        }

        for (int i = 0; i < m; i++) {
            if (remain[i] > 1) {
                cnt += ((long) remain[i] * (remain[i] - 1)) / 2;
            }
        }

        System.out.println(cnt);

    }
}
