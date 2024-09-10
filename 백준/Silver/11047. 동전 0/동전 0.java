import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();

        String[] token = str.split(" ");

        int n = Integer.parseInt(token[0]);
        int k = Integer.parseInt(token[1]);
        int cnt = 0;

        int[] coins = new int[n];

        for (int i = 0; i < n; i++) {
            coins[i] = Integer.parseInt(br.readLine());
        }

        for (int i = n-1; i >= 0; i--) {
            while(k - coins[i] >= 0) {
                k -= coins[i];
                cnt++;
            }
        }

        System.out.println(cnt);

    }
}
